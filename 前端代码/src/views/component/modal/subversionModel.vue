<template>
	<el-dialog custom-class="jz-modal" :title="personInfoModalType === 'add' ? '新增版本' : '包装版本'" :visible="modal"
     :before-close="beforeClose" :close-on-click-modal="false" :width="300">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="名称" prop="subverName">
                            <inputItem :value.sync="form.subverName"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="状态" prop="status">
                            <selectInput :value.sync="form.status">
                                <el-option
                                  v-for="item in statusList"
                                  :key="item.key"
                                  :label="item.value"
                                  :value="item.key">
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
import configs from "../../../configs.js";
	export default {
        mixins: [mixin],
		data() {
            var vm = this
            return {
                value4: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
				form: {
                    subverName: '',
                    dataId:'',
                    pacsCode: '',
                    converCoef: '',
                    status: '2'
                },
                statusList: [],
                rules: {
                    subverName: [
                        this._ruleRequired("名称"),
                        this._ruleExist(configs.rootAPI + "subversion/checkSubverName", "名称",this.personinfo),
                        this._ruleLength(25)
                    ]
                },
                thisUser: local.get('userinfo')
			}
		},
		props: {
			modal: {
				default: false
			},
            personInfoModalType: {
                default: 'add'
            },
            personinfo: {
                default: function() {
                    return {}
                }
            }
		},
        computed: {
           
        },
		mounted() {
           Object.assign(this.form, this.personinfo)
           this._searchDic('IS_PSTATUS')
            .then((function(d) {
                this.statusList = this._dicKey(d)
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
                        let o = {}, method = 'subversion/update';
                        if(this.personInfoModalType === 'add') {  
                            method = 'subversion/create' 
                            o = {
                                subverName: this.form.subverName,
                                status: this.form.status,
                                createdPersonId: this.thisUser.userId,
                                createdPerson: this.thisUser.nickName
                            }
                        }else {
                            o = {
                                subverName: this.form.subverName,
                                status: this.form.status,
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
                                this.$message({ type: 'warning', message: '该登录账号已被绑定，不能重复绑定！' });
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