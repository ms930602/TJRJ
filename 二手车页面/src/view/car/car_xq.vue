<template>
	<yd-layout id='carXq'>
		<div class="xq_header_c"  slot='top'>
			<div class="header_back" @click="$router.back()">
				<img class="header_img" src="../../assets/img/listd_icon_right@2x.png" alt="">
			</div>
			
		</div>
		<div class="xq_header">
			
			<yd-slider autoplay="3000" class='xq_slider' :show-pagination='false' :callback='callback'>
				
				<yd-slider-item  v-for='(item,index) in carInfo.detailImgObj' :key='item.filePath'>
					<yd-lightbox>
						<template  v-for='(i,n) in carInfo.detailImgObj'>
							<yd-lightbox-img v-show='index==n' :key='i.filePath' :src="$root.config.img_url+i.filePath" :original="$root.config.img_url+i.filePath"></yd-lightbox-img>
							<yd-lightbox-txt>
								<h1 slot="top">{{carInfo.title}}</h1>
								<div slot="content">
									<p>表显里程：{{carInfo.mileage}}。</p>
									<p>上牌日期：{{carInfo.upbkTime?carInfo.upbkTime.split(" ")[0]:''}}。</p>
									<p>档位/排量：{{carInfo.dw}}/{{carInfo.pl}}。</p>
									<p>牌照归属：{{carInfo.bkCitiy}}。</p>
								</div>
							</yd-lightbox-txt>
						</template>
					</yd-lightbox>
				</yd-slider-item>
			</yd-slider>
			<div class="xq_page ">{{sliderPage}}/{{carInfo.detailImgObj.length}}</div>
		</div>
		<div class="xq_center_info" v-if="carInfo.offerStatue==1">
			<div style="height:10px"></div>
			<p >&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size: .50rem;">
				{{carInfo.price}}
			</span>
			<span>万</span>
			<span style="border: 1px solid;">低价出售</span>
			<span style="float: right;margin-right: 10px;" class="time_div">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<yd-countdown :time="carInfo.endTime"></yd-countdown>
			</span>
			</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;
				<span>{{carInfo.showflag}}人关注</span>
				<i class="">!</i>&nbsp;&nbsp;&nbsp;&nbsp;
				<span style="float: right;margin-right: 10px;" @click='wykjClick'>★留下电话&nbsp;&nbsp;立即享★</span>
			</p>
		</div>
		<div class="content">
			<div class="car_name">{{carInfo.title}}</div>
			<div class="car_bq">
				<span>{{carInfo.address}}</span>
				<span>{{carInfo.transferNum}}次过户</span>
			</div>
			<div class="car_money">
				<div class="car_money_left">
					<span :class="carInfo.offerStatue==1?'removeCl':''" style="font-size: .50rem;">{{carInfo.showPrice}}&nbsp;</span><span style="font-size: .1rem;">万</span>
					<span v-if="carInfo.transferPriceState==0" class="car_money_aa">(不包含过户费)</span>
					<span v-else  class="car_money_aa">(包含过户费)</span>
				</div>
				<div  class="car_money_right" @click='wykjClick'>询问底价</div>
			</div>
			<div class="new_car_money">
				<div class="new_car_money_1">新车含税价：<span>{{carInfo.newPrice}}万</span></div>
				<div class="new_car_money_2">参考价：{{carInfo.consultPrice}}</div>
			</div>
			<div class="fqfa"><span>分期方案：</span>首付：{{carInfo.firstPrice}}万</div>
			
		</div>
		<div class="content_2">
			<div class="clxx_title">车辆信息</div>
			<div class="clxx">
				<div class="clxx_list">
					<div>{{carInfo.mileage}}万公里</div>
					<p>表显里程</p>
				</div>
				<div class="clxx_list">
					<div>{{carInfo.upbkTime?carInfo.upbkTime.split(" ")[0]:''}}</div>
					<p>上牌日期</p>
				</div>
				<div class="clxx_list">
					<div>{{carInfo.dw}}/{{carInfo.pl}}</div>
					<p>表显里程</p>
				</div>
				<div class="clxx_list">
					<div>{{carInfo.transferNum}}次</div>
					<p>过户次数</p>
				</div>
				<div class="clxx_list">
					<div>{{carInfo.bkCitiy}}</div>
					<p>牌照归属</p>
				</div>
				<div class="clxx_list">
					<div>{{carInfo.xqbz}}</div>
					<p>迁地标准</p>
				</div>
			</div>
			<div class="clxx_title">咨询电话</div>
			<div style="width: 100%;font-size: .3rem;border-bottom: .2rem solid #ddd;">
				<br/>
				&nbsp;&nbsp;&nbsp;
				座机号：<a href="tel:0692-2111599" style="color: #0c2bd0;">0692-2111599</a>
				&nbsp;&nbsp;
				手机号：<a href="tel:13708625940" style="color: #0c2bd0;">13708625940</a>
				<br/><br/>
			</div>
			<br/>
			<div class="clxx_title" style="margin-bottom: .2rem;">车辆实拍</div>
		</div>
		<p style="margin-left: .2rem;width: 95%;font: .25rem;">{{carInfo.strB}}</p>
		<br>
		<yd-lightbox :num="carInfo.detailImgObj.length" class='list_img'>
			<yd-lightbox-img v-for="item in carInfo.detailImgObj" :key='item.filePath' :src="$root.config.img_url+item.filePath" :original="$root.config.img_url+item.filePath"></yd-lightbox-img>

			<yd-lightbox-txt>
				<h1 slot="top">{{carInfo.title}}</h1>
				<div slot="content">
					<p>表显里程：{{carInfo.mileage}}。</p>
					<p>上牌日期：{{carInfo.upbkTime?carInfo.upbkTime.split(" ")[0]:''}}。</p>
					<p>档位/排量：{{carInfo.dw}}/{{carInfo.pl}}。</p>
					<p>牌照归属：{{carInfo.bkCitiy}}。</p>
				</div>
			</yd-lightbox-txt>
		</yd-lightbox>
		<div class='xq_footer' slot='bottom'>
			<div @click='wykjClick'>我要砍价</div>
			<a :href="'tel:'+carInfo.strA"><yd-icon name="phone2" size='.32rem'></yd-icon>&nbsp;资讯车况</a>
		</div>
		<yd-popup v-model="bottomShow" position="bottom" height="50%">
			<div class="popup_input popup_input_1">
				<div>
					<span>手机号</span>
					<input type="number" v-model="phoneNum" @input="changeInput(phoneNum)" pattern="\d*" oninput="if(value.length>11)value=value.slice(0,11)"  placeholder="请输入手机号码" />
				</div>
				<!--<yd-sendcode slot="right" 
                         v-model="start" 
                         @click.native="sendCode" 
                         type="warning"
           		 ></yd-sendcode>-->
			</div>
			<!--<div class="popup_input popup_input_2">
				<span>验证码</span>
				<input v-model="phoneYzm" oninput="if(value.length>6)value=value.slice(0,6)" maxlength="6" type="number" pattern="\d*" placeholder="请输入验证码"/>
			</div>-->
			<div class="popup_submit" @click='submit' v-if='true'>提交</div>
			<div class="popup_submit" v-else style='background: #D6D6D6;' >提交</div>
        </yd-popup>
	</yd-layout>
