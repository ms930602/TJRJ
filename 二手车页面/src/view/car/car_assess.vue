<template>
	<yd-layout id='carSell'>
		<yd-popup v-model="show3" position="left" width="60%" class="showPrice">
			<br/>
			<p>★车系：{{form.brand}}</p>
			<p>★车型：{{form.type}}</p>
			<p>★上牌地点：{{form.bkCitiy}}</p>
			<p>★上牌时间：{{form.upbkTime}}</p>
			<p>★行驶里程：{{form.mileage}}万公里</p>
			<p>★精计算，您的爱车粗算价值</p>
			<br/>
			<p class="price-p">{{form.mPrice}}万元</p>
			<br/>
			<p>★具体价格请来电咨询或预约卖车。</p>
        </yd-popup>
		<yd-navbar title="估值">
			<router-link to="car_sell" slot="left">
				<yd-navbar-back-icon></yd-navbar-back-icon>
			</router-link>
		</yd-navbar>
		<yd-cell-group>
			<div class="title-a">填写资料</div>
			<br/>
			<hr/>
			<yd-cell-item>
				<span slot="left">购买价格：</span>
				<input slot="right" type="number" v-model="form.price">
				<span slot="right">(万元)</span>
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left">车系/品牌：</span>
				<input slot="right" type="text" placeholder="如:宝马,奥迪等" v-model="form.brand">
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left">车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</span>
				<input slot="right" type="text" placeholder="如:宝马1系2018款" v-model="form.type">
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left">上牌地点：</span>
				<input slot="right" type="text" placeholder="如:四川成都" v-model="form.bkCitiy">
			</yd-cell-item>
			<yd-cell-item arrow>
				<span slot="left">首次上牌：</span>
				<yd-datetime type="month" v-model="form.upbkTime" slot="right"></yd-datetime>
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left">行驶里程：</span>
				<input slot="right" type="number" v-model="form.mileage">
				<span slot="right">(万公里)</span>
			</yd-cell-item>
			<yd-cell-item>
				<span slot="left">联系方式：</span>
				<input slot="right" type="text" placeholder="请输入手机号码" v-model="form.phone">
			</yd-cell-item>
			<br/>
			<yd-button size="large"  @click.native="assessAction()"
			style="width: 80%;height: .7rem;margin: 0 auto;background-color: #ff833df2;">
				卖车估价
			</yd-button>
			<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<yd-checkbox v-model="checkbox1">提交代表我同意：《个人信息保护声明》</yd-checkbox>
			<br/>
			&nbsp;&nbsp;
		</yd-cell-group>
		<yd-cell-group>
			<div class="title-a" >操作介绍</div>
			<br/>
			<hr/>
			<p class="title-b">①&nbsp;完善信息→②&nbsp;获取报告→③&nbsp;更多服务</p>
			<div class="fkzl">
				<div class="fkzl_children">
					<div  class="fkzl_list" ref='fkzlRef'>
						<yd-icon class='list_icon' size='.32rem' color='#da4b4f' custom name="zixun"></yd-icon>
						<div class="list_title">快速卖车</div>
						<p class="list_name">卖得快，价更高</p>
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<yd-icon class='list_icon' size='.32rem' color='#06a88c' custom name="daogou"></yd-icon>
						<div class="list_title">买放心车</div>
						<p class="list_name">大平台，车源多</p>
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<yd-icon class='list_icon' size='.4rem' color='#ebb44b'  custom name="tubiaofangwei"></yd-icon>
						<div class="list_title">车辆置换</div>
						<p class="list_name">买卖车，超方便</p>
					</div>
				</div>
			</div>
		</yd-cell-group>
	</yd-layout>
</template>

<script>
	import {CheckBox} from 'vue-ydui/dist/lib.rem/checkbox';
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
	import {Popup} from 'vue-ydui/dist/lib.rem/popup';
	export default {
		components: {
			[SendCode.name]: SendCode,
			[Accordion.name]: Accordion,
			[AccordionItem.name]: AccordionItem,
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
			[CheckBox.name]: CheckBox,
			[Popup.name]: Popup,
		},
		data() {
			return {
				checkbox1:true,
				show3:false,
				form:{
					price:'',
					brand:'',
					type:'',
					mPrice:0,
					bkCitiy:'',
					upbkTime:'2018-11',
					mileage:'',
					phone:'',
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
			assessAction(){
				var yearPrice = 0;
				var mileagePrice = 0;
				var oldYear = this.getYearOld();
				var lv = 90;
				if(oldYear > 1){//折旧计算
					for(var i = 1; i < oldYear;i++){
						lv -= 7;
					}
				}
				yearPrice = this.form.price * lv / 100;
				
				var mileage = this.form.mileage;
				var oldIndex = mileage / 6;
				var mlv = 0;
				if(oldIndex > 0){//6万公里以上
				    if(oldIndex < 1){//小于6万公里
						
					}
					if(oldIndex >= 1){
						mlv += 5;
					}
					if(oldIndex >= 2){
						mlv += 4;
					}
					if(oldIndex >=3){
						mlv += 3;
					}
					if(oldIndex >= 4){
						mlv += 2;
					}
					if(oldIndex >= 5){
						mlv += 1;
					}
				}
				mlv = parseInt(mlv / 15 * 100);
				mileagePrice = this.form.price * mlv / 100;
				
				if(yearPrice > mileagePrice){
					this.form.mPrice = mileagePrice;
				}else{
					this.form.mPrice = yearPrice;
				}
				this.show3 = true
			},
			getYearOld(){
				var formatDate = this.form.upbkTime;
				var nowDate = new Date();
				var year=nowDate.getFullYear(); 
				var month=nowDate.getMonth()+1;
				var carDate =  new Date(formatDate);
				let date = new Date(year+"-"+month);
				let currentTime = parseInt(date.getTime() / 1000);
				let carTime = parseInt(carDate.getTime() / 1000);
				let residualTime =  currentTime - carTime;

				let day = parseInt(residualTime / (24 * 3600)); //剩余天数
				return parseInt(day / 360);
			},
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
		.showPrice{
			p{
				font-size: .25rem;
				width: 90%;
				margin: 0 auto;
				color: #606266;
			}
			.price-p{
				text-align: center;
				font-size: .5rem;
				color: red;
				font-weight: bold;
			}
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
		.title-b{
			font-size: .3rem;
			color: #666;
			margin-top: .25rem;
			margin-bottom: .2rem;
			width: 100%;
			text-align: center;
		}
		.fkzl {
			padding: .1rem .1rem;
			display: flex;
			color:#585151;
			margin: 0 0 .3rem .1rem;
			overflow: auto;
			&::-webkit-scrollbar {
				width: 0px;
				opacity: 0;
				-webkit-overflow-scrolling: touch;
			}
			.fkzl_children {
				display: flex;
			}
			.fkzl_list {
				box-shadow: 0px 0px 1px 1px #D6D6D6;
				padding: .2rem .2rem .2rem .2rem;
				/*background: red;*/
				width: 2.3rem;
				margin-right: .15rem;
				.list_title {
					font-size: .2rem;
					font-weight: bold;
					margin-bottom: .15rem;
				}
				.list_name {
					color: #606266;
					font-size: .1rem;
				}
			}
		}
	}
</style>