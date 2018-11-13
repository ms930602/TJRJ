<template>
	<yd-layout id='carSell' >
		<div class="assessOut">
			<yd-navbar title="必填信息">
				<router-link to="car_sell" slot="left">
					<yd-navbar-back-icon></yd-navbar-back-icon>
				</router-link>
			</yd-navbar>
			<yd-cell-group class="bt-group">
				<div class="title-a">车辆基础信息</div>
				<br/>
				<hr/>
				<yd-cell-item>
					<p slot="left"><span class="index_c">*</span>车系/品牌</p>
					<input slot="right" type="text" placeholder="请输入品牌" v-model="form.brand">
				</yd-cell-item>
				<yd-cell-item>
					<p slot="left"><span class="index_c">*</span>车型</p>
					<input slot="right" type="text" placeholder="如:宝马1系2018款" v-model="form.type">
				</yd-cell-item>
				<yd-cell-item>
					<p slot="left"><span class="index_c">*</span>上牌地点</p>
					<input slot="right" type="text" placeholder="如:四川成都" v-model="form.bkCitiy">
				</yd-cell-item>
				<yd-cell-item arrow>
					<p slot="left"><span class="index_c">*</span>上牌时间</p>
					<yd-datetime type="date" slot="right" v-model="form.upbkTime"></yd-datetime>
				</yd-cell-item>
				<yd-cell-item>
					<p slot="left"><span class="index_c">*</span>行驶里程</p>
					<input slot="right" type="text" v-model="form.mileage">
					<span slot="right">(万公里)</span>
				</yd-cell-item>
			</yd-cell-group>
			<yd-cell-group >
				<div class="title-a">车源图片</div>
				<br/>
				<hr/>
				<div >
					<br/>
					<yd-cell-item>
						<div slot="left">
							<el-upload
							class="avatar-uploader"
							:action="uploadURL"
							:show-file-list="false"
							:on-success="topSuccess"
							accept="image/*"
							:on-progress="uploadVideoProcess"
							:before-upload="topBeforeUpload">
							<img v-if="imageUrl" :src="imageUrl" class="avatar">
							<i v-if="(videoFlag == false && !imageUrl)" class="el-icon-picture-outline avatar-uploader-icon"></i>
							<i v-if="(videoFlag == true && !imageUrl)" class="el-icon-loading avatar-uploader-icon"></i>
							</el-upload>
						</div>
						<div slot="right" style="text-align: left;width: 100%;">
							<p class="img-title-a">&nbsp;上传一张车辆正45°照片</p>
							<br/>
							&nbsp;&nbsp;提示：横向牌照更清晰.
						</div>
						</yd-cell-item>
					<br/>
					
				</div>
			</yd-cell-group>
			<yd-cell-group>
				<div class="title-a">价格信息</div>
				<br/>
				<hr/>
				<yd-cell-item>
					<span slot="left"><span class="index_c" >*</span>预期售价：</span>
					<input slot="right" type="number" placeholder="请输入预期售价" v-model="form.price">
					<span slot="right">(万元)</span>
				</yd-cell-item>
				<yd-cell-item type="label">
					<div slot="left">是否包含过户费</div>
					<yd-switch slot="right" v-model="ydswitch"></yd-switch>
				</yd-cell-item>
			</yd-cell-group>
			<yd-cell-group>
				<div class="title-a">联系方式</div>
				<br/>
				<hr/>
				<yd-cell-item>
					<span slot="left"><span class="index_c">*</span>手机号码：</span>
					<input slot="right" type="text" placeholder="请输入手机号码" v-model="form.phone">
				</yd-cell-item>
				<br/>
				<div style="width:100%;display: flex;">
					<button class="btn-wen" @click="save()">
						提交审核
					</button>
				</div>
				<div class="butt-div">
					<p style="font-size: .25rem;color:#555;">
					&nbsp;&nbsp;&nbsp;&nbsp;
					您的个人信息已经提交，可能会受到买车意向客户的咨询，(如个人、经销商、中介机构等)，
					请保持电话畅通并保证车辆信息的真实性。提交及代表您同意《个人信息保护声明》</p>
				</div>
			</yd-cell-group>
			<yd-backtop></yd-backtop>
		</div>
	</yd-layout>
</template>