</template>

<script>
	import {Popup} from 'vue-ydui/dist/lib.rem/popup';
	import { Slider, SliderItem } from 'vue-ydui/dist/lib.rem/slider';
	import {SendCode} from 'vue-ydui/dist/lib.rem/sendcode';
	import { LightBox, LightBoxImg, LightBoxTxt } from 'vue-ydui/dist/lib.rem/lightbox';
	import {CountDown} from 'vue-ydui/dist/lib.rem/countdown';
	export default {
		components: {
			[Slider.name]: Slider,
			[SliderItem.name]: SliderItem,
			[Slider.name]: Slider,
			[LightBox.name]: LightBox,
			[LightBoxImg.name]: LightBoxImg,
			[LightBoxTxt.name]: LightBoxTxt,
			[Popup.name]: Popup,
			[SendCode.name]: SendCode,
			[CountDown.name]: CountDown,
		},
		data() {
			return {
				carInfo:{
					address:"",
					bkCitiy:"",
					brand:"",
					consultPrice:"",
					detailImgObj:[],
					dw:"",
					endTime:"",
					id:null,
					imgs:"",
					intA:null,
					intB:null,
					maxPrice:null,
					mileage:"",
					minPrice:null,
					newPrice:0,
					offerStatue:"",
					pkId:null,
					pl:"",
					price:0,
					firstPrice:0,
					remark:"",
					searchType:null,
					showPrice:0,
					showflag:0,
					status:"",
					strA:null,
					strB:null,
					title:"",
					topImg:"",
					topImgObj:{},
					topImgStr:null,
					transactionStatu:"",
					transferNum:0,
					transferPriceState:"",
					type:"",
					upbkTime:"",
					xqbz:null
				},
				start: false,
				sliderPage: 1,
				firstStart:true,
				isPhone:false,
				bottomShow:false,
				phoneNum:'',
				phoneYzm:'',
				
			}
		},
		created() {

		},
		watch: {

		},
		computed: {

		},
		mounted() {
			var id = this.$route.query.id;
			if(id){
				this.queryCar(id);
			}else{
				this.$dialog.toast({
					mes: '页面错误！',
					timeout: 1500
				});
			}
		},
		methods: {
			queryCar(id){
				this.$root.ajax({
					name:'carTo/queryById',
					type:'get',
					params:{
						id:id
					},
				}).then((d)=>{
					if(d.state == 0){
						Object.assign(this.carInfo, d.aaData);
						if(this.carInfo.detailImgObj && this.carInfo.detailImgObj.length>0
							&& this.carInfo.topImgObj)
						{
							this.carInfo.detailImgObj.unshift({filePath:this.carInfo.topImgObj.filePath,fileName:this.carInfo.topImgObj.fileName})
						}
					}
				})
			},
			submit(){
				if(!this.phoneNum){
					this.$dialog.toast({
	                    mes: '请输入手机号码！',
	                    timeout: 1500
	                });
	                return
				}
				if(this.isPhone){
					this.$root.ajax({
						name:'carTo/saveConsu',
						params:{
							phone:this.phoneNum,
							status:0,
							carId:this.carInfo.id,
							context:'我要砍价',
							carTitle:this.carInfo.title
						},
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
				}else{
					this.$dialog.toast({
	                    mes: '请输入正确的手机号码！',
	                    timeout: 1500
	                });
					return
				}
			},
			callback(num) {
				this.sliderPage = num + 1
			},
			wykjClick(){
				this.bottomShow=true
			},
			 sendCode() {
			 	if(this.isPhone){
			 		this.$dialog.loading.open('发送中...');
			 		this.firstStart=true
	                setTimeout(() => {
						
	                    this.start = true;
	                    this.$dialog.loading.close();
	
	                    this.$dialog.toast({
	                        mes: '已发送',
	                        icon: 'success',
	                        timeout: 1500
	                    });
	
	                }, 1000);
			 	}else{
			 		this.$dialog.toast({
	                    mes: '请输入正确的手机号码！',
	                    timeout: 1500
	                });
			 	}
                
            },
            changeInput(val){
            	var reg=/^1[345789][0-9]{9}$/;
            	if(reg.test(val)){
            		this.isPhone=true	
            	}else{
            		this.isPhone=false	
            	}
            },
		}
	}
</script>

<style lang='scss'>
	.removeCl{
		text-decoration: line-through;
	}
	.xq_center_info{
		margin-left: -3px;
		font-weight: bold;
		height: 60px;
		color: white;
		background: url(../../assets/img/cvvd.png);
	}
	.car_money_aa{
		color: #999;
		font-size: 10px;
		margin-left: 20px;
	}
	.yd-lightbox-head>a{
		color:white;
	}
	#carXq {
		.xq_header_c{
			font-size: .25rem;
			padding: .25rem .2rem .25rem .2rem;
			.header_img{
				transform: rotate(180deg);
				width:.17rem;
				height: .24rem;
				margin-right: .2rem;
			}
			.header_back{
				display: flex;
				align-items: center;
			}
		}
		.xq_header {
			position: relative;
			.xq_page {
				position: absolute;
				bottom: 0;
				color: white;
				left: 0;
				right: 0;
				z-index: 9;
				text-align: right;
				padding: 0 .3rem .1rem 0;
			}
			
		}
		.xq_slider{
			img{
				height: 7rem;
			}
			
		}
		.list_img{
			img{
				margin:0 auto .3rem;
				width: 6.8rem;
				height: 5rem;
			}
		}
		.content{
			padding: .25rem;
			border-bottom: .2rem solid #DDDDDD;
			.car_name{
				font-size: .32rem;
				font-weight: 700;
			}
			.car_bq{
				display: flex;
				span{
					border: 1px solid seagreen;
					border-radius: .04rem;
					font-size: .24rem;
				    line-height: .28rem;
				    padding: 0 .1rem;
				    margin:.2rem .25rem .3rem 0;
				    border-radius: .04rem;
				}
			}
			.showPrice-span{
				font-size: .42rem;
			}
			.car_money{
				justify-content: space-between;
				display: flex;
				.car_money_left{
					color:#D6D6D6;
					span{
						font-size: .22rem;
						font-weight: 600;
						color: #FF3D15;
					}
				}
				.car_money_right{
					font-size: .28rem;
					color: #FF3D15;
				}
			}
			.new_car_money{
				display: flex;
				font-size: .26rem;
				margin: .3rem 0 .2rem 0;
				.new_car_money_1{
					margin-right:.2rem;
					span{
						text-decoration: line-through;
					}	
				}	
				.new_car_money_2{
					
				}
			}
			.fqfa{
				background: blanchedalmond;
				padding: .18rem .2rem;
				font-size: .26rem;
				color: #FF3D15;
				text-align: center;
				span{
					font-size: .28rem;
					font-weight: 600;
				}
			}
			
		}
		.content_2{
			.clxx_title{
				font-size: .3rem;
				border-bottom: 1px solid #DDDDDD;	
				padding: .2rem .25rem;
			}
			.clxx{
				border-bottom: 0.2rem solid #DDDDDD;
				padding: .2rem .25rem;
				display: flex;
				flex-wrap: wrap;
				.clxx_list{
					width:33%;
					div{
						font-size: .26rem;
					}
					p{
						color: #888;
						margin: .05rem 0 .2rem 0;
					}
				}
			}
		}
		.xq_footer{
			display: flex;
			align-items: center;
			font-size: .32rem;
			line-height: 1rem;
			color: white;
			div{
				text-align: center;
				width: 50%;
				height: 1rem;
				background: red;
			}
			a{
				text-align: center;
				width: 50%;
				height: 1rem;
				background: blanchedalmond;
			}
		}
		.yd-scrollview:after{
			display: none;
		}
		.popup_input{
			margin: .2rem;
			border-bottom: 1px solid #DDDDDD;
			padding: .2rem 0;
			display: flex;
			align-items: center;
			font-size: .28rem;
			span{
				margin-right: .2rem;
			}
			input{
				outline: none;
				border: none;
			}
		}
		.popup_input_1{
			justify-content: space-between;
		}
		.popup_submit{
			border-radius: .45rem;
			margin: .4rem auto 0;
			width: 90%;
			font-size: .4rem;
			text-align: center;
			line-height: 0.9rem;
			background: #F56C6C;
			color: white;
		}
	}
</style>