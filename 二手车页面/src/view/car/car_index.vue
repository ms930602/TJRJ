<template>

	<div id='carIndex'>
		<div class="index_bg">
			<span id="numSpan">12,183,666</span>&nbsp;&nbsp;位家庭已使用买车服务
		</div>
		<div class="index_nav">
			<div class="nav_list">
				<br/>
				<yd-icon name="maiche2" custom slot="icon" size="0.39rem" class="iconIT" style="color:#e44c4c;"></yd-icon>
				<p>我要买车</p>
			</div>
			<div class="nav_list">
				<br/>
				<yd-icon name="maiche1" custom slot="icon" size="0.54rem" class="iconIT" style="color:rgb(226, 129, 5);"></yd-icon>
				<p>我要卖车</p>
			</div>
		</div>
		<yd-slider class='index_slider' autoplay="3000">
			<yd-slider-item>
				<a >
					<img src="../../assets/img/hf1.jpg">
				</a>
			</yd-slider-item>
			<yd-slider-item>
				<a >
					<img src="../../assets/img/hf2.jpg">
				</a>
			</yd-slider-item>
		</yd-slider>
		<div class="index_title">
			<div class="title_left">限时特惠</div>
			<div @click="goCarBuy" class="title_right">
				<span>更多</span>
				<img src="../../assets/img/listd_icon_right@2x.png" alt="" />
			</div>
		</div>
		<div class="car_list_f">
			<div ref='carList' class="car_list">
				<div ref='carListChildren' v-for='i in 5' class="list_children">
					<div class="c_top">
						<img class="c_img" src="" alt="" />
						<div class="c_time">距离结束:02天00时33分</div>
					</div>
					<div class="c_name">本田本田本田本田本田本田</div>
					<div class="c_money">
						<span class="c_n_money">18.88万</span>
						<span class="c_j_money">已降4.09万</span>
					</div>
				</div>
			</div>
		</div>
		<div class="index_title">
			<div class="title_left">防抗指南</div>
		</div>
		<div class="fkzl">
			<div class="fkzl_children">
				<div  class="fkzl_list" ref='fkzlRef'>
					<div class="list_title">教你小白变专家</div>
					<yd-icon class='list_icon' size='.32rem' color='#da4b4f' custom name="zixun"></yd-icon>
					<p class="list_name">最新资讯</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef'>
					<div class="list_title">选车挑车不纠结</div>
					<yd-icon class='list_icon' size='.32rem' color='#06a88c' custom name="daogou"></yd-icon>
					<p class="list_name">选车导购</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef'>
					<div class="list_title">防坑防骗小技巧</div>
					<yd-icon class='list_icon' size='.4rem' color='#ebb44b'  custom name="tubiaofangwei"></yd-icon>
					<p class="list_name">干货课堂</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef'>
					<div class="list_title">提问回答涨姿势</div>
					<yd-icon class='list_icon' size='.32rem' color='#1296db' custom name="stup"></yd-icon>
					<p class="list_name">二手车论坛</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef'>
					<div class="list_title">看车聊车撩主播</div>
					<yd-icon class='list_icon' size='.32rem' color='#04d0bf' custom name="zhibo"></yd-icon>
					<p class="list_name">直播</p>
				</div>
			</div>
		</div>
		<div class="other_like_title">你可能还喜欢</div>
		<div class="other_like">
			<div class="like_list" @click='goCarXq(item)' v-for='item in 5'>
				<img src="" class="list_img" alt="" />
				<div class="list_right">
					<div class="list_name">车子名字车子名字车子名字车子名字车子名字车子名字车子名字</div>
					<div class="list_badge">地址&nbsp;/&nbsp;0.1万公里&nbsp;/&nbsp;2018年&nbsp;/&nbsp;商家</div>
					<div class="list_bottom">
						<strong>20.8万</strong>
						<span class="list_b_1">准新车</span>
						<span class="list_b_1">0过户</span>
						<span class="list_b_2">质保</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import { Slider, SliderItem } from 'vue-ydui/dist/lib.rem/slider';
	import { Tab, TabPanel } from 'vue-ydui/dist/lib.rem/tab';
	export default {
		components: {
			[Slider.name]: Slider,
			[SliderItem.name]: SliderItem,
			[Tab.name]: Tab,
			[TabPanel.name]: TabPanel,
		},
		data() {
			return {

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
			goCarBuy() {
				this.$router.push({
					name: 'car_discover'
				})
			},
			goCarXq(item){
				this.$router.push({
					name:'car_xq',
					query:{
						id:item
					},
					params:{
						a:1
					}
				})
			}
		}
	}
</script>

<style lang='scss'>
	#carIndex {
		.index_bg {
			height: 2rem;
			color:#F0F0F0;
			background: url(../../assets/img/title.png) no-repeat;
			background-size: 100% ;
			line-height:160px;
		}
		#numSpan{
			font-size:30px;
			margin-left:30px;
		}
		.index_nav {
			display: flex;
			.nav_list {
				text-align: center;
				width: 25%;
				iconIT {
					margin: .4rem auto .2rem;
					width: 1rem;
					height: 1rem;
				}
			}
		}
		.index_slider {
			margin: .35rem 0;
		}
		.car_list_f {
			overflow: auto;
			&::-webkit-scrollbar {
				width: 0px;
				opacity: 0;
				-webkit-overflow-scrolling: touch;
			}
			.car_list {
				display: flex;
				.list_children {
					margin-right: .25rem;
					.c_top {
						position: relative;
						.c_img {
							width: 3rem;
							height: 2rem;
							background: red;
						}
						.c_time {
							text-align: center;
							color: white;
							position: absolute;
							bottom: 0;
							left: 0;
							right: 0;
						}
					}
					.c_name {
						font-size: .28rem;
						font-weight: 500;
						margin: .2rem 0;
						width: 2.5rem;
						overflow: hidden;
						white-space: nowrap;
						text-overflow: ellipsis;
					}
					.c_money {
						.c_n_money {
							font-size: .3rem;
							color: #FF3D15;
						}
						.c_j_money {
							color: #666666;
						}
					}
				}
				.list_children:first-child {
					padding-left: .25rem;
				}
				.list_children:last-child {
					padding-right: .25rem;
				}
			}
		}
		.index_title {
			padding: .4rem .25rem;
			display: flex;
			justify-content: space-between;
			align-items: center;
			.title_left {
				font-size: .4rem;
				font-weight: bold;
			}
			.title_right {
				display: flex;
				align-items: center;
				img {
					width: .14rem;
					height: .28rem;
					margin-left: .2rem;
				}
			}
		}
		.fkzl {
			padding: .1rem .1rem;
			display: flex;
			margin: 0 0 .3rem .15rem;
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
				padding: .2rem .4rem .2rem .44rem;
				/*background: red;*/
				width: 2.2rem;
				margin-right: .25rem;
				.list_title {
					font-size: .3rem;
					font-weight: bold;
					margin-bottom: .1rem;
				}
				.list_name {
					color: #606266;
				}
			}
		}
		.other_like_title {
			font-size: .28rem;
			padding: 0 0 .35rem .25rem;
			font-weight: bold;
		}
		.other_like {
			padding: 0 .25rem .1rem .25rem;
			.like_list {
				margin-bottom: .42rem;
				line-height: .35rem;
				display: flex;
				.list_img {
					width: 2rem;
					height: 1.5rem;
					background: red;
					margin-right: .25rem;
					flex-grow: 0;
				}
				.list_right {
					width: 3rem;
					flex-grow: 1;
					.list_name {
						font-size: .28rem;
						font-weight: bold;
					}
					.list_badge {
						color: #666666;
						margin: .05rem 0 .1rem 0;
					}
					.list_bottom {
						display: flex;
						align-content: center;
						align-items: center;
						strong {
							font-weight: 500;
							color: #FF3D15;
							font-size: .3rem;
						}
						span {
							font-size: .24rem;
							line-height: .28rem;
							padding: 0 .1rem;
							margin: 0 .1rem;
							border-radius: .04rem;
						}
						.list_b_1 {
							background: sandybrown;
							color: white;
						}
						.list_b_2 {
							background: red;
							color: white;
						}
					}
				}
			}
		}
	}
</style>