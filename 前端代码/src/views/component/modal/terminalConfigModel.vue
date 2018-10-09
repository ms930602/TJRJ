<template>
	<el-dialog custom-class="jz-modal" :title="terminalConfigModelType === 'add' ? '新增终端配置' : '终端配置编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" width="45%">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="终端类型" prop="terminalType" v-if="terminalConfigModelType === 'add'">
                            <selectInput :value.sync="form.terminalType" filterable @selectChange="claSelectChange" :clearable="true">
                                <el-option v-for="item in claList" :key="item.id" :label="item.dicName" :value="item.dicCode">
                                </el-option>
                            </selectInput>
                        </el-form-item>
                        <el-form-item label="终端类型" prop="terminalType" v-if="terminalConfigModelType != 'add'">
                            <selectInput :value.sync="form.terminalType"  disabled :clearable="true">
                                <el-option
                                v-for="item in claList"
                                :key="item.id"
                                :label="item.dicName"
                                :value="item.dicCode"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" >
                        <el-form-item label="属性名" prop="key" v-if="terminalConfigModelType != 'add'">
                            <span>{{form.key}}</span>
                        </el-form-item>
                        <el-form-item label="属性名" prop="key" v-else>
                             <inputItem :value.sync="form.key"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="属性值" prop="value">
                            <inputItem :value.sync="form.value"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-form-item label="是否已发布" prop="isRelease" label-width="92px;"> 
                        <el-select v-model="form.isRelease" placeholder="请选择是否已发布">
                        <el-option label="是" value="1"></el-option>
                        <el-option label="否" value="0"></el-option>
                        </el-select>
                    </el-form-item>
                </el-row>

            </el-form>              
            <div slot="footer" class="dialog-footer flex-x-end">
                <elBtn @click="cancel" text="取消">取消</elBtn>
                <elBtn @click="submit" type="primary" text="提交">提交</elBtn>
            </div>
        </el-dialog>
</template>
<script>
import mixin from '../../../mixin/mixin.js'
import local from '../../../local.js'
	export default {
        mixins: [mixin],
		data() {
            var vm = this
            return {
				form: {
                    terminalType: '',
                    key: '',
                    value: '',
                    isRelease:''
                },
                baseConfigList: [],
                rules: {
                    terminalType: [{required: true, message: '终端类型不能为空' }],
                    isRelease: [{required: true, message: '是否发布不能为空' }],
                    key: [{required: true, message: '属性名不能为空' }, this._ruleLength(45)],
                    value: [{required: true, message: '属性值不能为空' }, this._ruleLength(100)]
                },
                selectCla:{},
                claList:[],
                upDownoptions:[],
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            terminalConfigModelType: {
                default: 'add'
            },
            terminalConfig: {
                default: {}
            },
            baseConfig: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
            Object.assign(this.form, this.terminalConfig)   
            let method = 'dictionary/list';
            this._ajax({url: this.rootAPI + method, param: {
                'claCode':'TERMINAL_TYPE'
            }})
            .then((function(d) {
				this.claList = d.aaData;
                // console.log(d.aaData)
            }).bind(this));
            this.getupdown();
		},
		methods: {
            getupdown() {
                return this._searchDic("IS_PUBLISHED").then(
                    function(d) {
                    this.upDownoptions = this._dicKey(d);
                    }.bind(this)
                    
                );
                
                },
            claSelectChange(ob){
                var obj = this.claList.find((item)=>{//这里的userList就是上面遍历的数据源
                    return item.terminalType === ob;//筛选出匹配数据
                });
                // console.log(obj);
                this.form.terminalType = obj.terminalType;
                this.form.claName = obj.claName;
                // console.log(this.form.terminalType);
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'baseConfig/update';
                        if(this.terminalConfigModelType === 'add') {  
                            method = 'baseConfig/create' 
                            o = {
                                terminalType: this.form.terminalType,
                                key: this.form.key,
                                value: this.form.value,
                                isRelease: this.form.isRelease,
                                createdPersonId: this.thisUser.userId,
                                createdPerson: this.thisUser.nickName
                            }
                        }else {
                            o = {
                                terminalType: this.form.terminalType,
                                key: this.form.key,
                                value: this.form.value,
                                isRelease: this.form.isRelease,
                                id: this.form.id,
                                updatedPersonId: this.thisUser.userId,
                                updatedPerson: this.thisUser.nickName
                            }
                        }
                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }else if(d.state === 2){
                                this.$message({ type: 'warning', message: '没有要修改的记录！' });
                            }else if(d.state === 1){
                                this.$message({ type: 'warning', message: '字典编码重复！' });
                            }
                            else{
                                this.$message({ type: 'warning', message: '操作失败'+ d.msg });
                            }
                        }).bind(this))
                    }
                })
			},
            beforeClose(done) {
                this.cancel()
                done()
            },
		}
	}
</script>