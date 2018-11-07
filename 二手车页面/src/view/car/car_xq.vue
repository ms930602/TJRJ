<template>
	<yd-layout id='carXq'>
		<div class="xq_header">
			<yd-slider autoplay="3000" class='xq_slider' :show-pagination='false' :callback='callback'>
				
				<yd-slider-item  v-for='(item,index) in dataList' :key='item.src'>
					<!--<a href="http://www.ydcss.com">
						<img :src="item.src">
					</a>-->
					<yd-lightbox>
						<template  v-for='(i,n) in dataList'>
							<yd-lightbox-img v-show='index==n' :key='i.src' :src="i.src" :original="i.original"></yd-lightbox-img>
							<yd-lightbox-txt>
								<h1 slot="top">双瞳如小窗 佳景观历历</h1>
								<div slot="content">
									<p>相机：灵犀相通，妙不可言。</p>
									<p>设计：美不胜收，爱不释手。</p>
									<p>体验：强劲性能，持久动力。</p>
									<p>mCharge 4.0：上善若水，不止于快。</p>
									<p>mTouch：指尖轻点，安全随行。</p>
								</div>
							</yd-lightbox-txt>
						</template>
					</yd-lightbox>
				</yd-slider-item>
			</yd-slider>
			<div class="xq_page ">{{sliderPage}}/{{dataList.length}}</div>
		</div>
		
		<div class="content">
			<div class="car_name">凯美瑞</div>
			<div class="car_bq">
				<span>美国</span>
				<span>0次过户</span>
			</div>
			<div class="car_money">
				<div class="car_money_left">
					<span>10.2万</span>(不包含过户费)
				</div>
				<div  class="car_money_right" @click='wykjClick'>询问底价</div>
			</div>
			<div class="new_car_money">
				<div class="new_car_money_1">新车含税价：<span>19.52万</span></div>
				<div class="new_car_money_2">参考价：10.27-12.05万</div>
			</div>
			<div class="fqfa"><span>分期方案：</span>首付：3.06万</div>
			
		</div>
		<div class="content_2">
			<div class="clxx_title">车辆信息</div>
			<div class="clxx">
				<div class="clxx_list">
					<div>6万公里</div>
					<p>表显里程</p>
				</div>
				<div class="clxx_list">
					<div>2013-9</div>
					<p>上牌日期</p>
				</div>
				<div class="clxx_list">
					<div>自动/2L</div>
					<p>表显里程</p>
				</div>
				<div class="clxx_list">
					<div>0次</div>
					<p>表显里程</p>
				</div>
				<div class="clxx_list">
					<div>新疆乌鲁木齐</div>
					<p>牌照归属</p>
				</div>
				<div class="clxx_list">
					<div>欧IV</div>
					<p>查询准迁地</p>
				</div>
			</div>
			<div class="clxx_title" style="margin-bottom: .2rem;">车辆实拍</div>
		</div>
		
		<yd-lightbox :num="dataList.length" class='list_img'>
			<yd-lightbox-img v-for="item in dataList" :key='item.src' :src="item.src" :original="item.original"></yd-lightbox-img>

			<yd-lightbox-txt>
				<h1 slot="top">双瞳如小窗 佳景观历历</h1>
				<div slot="content">
					<p>相机：灵犀相通，妙不可言。</p>
					<p>设计：美不胜收，爱不释手。</p>
					<p>体验：强劲性能，持久动力。</p>
					<p>mCharge 4.0：上善若水，不止于快。</p>
					<p>mTouch：指尖轻点，安全随行。</p>
				</div>
			</yd-lightbox-txt>
		</yd-lightbox>
		<div class='xq_footer' slot='bottom'>
			<div @click='wykjClick'>我要砍价</div>
			<a href="tel:15281037642"><yd-icon name="phone2" size='.32rem'></yd-icon>&nbsp;资讯车况</a>
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
		},
		data() {
			return {
				start: false,
				sliderPage: 1,
				dataList: [{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s1.jpg'
					},
					{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s2.jpg'
					},
					{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s3.jpg'
					},
					{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s4.jpg'
					},
					{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s5.jpg'
					},
					{
						src: 'http://static.ydcss.com/uploads/lightbox/meizu_s6.jpg'
					}
				],
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
			console.log(this.$route)
			console.log(this.$route.query.id)
			console.log(this.$route.params)
		},
		methods: {
			submit(){
				if(!this.phoneNum){
					this.$dialog.toast({
	                    mes: '请输入手机号码！',
	                    timeout: 1500
	                });
	                return
				}
				if(this.isPhone){
					this.$root.ajax({})
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
	#carXq {
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
				height: 3.5rem;
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
			.car_money{
				justify-content: space-between;
				display: flex;
				.car_money_left{
					color:#D6D6D6;
					span{
						font-size: .32rem;
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
						color: #D6D6D6;
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