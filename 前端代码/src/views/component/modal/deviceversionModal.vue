<template>
	<el-dialog custom-class="jz-modal" :title="deviceversionModalType === 'add' ? '新增系统版本' : '系统版本编辑'" :visible="modal" :before-close="beforeClose" :close-on-click-modal="false" :width="modalWidth">
        <el-form class="modal-form" v-if="modal" :model="form" ref="form" :inline="true" :rules="rules" label-width="80px">
            <el-row>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="版本号" prop="version" label-width="100px" v-if="deviceversionModalType ==='add'">
                        <inputItem  :value.sync="form.version" required maxlength="50" placeholder></inputItem>
						<span><font color='red'>格式为：1.1.1</font></span>
                    </el-form-item>
					 <el-form-item label="版本号" prop="version" required label-width="100px" v-if="deviceversionModalType ==='edit'"> 
						<span>{{form.version}}</span>
                    </el-form-item>
                </el-col>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="设备类型" prop="deviceType" required v-if="deviceversionModalType ==='add'">
						<selectInput :value.sync="form.deviceType" >
							<el-option
							v-for="item in dataDic.deviceType"
							:key="item.dicName"
							:label="item.dicName"
							:value="item.dicCode">
							</el-option>
						</selectInput>
                    </el-form-item>
					 <el-form-item label="设备类型" prop="deviceType" required v-if="deviceversionModalType ==='edit'">
						<selectInput :value.sync="form.deviceType" disabled>
							<el-option
							v-for="item in dataDic.deviceType"
							:key="item.dicName"
							:label="item.dicName"
							:value="item.dicCode">
							</el-option>
						</selectInput>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
				 <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="设备型号"  prop="deviceModel" label-width="100px">
                       <inputItem :value.sync="form.deviceModel"></inputItem>
                    </el-form-item>
                </el-col>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="生产厂家"  prop="manufacturer">
                        <inputItem :value.sync="form.manufacturer"></inputItem>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="是否必须更新" prop="isNeedUpdate" required label-width="100px">
					    <selectInput :value.sync="form.isNeedUpdate" >
							<el-option
						      v-for="item in dataDic.whether"
						      :key="item.dicName"
						      :label="item.dicName"
						      :value="item.dicCode">
						    </el-option>
						</selectInput>
                    </el-form-item>
                </el-col>
				<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item label="版本状态" required prop="versionStatus">
					    <selectInput :value.sync="form.versionStatus" >
							<el-option
						      v-for="item in dataDic.versionStatus"
						      :key="item.dicName"
						      :label="item.dicName"
						      :value="item.dicCode">
						    </el-option>
						</selectInput>
                    </el-form-item>
                </el-col>
            </el-row>
        	<el-row>
        		<el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12">
                    <el-form-item  label="版本文件" prop="versionFile">
					    <uploadItem @success="uploadSuccess" :uploadData="uploadData" @remove="uploadRemove" :fileList="uploadList" uploadTip="" list-type="text" ></uploadItem>
                    </el-form-item>
                </el-col>
    		</el-row>
        </el-form>              
        <div slot="footer" class="dialog-footer flex-x-end">
            <elBtn @click="cancel" text="取消"></elBtn>
            <elBtn @click="submit" text="提交" type="primary"></elBtn>
        </div>
    </el-dialog>
