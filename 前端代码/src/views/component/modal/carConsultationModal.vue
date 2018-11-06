<template>
	<el-dialog custom-class="jz-modal" :title="personInfoModalType === 'add' ? '新增咨询信息' : '咨询信息编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="手机号:" prop="phone">
                            {{form.phone}}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="车辆标题:" prop="carTitle">
                            {{form.carTitle}}
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="创建时间:" prop="createtime">
                            {{form.createtime}}
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="状态:" prop="status">
                            <selectInput :value.sync="form.status" :clearable="false">
                                <el-option
                                v-for="item in statusOption"
                                :key="item.key"
                                :label="item.value"
                                :value="item.key"
                                >
                                </el-option>
                            </selectInput>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="咨询内容:" prop="context">
                            <inputItem type="textarea" :value.sync="form.context" :autosize="{ minRows: 5}" :disabled="true"></inputItem>
                        </el-form-item>
                    </el-col>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="备注:" prop="remark">
                            <inputItem type="textarea" :value.sync="form.remark" :autosize="{ minRows: 5}"></inputItem>
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
                statusOption:[{key:'0',value:'未处理'},{key:'1',value:'已锁定'},{key:'2',value:'已处理'}],
				form: {
                    phone: '',
                    carTitle: '',
                    status: '',
                    createtime: '',
                    context: '',
                    remark: '',
                }
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
                        let o = {}, method = 'consultation/update';
                        if(this.personInfoModalType === 'add') {  
                            method = 'consultation/create' 
                            o = {
                                phone: this.form.phone,
                                carTitle: this.form.carTitle,
                                status: this.form.status,
                                createtime: this.form.createtime,
                                context: this.form.context,
                                remark: this.form.remark
                            }
                        }else {
                            o = {
                                phone: this.form.phone,
                                carTitle: this.form.carTitle,
                                status: this.form.status,
                                createtime: this.form.createtime,
                                context: this.form.context,
                                remark: this.form.remark,
                                id: this.form.id
                            }
                        }
                        this._ajax({url: this.rootAPI + method, param: o})
                        .then((function(d) {
                            if(d.state === 0) {
                                this.$message({ type: 'success', message: '操作成功' }); 
                                this.$emit('submit')
                            }else{
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