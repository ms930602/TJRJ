<template>
	<el-dialog custom-class="jz-modal" :title="departmentModalType === 'add' ? '新增部门信息' : '部门信息编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="部门名称" prop="depName">
                             <inputItem :value.sync="form.depName"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="部门负责人" label-width="100px" prop="depPrincipal">
                            <selectInput :value.sync="form.depPrincipal" filterable :clearable="true">
                                <el-option
                                v-for="item in personinfoList"
                                :key="item.id"
                                :label="item.personName"
                                :value="item.personName"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="父级部门" prop="parentName">
                            <selectInput :value.sync="form.parentName" filterable :clearable="true" @selectChange="depSelectChange">
                                <el-option
                                v-for="item in departmentList"
                                :key="item.id"
                                :label="item.depName"
                                :value="item.depName"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="部门职责简述" label-width="100px" prop="descript">
                            <inputItem :value.sync="form.descript"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="是否可用" prop="enabled">
                            <switchItem :value.sync="form.enabled" :activeValue="1" :inactiveValue="0"></switchItem>
                        </el-form-item>
                    </el-col>
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
                value4: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
				form: {
                    depName: '',
                    depPrincipal: '',
                    parentId: '',
                    parentName: '',
                    descript: '',
                    enabled: 1,
                    id: ''
                },
                dictionaryList: [],
                rules: {
                    depName: [this._ruleRequired('部门名称'), this._ruleLength(45)],
                    // depPrincipal: [this._ruleRequired('部门负责人')],
                    // parentName: [this._ruleRequired('父级部门')],
                    descript: [this._ruleLength(100)]
                },
                personinfoList: [],
                departmentList: [],
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            departmentModalType: {
                default: 'add'
            },
            departmentinfo: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
            Object.assign(this.form, this.departmentinfo)    
            let method = 'personinfo/list';
            this._ajax({url: this.rootAPI + method, param: {'enabled':1}})
            .then((function(d) {
				this.personinfoList = d.aaData;
			}).bind(this))

            let method2 = 'department/list';
            this._ajax({url: this.rootAPI + method2, param: {parentId: 0}})
            .then((function(d) {
                if(this.form.parentName == ''){
                    this.form.parentId = 0;
                    this.form.parentName = '顶级分类';
                }

                if(this.departmentModalType != 'add' && d.aaData != null){
                    for(var i = 0; i < d.aaData.length; i++)
                    {
                        if(d.aaData[i].id == this.form.id){
                            d.aaData.splice( i, 1);
                            break;
                        }
                    }
                }

                d.aaData.unshift({
                    id : 0,
                    depName : '顶级分类'
                });
				this.departmentList = d.aaData;
                // console.log(d.aaData)
			}).bind(this))
		},
		methods: {
            depSelectChange(ob){
                var obj = this.departmentList.find((item)=>{//这里的userList就是上面遍历的数据源
                    return item.depName === ob;//筛选出匹配数据
                });
                if(obj == null){
                    this.form.parentId = "0";
                }
                else{
                    this.form.parentId = obj.id;;
                }
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'department/update';
                        if(this.departmentModalType === 'add') {  
                            method = 'department/create' 
                            o = {
                                depName: this.form.depName,
                                depPrincipal: this.form.depPrincipal,
                                parentId: this.form.parentId,
                                enabled: this.form.enabled,
                                descript: this.form.descript,
                                createdPersonId: this.thisUser.userId,
                                createdPerson: this.thisUser.nickName
                            }
                        }else {
                            o = {
                                depName: this.form.depName,
                                depPrincipal: this.form.depPrincipal,
                                parentId: this.form.parentId,
                                enabled: this.form.enabled,
                                descript: this.form.descript,
                                id: this.form.id,
                                updatedPersonId: this.thisUser.userId,
                                updatedPerson: this.thisUser.nickName
                            }
                        }
                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            debugger;
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }else if(d.state === 2){
                                this.$message({ type: 'warning', message: '没有要修改的记录！' });
                            }else if(d.state === 1){
                                this.$message({ type: 'warning', message: d.msg });
                            }
                            else{
                                this.$message({ type: 'warning', message: '操作失败' });
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