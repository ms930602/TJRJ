<template>
	<yd-layout id='carSell' >
		<div class="assessOut">
		<yd-popup v-model="show3" position="left" width="60%" class="showPrice">
			<br/>
			<p>★车系车型：{{form.brand}} {{form.type}}</p>
			<p>★上牌地点：{{form.bkCitiy}}</p>
			<p>★上牌时间：{{form.upbkTime}}</p>
			<p>★行驶里程：{{form.mileage}}万公里</p>
			<p>★经计算，您的爱车粗算价值</p>
			<br/>
			<p class="price-p">{{minPrice}} ~ {{maxPrice}}万元</p>
			<br/>
			<p>★估算价格还不精确，欢迎来电咨询或预约卖车。</p>
			<br>
			<div style="width: 100%;display: flex;">
				<yd-button @click.native="show3 = false" style="margin: 0 auto;" type="warning">关闭</yd-button>
			</div>
    </yd-popup>
		<yd-navbar title="估值">
			<router-link to="index" slot="left">
				<yd-navbar-back-icon></yd-navbar-back-icon>
			</router-link>
		</yd-navbar>
		<yd-cell-group class="bt-group">
			<div class="title-a">填写资料</div>
			<br/>
			<hr/>
			<yd-cell-item>
				<p slot="left">购买价格</p>
				<input slot="right" type="number" v-model="form.price">
				<span slot="right">(万元)</span>
			</yd-cell-item>
			<yd-cell-item>
				<p slot="left">车系/品牌</p>
				<input slot="right" type="text" placeholder="请输入汽车品牌" v-model="form.brand">
			</yd-cell-item>
			<yd-cell-item>
				<p slot="left">车型</p>
				<input slot="right" type="text" placeholder="如:宝马1系2018款" v-model="form.type">
			</yd-cell-item>
			<yd-cell-item>
				<p slot="left">上牌地点</p>
				<input slot="right" type="text" placeholder="如:四川成都" v-model="form.bkCitiy">
			</yd-cell-item>
			<yd-cell-item arrow>
				<p slot="left">首次上牌</p>
				<yd-datetime type="date" v-model="form.upbkTime" slot="right"></yd-datetime>
			</yd-cell-item>
			<yd-cell-item>
				<p slot="left">行驶里程</p>
				<input slot="right" type="number" v-model="form.mileage">
				<span slot="right">(万公里)</span>
			</yd-cell-item>
			<yd-cell-item>
				<p slot="left">联系方式</p>
				<input slot="right" type="text" placeholder="请输入手机号码" v-model="form.phone">
			</yd-cell-item>
			<br/>
			<yd-button size="large"  @click.native="assessAction()" :disabled="!checkbox1"
			:class="{'ok-btn':checkbox1,'no-btn':!checkbox1}">
				卖车估价
			</yd-button>
			<h5 style="width: 100%;text-align: center;">★估算价格还不精确，欢迎来电咨询或预约卖车</h5>
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
						<img src="../../assets/img/meony.png"  class='list_icon' alt="">
						<div class="list_title">快速卖车</div>
						<p class="list_name">卖得快，价更高</p>
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/car.png"  class='list_icon' alt="">
						<div class="list_title">买放心车</div>
						<p class="list_name">大平台，车源多</p>
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/se.png"  class='list_icon' alt="">
						<div class="list_title">车辆置换</div>
						<p class="list_name">买卖车，超方便</p>
					</div>
				</div>
			</div>
		</yd-cell-group>
		</div>
	</yd-layout>
</template>

