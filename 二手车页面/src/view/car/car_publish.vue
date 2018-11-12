<template>
	<yd-layout id='carSell'>
		<yd-navbar title="必填信息">
			<router-link to="car_sell" slot="left">
				<yd-navbar-back-icon></yd-navbar-back-icon>
			</router-link>
			<router-link to="#" slot="right">
				保存
			</router-link>
		</yd-navbar>
		<yd-cell-group>
			<div class="title-a">车辆基础信息</div>
			<br/>
			<hr/>
			<yd-cell-item>
				<span slot="left"><span class="index_c">*</span>车系/品牌：</span>
				<input slot="right" type="text" placeholder="如:宝马,奥迪等">
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left"><span class="index_c">*</span>车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</span>
				<input slot="right" type="text" placeholder="如:宝马1系2018款">
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left"><span class="index_c">*</span>上牌地点：</span>
				<input slot="right" type="text" placeholder="如:四川成都">
			</yd-cell-item>
			<yd-cell-item arrow>
				<span slot="left"><span class="index_c">*</span>上牌时间：</span>
				<yd-datetime type="month" v-model="datetime3" slot="right"></yd-datetime>
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left"><span class="index_c">*</span>行驶里程：</span>
				<input slot="right" type="text">
				<span slot="right">(万公里)</span>
			</yd-cell-item>
		</yd-cell-group>
		<yd-cell-group style="height: 200px;">
			<div class="title-a"><span class="index_c">*</span>车源图片</div>
			<br/>
			<hr/>
			<div style="height: 140px;">
				<br/>
				<div class="img-div">
					<el-upload
					class="avatar-uploader"
					action=""
					:show-file-list="false"
					:on-success="handleAvatarSuccess"
					:before-upload="beforeAvatarUpload">
					<img v-if="imageUrl" :src="imageUrl" class="avatar">
					<i v-else class="el-icon-picture-outline avatar-uploader-icon"></i>
					</el-upload>
				</div>
				<div class="img-div-a">
					<p class="img-title-a">上传一张车辆正45°照片</p>
					<p class="img-title-b">
					据统计，买车人更喜欢查看
					有图车源，售出率更高哦。</p>
				</div>
			</div>
		</yd-cell-group>
		<yd-cell-group>
			<div class="title-a">价格信息</div>
			<br/>
			<hr/>
			<yd-cell-item>
				<span slot="left"><span class="index_c" >*</span>预期售价：</span>
				<input slot="right" type="number" placeholder="请输入预期售价">
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
				<input slot="right" type="text" placeholder="请输入手机号码">
			</yd-cell-item>
			<br/>
			<div style="width:100%;">
				<yd-button size="large" color="#586ac7" style="border: 1px solid;width: 80%;height: .7rem;margin: 0 auto;background-color: #fffffff2;">
					提交审核
				</yd-button>
			</div>
			<div class="butt-div">
				<p>
				&nbsp;&nbsp;&nbsp;&nbsp;您的个人信息已经提交，可能会受到买车意向客户的咨询，(如个人、经销商、中介机构等)，
				请保持电话畅通并保证车辆信息的真实性。提交及代表您同意《个人信息保护声明》</p>
			</div>
		</yd-cell-group>
		<yd-backtop></yd-backtop>
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
			[Dialog.name]: Dialog
		},
		data() {
			return {
                datetime3: '2018-11',
				ydswitch:false,
				form:{
					imgId:null
				}
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
			toPublish(){
				this.$router.push({name:'car_publish'})
			},
			handleAvatarSuccess(){
				
			},
			beforeAvatarUpload(){
				
			}
		}
	}
</script>

<style lang='scss'>
	#carSell{
		background-color: #eee;
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
			width: 2rem;
			height: 2rem;
			line-height: 2rem;
			text-align: center;
		  }
		  .avatar {
			width: 2rem;
			height: 2rem;
			display: block;
		  }
		.img-title-a{
			font-size: .3rem;
			color: #606266;
			margin-top: .4rem;
		}
		.img-title-b{
			font-size: .1rem;
			color: #606266;
			margin-top: .2rem;
			width: 60%;
		}
		.index_c{
			color: red;
		}
		.img-div{
			margin-left: .1rem;
			float: left;
		}
		.img-div-a{
			float: right;
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
			font-weight: bold;
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