</template>
<script>
	import local from '../../../local.js'
	import mixin from '../../../mixin/mixin.js'
	export default {
        mixins: [mixin],
		data() {
            var vm = this
			return {
				form: {
					deviceType : '',
					manufacturer : '',
					deviceModel : '', 
					version : '',
					channelCode : '',
					isNeedUpdate : '',
					versionStatus: ''
                },
                uploadfile:{
                	id:'',
                	filePath:'',
					fileSize:'',
					fileName:'',
					fileType:''
               },
                rules: {
					version: [{required: true, message: '版本号不能为空' }],
					versionStatus: [{required: true, message: '版本状态不能为空' }],
					isNeedUpdate: [{required: true, message: '是否必须更新不能为空' }],
					deviceType: [{required: true, message: '设备类型不能为空' }]
				},
				
                dateTime: [],
                uploadData: {
                    savePath: 'deviceVersion'
                },
				uploadList: [],
				claList:[],
                manufacturerList: [],
                deviceModelList: []
			}
		},
		props: {
			modal: {
				default: false
			},
			deviceversionModalType: {
				default: "add"
			},
            deviceVersion: {
                default: {}
            },
            dataDic:{
            	default: {}
			},
			placeholder: {
				default: '版本号格式为：1.1.1'
			},
		},
        computed: {
            userID() {
                console.log(this.userId)
                return this.userId
            }
        },
		mounted() {
            Object.assign(this.form, this.deviceVersion)
            this.getInitData();
		},
		methods: {
			cancel() {
				this.$emit('close')
			},
			getInitData() {
				if(this.deviceversionModalType === 'edit') {
					if(this.deviceVersion.fileId) {
						this._ajax({url: this.rootAPI + "baseUploadfilerecode/getById", param: {"id":this.deviceVersion.fileId}})
		                .then((function(response) {
		                	let fileMsg = response.aaData;
		                	if(fileMsg && fileMsg.fileName) {
		                		let fileTypeTemp = fileMsg.fileName.split('.');
			                	this.uploadfile = {
			                		id:fileMsg.id,
			                		filePath : fileMsg.filePath,
			                		fileSize : fileMsg.fileSize,
			                		fileName : fileMsg.fileName,
			                		fileType : fileTypeTemp[fileTypeTemp.length - 1]
		                		}
			                	this.uploadList.push({"name" : fileMsg.fileName, "url" : fileMsg.filePath});
		                	}
		                }).bind(this))
					}
	            }
			},
			submit() {
                this.$refs['form'].validate((valid) => {
                    if (valid) {
                        let o = {}, method = 'baseDeviceversion/createOrUpdateUnionFile';
                        let id = this.form.id;
                        if(this.deviceversionModalType === 'add') {
                            id = null;
                        }
                        o = {
                                deviceType : this.form.deviceType,
								manufacturer : this.form.manufacturer,
								deviceModel : this.form.deviceModel,
								version : this.form.version,
								channelCode : this.form.channelCode,
								isNeedUpdate : this.form.isNeedUpdate,
								versionStatus : this.form.versionStatus,
								uploadfile : this.uploadfile,
								id : id
                        }
                        let user = local.get('sessionUser');
                        if(this.deviceversionModalType === 'add') {
                            o.id = null;
                            o.createdPersonId = user.userId;
							o.createdPersonName = user.nickName;
                        } else if(this.deviceversionModalType === 'edit') {
                        	o.lastModifyPersonId = user.userId;
							o.lastModifyPersonName = user.nickName;
                        }
                        o = JSON.stringify(o);
//                      console.info(o);
                        this._ajax({url: this.rootAPI + method, param: {"jsonStr":o}})
                        .then((function(d) {
							console.log(d)
                        	if(d.state == 0) {
                        		this.$message({ type: 'success', message: '操作成功' }); 
                        	} else {
                        		this.$message({ type: 'failure', message: '操作失败:'+d.msg }); 
                        	}
                            this.$emit('submit')
                        }).bind(this))
                    }
                })
			},
            beforeClose(done) {
                this.cancel()
                done()
            },
            uploadSuccess(response, file, fileList) {
//          	console.info(response);
            	if(response.state == 0) {
            		this.uploadfile.id = '';
            		this.uploadfile.filePath = response.aaData.path;
	            	this.uploadfile.fileSize = response.aaData.size;
	            	this.uploadfile.fileName = file.name;
	            	let fileTypeTemp = file.name.split('.');
	            	this.uploadfile.fileType = fileTypeTemp[fileTypeTemp.length - 1];
            	}
            },
            uploadRemove(file, fileList) {
                Object.assign(this.form, {
                    filePath: ''
                })
            },
		}
	}
</script>