<script>
	import 'vue-ydui/dist/ydui.base.css';
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
				minPrice:0,
				maxPrice:0,
				form:{
					price:null,
					brand:'',
					type:'',
					mprice:0,
					bkCitiy:'',
					upbkTime:'2018-11-01',
					mileage:'',
					phone:''
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
			assessFlag(){
				if(this.form.price==null || this.form.price <= 0){
					this.$dialog.toast({
						mes: '请输入正确的买入价格！',
						timeout: 1500
					});
					return false;
				}
				if(this.form.brand==null || this.form.brand==''){
					this.$dialog.toast({
						mes: '请输入正确的车系！',
						timeout: 1500
					});
					return false;
				}
				if(this.form.type==null || this.form.type==''){
					this.$dialog.toast({
						mes: '请输入正确的车型！',
						timeout: 1500
					});
					return false;
				}
				if(this.form.bkCitiy==null || this.form.bkCitiy==''){
					this.$dialog.toast({
						mes: '请输入正确的上牌地点！',
						timeout: 1500
					});
					return false;
				}
				if(this.form.mileage==null || this.form.mileage==''){
					this.$dialog.toast({
						mes: '请输入正确的里程数！',
						timeout: 1500
					});
					return false;
				}
				var reg=/^1[345789][0-9]{9}$/;
				if(!reg.test(this.form.phone)){
					this.$dialog.toast({
						mes: '请输入正确的手机号！',
						timeout: 1500
					});
					return false;
				}
				return true;
			},
			assessAction(){
				if(!this.assessFlag())return;
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
				var mlv = 14;
				if(oldIndex > 0){//6万公里以上
				  if(oldIndex <= 1){//小于6万公里
						mlv = 14;
					}else
					if(oldIndex <= 2){
						mlv = 10;
					}else
					if(oldIndex <= 3){
						mlv = 6;
					}else
					if(oldIndex <= 4){
						mlv = 3;
					}else
					if(oldIndex <= 5){
						mlv = 1;
					}
				}
				mlv = parseInt(mlv / 15 * 100);
				mileagePrice = this.form.price * mlv / 100;
				console.log('mileagePrice,:',mileagePrice,'yearPrice:',yearPrice)
				if(yearPrice > mileagePrice && mileagePrice > 0){
					this.form.mprice = mileagePrice;
					this.minPrice = mileagePrice;
					this.maxPrice = yearPrice;
				}else{
					this.form.mprice = yearPrice;
					this.minPrice = yearPrice;
					this.maxPrice = mileagePrice;
				}
				this.show3 = true
				this.save();
			},
			save(){
				this.$root.ajax({
					name:'carTo/saveEstimate',
					params:this.form,
				}).then((d)=>{
				})
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
				this.$router.push({name:'car_index'})
			},
			handleAvatarSuccess(){
				
			},
			beforeAvatarUpload(){
				
			}
		}
	}
</script>

<style lang='scss'>
	input::-webkit-input-placeholder { /* WebKit browsers */ 
	
		color: #dedddd; 
	
		} 
	
		input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */ 
	
		color: #dedddd; 
	
		} 
	
		input::-moz-placeholder { /* Mozilla Firefox 19+ */ 
	
		color: #dedddd; 
	
		} 
	
		input:-ms-input-placeholder { /* Internet Explorer 10+ */ 
	
		color: #dedddd; 
	
		}
	.assessOut{
			background-color: #eee;
	}
	#carSell{
		.ok-btn{
			width: 80%;
			height: .7rem;
			margin: 0 auto;
			background-color: #ff833df2;
		}
		.no-btn{
			width: 80%;
			height: .7rem;
			margin: 0 auto;
			background-color: #948f8cf2;
		}
		.bt-group{
			p{
				width: 1.7rem;
			}
		}
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
			font-size: .3rem;
			margin-left: .15rem;
			color: #555;
		}
		.yd-cell-left{
			border-bottom: 1px #d6d6d6 solid;
		}
		.yd-cell-right{
			border-bottom: 1px #d6d6d6 solid;
		}
		.title-b{
			font-size: .28rem;
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
			text-align: center;
			overflow: auto;
			&::-webkit-scrollbar {
				width: 0px;
				opacity: 0;
				-webkit-overflow-scrolling: touch;
			}
			.list_icon{
				width: .61rem;
				height: .61rem;
				margin: 0 auto;
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
					font-size: .27rem;
					font-weight: bold;
					margin-bottom: .15rem;
				}
				.list_name {
					color: #606266;
					font-size: .25rem;
				}
			}
		}
	}
</style>