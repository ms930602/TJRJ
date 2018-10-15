<template>
	<el-dialog custom-class="jz-modal" :title="personInfoModalType === 'add' ? '新增人员信息' : '人员信息编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="登录用户" prop="loginName">
                            <selectInput :value.sync="form.loginName" filterable :clearable="true">
                                <el-option
                                v-for="item in loginUserList"
                                :key="item.id"
                                :label="item.loginName"
                                :value="item.loginName"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="姓名" prop="personName">
                            <inputItem :value.sync="form.personName"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="部门" prop="department">
                            <selectInput :value.sync="form.department" filterable :clearable="true">
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
                        <el-form-item label="工号" prop="jobno">
                            <inputItem :value.sync="form.jobno"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="性别" prop="sex">
                            <el-radio v-model="form.sex" label="1">男</el-radio>
                            <el-radio v-model="form.sex" label="0">女</el-radio>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="邮箱" prop="email">
                            <inputItem :value.sync="form.email"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="是否可用" prop="enabled">
                            <switchItem :value.sync="form.enabled" :activeValue="1" :inactiveValue="0"></switchItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="备注" prop="remark">
                            <inputItem type="textarea" :value.sync="form.remark"></inputItem>
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
                    loginName: '',
                    personName: '',
                    department: '',
                    sex: '1',
                    jobno: '',
                    email: '',
                    enabled: 1,
                    remark: ''
                },
                dictionaryList: [],
                rules: {
                    loginName: [{required: true, message: '登录用户不能为空' }],
                    personName: [{required: true, message: '姓名不能为空' }, this._ruleLength(16)],
                    // department: [{required: true, message: '部门不能为空' }],
                    jobno: [{required: true, message: '工号不能为空' }, this._ruleLength(16)],
                  //  email: [{required: false},this._ruleEmail()],
                    remark: [{required: false}, this._ruleLength(100)]
                },
                loginUserList: [],
                departmentList: [],
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
            let method = 'user/list';
            this._ajax({url: this.userAPI + method, param: {'extend':'true'}})
            .then((function(d) {
				this.loginUserList = d.aaData;
                console.log(d.aaData)
			}).bind(this))

            let method2 = 'department/list';
            this._ajax({url: this.rootAPI + method2, param: {'enabled':1}})
            .then((function(d) {
				this.departmentList = d.aaData;
                console.log(d.aaData)
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
                        let o = {}, method = 'personinfo/update';
                        if(this.personInfoModalType === 'add') {  
                            method = 'personinfo/create' 
                            o = {
                                loginName: this.form.loginName,
                                personName: this.form.personName,
                                department: this.form.department,
                                sex: this.form.sex,
                                jobno: this.form.jobno,
                                email: this.form.email,
                                enabled: this.form.enabled,
                                remark: this.form.remark,
                                createdPersonId: this.form.userId,
                                createdPerson: this.form.nickName
                            }
                        }else {
                            o = {
                                loginName: this.form.loginName,
                                personName: this.form.personName,
                                department: this.form.department,
                                sex: this.form.sex,
                                jobno: this.form.jobno,
                                email: this.form.email,
                                enabled: this.form.enabled,
                                remark: this.form.remark,
                                id: this.form.id,
                                updatedPersonId: this.form.userId,
                                updatedPerson: this.form.nickName
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