<template>
	<el-dialog custom-class="jz-modal" :title="personInfoModalType === 'add' ? '新增品牌信息' : '咨询品牌编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" >
            <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                        <el-form-item label="名称:" prop="name">
                            <inputItem :value.sync="form.name"></inputItem>
                        </el-form-item>
                    </el-col>
                </el-row>
				<el-row>
					<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
						<el-form-item label="图标:" prop="imgId">
							<el-upload
								class="avatar-uploader"
								:action="uploadURL"
								:show-file-list="false"
								:on-success="topSuccess"
								accept="image/*"
								:before-upload="topBeforeUpload">
								<img v-if="imageUrl" :src="imageUrl" class="avatar">
								<i v-else class="el-icon-plus avatar-uploader-icon"></i>
							</el-upload>
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
				imageUrl:'',
                uploadURL:'',
				form: {
                    name: '',
                    imgId: ''
                },
				rules: {
					name: [this._ruleRequired("名称")],
					imgId: [this._ruleRequired("图标")],
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
			topBeforeUpload(file) {
				return new Promise((resolve, reject) => {
					this.$nextTick(() => {
						var fileType = file.type
						//图片限制4M，其他附件限制50M
						let limitType = 10
						this.uploadURL = configs.uploadFileURL + '/file/imgUpload?savePath=car&token=' + local.get('token')
						const isLt = file.size / 1024 / 1024 < limitType;
						if (!isLt) {
							this.$message.error('上传文件大小不能超过 '+limitType+'MB!');
							reject()
						}else {
							resolve()
						}
					})
				})  
			},
			topSuccess(res, file) {
				if(res.state == 0){
					this.form.imgId = res.aaData.loadId;
					this.imageUrl = ROOT_API+'servlet/getfile?path=' + res.aaData.path;
				}else{
					this.$message({ type: "error", message: "上传失败!" });
				}
			},
            claSelectChange(ob){
               
            },
			cancel() {
				this.$emit('close')
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'carBrand/update';
                        if(this.personInfoModalType === 'add') {  
                            method = 'carBrand/create' 
                            o = {
                                name: this.form.name,
                                imgId: this.form.imgId
                            }
                        }else {
                            o = {
                                name: this.form.name,
                                imgId: this.form.imgId,
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

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>