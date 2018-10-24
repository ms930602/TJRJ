<template>
	<el-upload
      :action="uploadURL"
      :file-list="fileList"
      :on-success="uploadSuccess"
      :data="uploadData"
      :limit="limit"
      class="avatar-uploader"
      :multiple='multiple'
      :on-remove="onRemove"
      :accept="accept"
      :before-upload="beforeUpload">
      <elBtn text="点击上传" type="primary" v-if="buttonType === 'button'"></elBtn>
      <i class="el-icon-plus" v-if="buttonType === 'icon'"></i>
      <div slot="tip" class="el-upload__tip">{{uploadTip}}</div>
    </el-upload>
</template>
<script>
import configs from '../../configs.js'
import local from '../../local.js'
import elBtn from './elBtn.vue'
	export default {
		name: 'uploadItem',
		components: {elBtn},
		data() {
			return {
				uploadURL: ''
			}
		},
		props: {
			fileList: {
				default: function() {
					return []
				}
			},
			uploadData: {
				default: function() {
					return {}
				}
			},
			limit: {
				default: 1
			},
			uploadTip:{
				default:'只能上传jpg/png文件，且不超过500kb'
			},
			accept:{
				default:'image/*'
			},
			multiple:{
				type:Boolean,
				default:false,
			},
			buttonType: {
				default: "button"
			}
		},
		methods: {
			uploadSuccess(response, file, fileList) {
				this.$emit('success', response, file, fileList)
			},
			onRemove(file, fileList) {
				this.$emit('remove', file, fileList)
			},
			beforeUpload(file) {
				return new Promise((resolve, reject) => {
		          this.$nextTick(() => {
		            var fileType = file.type
		            //图片限制4M，其他附件限制50M
					let limitType = 10
					if(typeof fileType === 'string' && fileType.indexOf("image") === -1) {
						this.uploadURL = configs.uploadFileURL + '/file/upload?savePath=vx&token=' + local.get('token')
						limitType = 50
					}else if(typeof fileType === 'string') {
						this.uploadURL = configs.uploadFileURL + '/file/imgUpload?savePath=vx&token=' + local.get('token')
					}
			        const isLt = file.size / 1024 / 1024 < limitType;
			        if (!isLt) {
			          this.$message.error('上传文件大小不能超过 '+limitType+'MB!');
			          reject()
			        }else {
			        	resolve()
			        }
		          })
		        })			
	      	}
		}
	}
</script>