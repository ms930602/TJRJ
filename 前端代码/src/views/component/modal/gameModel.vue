<template>
	<el-dialog custom-class="jz-modal" :title="modalTypeTitle === 'add' ? '新增游戏信息' : '编辑游戏信息'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="游戏名称" prop="name">
                            <inputItem :value.sync="form.name"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="类型" prop="type">
                            <selectInput :value.sync="form.type" :clearable="false">
                                <el-option
                                v-for="item in typeList"
                                :key="item.key"
                                :label="item.value"
                                :value="item.key"
                                >
                                </el-option>
                            </selectInput>
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
                    id:null,
                    name: '',
                    type: '0'
                },
                typeList: [],
                rules: {
                    name: [{required: true, message: '游戏名称不能为空' }],
                    type: [{required: true, message: '游戏类型不能为空' }]
                },
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            modalTypeTitle: {
                default: 'add'
            },
            objItem: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
            this._searchDic('GAME_TYPE')
            .then((function(d) {
                this.typeList = this._dicKey(d)
                Object.assign(this.form, this.objItem);
            }).bind(this))
		},
		methods: {
            claSelectChange(ob){
               
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'gameMs/update';
                        if(this.modalTypeTitle === 'add') {  
                            method = 'gameMs/create' 
                            o = {
                                name: this.form.name,
                                type: this.form.type
                            }
                        }else {
                            o = {
                                name: this.form.name,
                                type: this.form.type,
                                id: this.form.id
                            }
                        }
                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }
                            else{
                                this.$message({ type: 'warning', message: '操作失败:'+d.msg });
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