<script>
	import {BackTop} from 'vue-ydui/dist/lib.rem/backtop';
	import { SendCode } from 'vue-ydui/dist/lib.rem/sendcode';
	import { Accordion, AccordionItem } from 'vue-ydui/dist/lib.rem/accordion';
	import {CellGroup, CellItem} from 'vue-ydui/dist/lib.rem/cell';
	import {NavBar,NavBarBackIcon} from 'vue-ydui/dist/lib.rem/navbar';
	import {DateTime} from 'vue-ydui/dist/lib.rem/datetime';
	import {FlexBox, FlexBoxItem} from 'vue-ydui/dist/lib.rem/flexbox';
	import {Switch} from 'vue-ydui/dist/lib.rem/switch';
	import {Button} from 'vue-ydui/dist/lib.rem/button';
	import uploadOneImg from '../../components/uploadOneImg.vue'
	import { Upload, Dialog } from 'element-ui';
	export default {
		components: {
			[SendCode.name]: SendCode,
			[Accordion.name]: Accordion,
			[AccordionItem.name]: AccordionItem,
			[BackTop.name]: BackTop,
			[CellGroup.name]: CellGroup,
			[CellItem.name]: CellItem,
			[NavBar.name]: NavBar,
			[NavBarBackIcon.name]: NavBarBackIcon,
			[DateTime.name]: DateTime,
			[FlexBox.name]: FlexBox,
			[FlexBoxItem.name]: FlexBoxItem,
			[Switch.name]: Switch,
			[Button.name]: Button,
			[uploadOneImg.name]:uploadOneImg,
			[Upload.name]: Upload,
			[Dialog.name]: Dialog,
			
		},
		data() {
			return {
        datetime3: '2018-11-01',
				ydswitch:false,
				imageUrl:'',
				uploadURL:'',
				submitObj:{},
				form:{
					brand:'',
					type:'',
					bkCitiy:'',
					upbkTime:'2018-11-01',
					mileage:null,
					price:null,
					phone:'',
					status:'0',
					imgId:null,
					imgPath:'',
				},
				videoFlag:false
			}
		},
		created() {

		},
		watch: {

		},
		computed: {

		},
		mounted() {
		},
		methods: {
			uploadVideoProcess(event, file, fileList){
					this.videoFlag = true;
			},
			assessFlag(){
				if(this.form.imgId==null || this.form.imgId ==''){
					this.$dialog.toast({
						mes: '请上传一张车身照！',
						timeout: 1000
					});
					return false;
				}
				if(this.form.price==null || this.form.price <= 0){
					this.$dialog.toast({
						mes: '请输入正确的预售价格！',
						timeout: 1000
					});
					return false;
				}
				if(this.form.brand==null || this.form.brand==''){
					this.$dialog.toast({
						mes: '请输入正确的车系！',
						timeout: 1000
					});
					return false;
				}
				if(this.form.type==null || this.form.type==''){
					this.$dialog.toast({
						mes: '请输入正确的车型！',
						timeout: 1000
					});
					return false;
				}
				if(this.form.bkCitiy==null || this.form.bkCitiy==''){
					this.$dialog.toast({
						mes: '请输入正确的上牌地点！',
						timeout: 1000
					});
					return false;
				}
				if(this.form.mileage==null || this.form.mileage==''){
					this.$dialog.toast({
						mes: '请输入正确的里程数！',
						timeout: 1000
					});
					return false;
				}
				var reg=/^1[345789][0-9]{9}$/;
				if(!reg.test(this.form.phone)){
					this.$dialog.toast({
						mes: '请输入正确的手机号！',
						timeout: 1000
					});
					return false;
				}
				return true;
			},
			save(){
				if(this.ydswitch){
					this.form.status = '1';
				}
				if(!this.assessFlag())return;
				if(this.form.phone == this.submitObj.phone &&
				this.form.brand == this.submitObj.brand &&
				this.form.type == this.submitObj.type
				){
					this.$dialog.toast({
						mes: '已预约，客服马上与您联系！',
						timeout: 1500
					});
					return;
				}
				this.submitObj = this.form;
				this.$root.ajax({
					name:'carTo/saveCarUser',
					params:this.submitObj,
				}).then((d)=>{
					if(d.state == 0){
						this.$dialog.toast({
							mes: '成功预约，客服马上与您联系！',
							timeout: 1500
						});
					}else{
						this.$dialog.toast({
							mes: '预约失败，后台错误！',
							timeout: 1500
						});
					}
				})
			},
			topSuccess(res, file) {
				this.videoFlag = false;
				this.videoUploadPercent = 0;
				if(res.state == 0){
					this.form.imgId = res.aaData.loadId;
					this.form.imgPath = res.aaData.path;
					this.imageUrl = this.$root.config.img_url+ res.aaData.path;
				}else{
					this.$message({ type: "error", message: "上传失败!" });
				}
			},
			topBeforeUpload(file) {
				return new Promise((resolve, reject) => {
						this.$nextTick(() => {
										var fileType = file.type
										//图片限制4M，其他附件限制50M
										let limitType = 10
										this.uploadURL = this.$root.config.api_url+'baseUploadfilerecode/upload?savePath=caruser'
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

<style lang='scss'>
	.assessOut{
			background-color: #eee;
	}
	#carSell{
		.bt-group{
			p{
				width: 1.7rem;
			}
		}
		.btn-wen{
			border: 1px solid;
			color:#586ac7;
			width: 80%;
			height: .7rem;
			margin: 0 auto;
			background-color: #fffffff2;
			font-size: .3rem;
			border-radius: .05rem;
		}
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
			font-size: .5rem;
			color: #8c939d;
			width: 2.2rem;
			height: 1.6rem;
			line-height: 1.6rem;
			text-align: center;
		  }
		  .avatar {
			width: 2rem;
			height: 1.6rem;
			display: block;
		  }
		.img-title-a{
			font-size: .3rem;
			color: #606266;
		}
		.index_c{
			color: red;
		}
		.butt-div{
			margin-top: .2rem;
			width: 100%;
			p{
				width: 92%;
				margin: 0 auto;
			}
		}
		.title-a{
			line-height: 30px;
			font-size: .30rem;
			margin-left: .15rem;
			color: #555;
		}
		.yd-cell-left{
			border-bottom: 1px #d6d6d6 solid;
		}
		.yd-cell-right{
			border-bottom: 1px #d6d6d6 solid;
		}
	}
</style>