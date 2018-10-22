<template>
	<el-dialog custom-class="jz-modal" :title="modalTypeTitle === 'add' ? '新增商户信息' : '编辑商户信息'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="商户名称" prop="name">
                            <inputItem :value.sync="form.name"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="手机号码" prop="phone">
                            <inputItem :value.sync="form.phone"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="微信号" prop="vxNum">
                            <inputItem :value.sync="form.vxNum"></inputItem>
                        </el-form-item>
                    </el-col>
                    <!-- <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="备注" prop="remark">
                            <inputItem type="textarea" :value.sync="form.remark"></inputItem>
                        </el-form-item>
                    </el-col> -->
                </el-row>
            </el-form>              
            <div slot="footer" class="dialog-footer flex-x-end">
                <elBtn @click="cancel" text="取消">取消</elBtn>
                <elBtn @click="submit" type="primary" text="提交">提交</elBtn>
            </div>
        </el-dialog>
</template>
<script>
import mixin from '../../mixin/mixin.js'
import local from '../../local.js'
import configs from "../../configs.js";
	export default {
        mixins: [mixin],
		data() {
            var vm = this
            return {
				form: {
                    id:null,
                    name: '',
                    phone: '',
                    vxNum: ''
                },
                gameOption: [],
                rules:{
                     name: [{required: true, message: '商户名称不能为空' }, this._ruleLength(200)],
                     vxNum: [{required: true, message: '微信号不能为空' }, this._ruleLength(16)]
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
            Object.assign(this.form, this.objItem)
		},
		methods: {
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'vxMerchant/update';
                        if(this.modalTypeTitle === 'add') {  
                            method = 'vxMerchant/create' 
                            o = {
                                name: this.form.name,
                                phone: this.form.phone,
                                vxNum: this.form.vxNum
                            }
                        }else {
                            o = {
                                name: this.form.name,
                                phone: this.form.phone,
                                vxNum: this.form.vxNum,
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