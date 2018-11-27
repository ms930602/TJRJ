<template>

	<div id='carIndex'>
		<div class="index_bg">
		</div>
		<div class="search-title-div">
			<i class="icon-search"></i>
			<input type="text" class="search-title-input" placeholder="诚信联盟" maxlength="20" v-on:keyup.enter="submit" v-model="searchName"/>
		</div>
		<div class="index_nav">
			<div @click="goNext('car_buy')" class="nav_list">
				<br/>
				<img src="../../assets/img/a111.png" alt="" class="iconIT">
				<p>我要买车</p>
			</div>
			<div @click="goNext('car_sell')"  class="nav_list">
				<br/>
				<img src="../../assets/img/a333.png" alt="" class="iconIT">
				<p>我要卖车</p>
			</div>
			<div @click="goNext('car_assess')"  class="nav_list">
				<br/>
				<img src="../../assets/img/a222.png" alt="" class="iconIT">
				<p>车辆评估</p>
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
			<div class="title_left title_left_a">
				限时特惠<img src="../../assets/img/dfs.png" alt="" style="width: .4rem;height: .5rem;float: left;margin-top: -5px;">
			</div>
			<div @click="goCarBuy" class="title_right">
				<span>更多</span>
				<img src="../../assets/img/listd_icon_right@2x.png" alt="" />
			</div>
		</div>
		<div class="car_list_f">
			<div ref='carList' class="car_list">
				<div ref='carListChildren' @click='goCarXq(item.id)' v-for='item in carCXList' class="list_children">
					<div class="c_top">
						<img class="c_img" :src="$root.config.img_url+item.topImgStr" alt="" />
						<div class="c_time">距结束:{{item.endTime|haveDate}}</div>
					</div>
					<div class="c_name">{{item.title}}</div>
					<div class="c_money">
						<span class="c_n_money">{{item.price}}万</span>
						<span class="c_j_money">已降{{(item.showPrice * 100 - item.price * 100)/100}}万</span>
					</div>
				</div>
			</div>
		</div>
		<div class="index_title">
			<div class="title_left">防抗指南</div>
		</div>
		<div class="fkzl">
			<div class="fkzl_children">
				<div  class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<div class="list_title">教你小白变专家</div>
					<yd-icon class='list_icon' size='.32rem' color='#da4b4f' custom name="zixun"></yd-icon>
					<p class="list_name">最新资讯</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<div class="list_title">选车挑车不纠结</div>
					<yd-icon class='list_icon' size='.32rem' color='#06a88c' custom name="daogou"></yd-icon>
					<p class="list_name">选车导购</p>
				</div>
				<div class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<div class="list_title">防坑防骗小技巧</div>
					<yd-icon class='list_icon' size='.4rem' color='#ebb44b'  custom name="tubiaofangwei"></yd-icon>
					<p class="list_name">干货课堂</p>
				</div>
			</div>
		</div>
		<div class="index_title">
			<div class="title_left">发现好车</div>
		</div>
		<div class="other_like">
			<div class="like_list" @click='goCarXq(item.id)' v-for='item in carList'>
				<img :src="$root.config.img_url+item.topImgStr" class="list_img" alt="" />
				<div class="list_right">
					<div class="list_name">{{item.title}}</div>
					<div class="list_badge">{{item.address}}&nbsp;/&nbsp;{{item.mileage}}万公里&nbsp;/&nbsp;{{item.upbkTime?item.upbkTime.split(' ')[0].split('-')[0]:''}}年&nbsp;/&nbsp;商家</div>
					<div class="list_bottom">
						<strong>{{item.showPrice}}万</strong>
						<span class="list_b_1">准新车</span>
						<span class="list_b_1">{{item.transferNum}}过户</span>
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
				searchName:'',
				carList:[],
				carCXList:[],
			}
		},
		filters:{
			haveDate(time){
				let carDate = time.replace(/-/g,'/');
				carDate =  new Date(carDate);
				let date = new Date();
				let currentTime = parseInt(date.getTime() / 1000);
				let carTime = parseInt(carDate.getTime() / 1000);
				//game.create_time是从后台获取的时间，单位是秒
				if(carTime < currentTime) return '活动已结束!';
				let residualTime =  carTime - currentTime ;
				//这是剩余的所有秒数（规定时间过期时间－（本机距离1970年1月1日00:00:00的秒数－后台的创建时间））

				let day = parseInt(residualTime / (24 * 3600)); //剩余天数
				let hour = parseInt((residualTime) % (24 * 3600) / 3600); //剩余小时
				let minute = parseInt((residualTime) % 3600 / 60); //剩余分钟

				return `${day}天${hour}小时${minute}分`;
			}
		},
		created() {

		},
		watch: {

		},
		computed: {

		},
		mounted() {
			this.queryCarInfo();
			this.queryCarInfoCX();
		},
		methods: {
			submit(){
				this.$router.push({name:"car_buy",query:{search:this.searchName}})
			},
			goNext(url){
				this.$router.push({name:url})
			},
			queryCarInfo(type){
				var searchPatam = {
					offerStatue:0,
					pageNum:1,
					pageSize:20,
					orderField:'f_end_time'
				};
				this.$root.ajax({
					name:'carTo/queryInfo',
					params:searchPatam,
				}).then((d)=>{
					if(d.state == 0){
						this.carList = d.aaData;
					}
				})
			},
			queryCarInfoCX(type){
				var searchPatam = {
					offerStatue:1,
					pageNum:1,
					pageSize:10,
					orderField:'f_end_time'
				};
				this.$root.ajax({
					name:'carTo/queryInfo',
					params:searchPatam,
				}).then((d)=>{
					if(d.state == 0){
						this.carCXList = d.aaData;
					}
				})
			},
			goCarShowinfo(){
				this.$router.push({
					name: 'car_showInfo'
				})
			},
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
		background-color: #fdfdfd;
		.index_bg {
			height: 2.5rem;
			color:#F0F0F0;
			background: url(../../assets/img/title.png);
			background-size: 100% ;
			line-height:3.1rem;
		}
		.search-title-div{
			width: 100%;
			height: .65rem;
			margin-top: -.28rem;
			display: flex;
			position: relative;
			.search-title-input{
				height: .65rem;
				width: 80%;
				margin: 0 auto;
				background-color: white;
				border-radius: .35rem;
				padding-left: .8rem;
			}
			.icon-search{
                background: url(../../assets/img/search2.png) no-repeat;
				background-size: .4rem;
                width: .4rem;
                height: .4rem;
                position: absolute;
                top: 6px;
                left: 1rem;
            }
		}
		#numSpan{
			font-size:.5rem;
			margin-left:.6rem;
		}
		.index_nav {
			display: flex;
			.nav_list {
				text-align: center;
				width: 33%;
				.iconIT {
					margin: .1rem auto .2rem;
					width: 1.1rem;
					height: 1.1rem;
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
						}
						.c_time {
							text-align: center;
							color: white;
							font-weight: bold;
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
			color:#585151;
			justify-content: space-between;
			align-items: center;
			.title_left {
				font-size: .4rem;
				font-weight: bold;
			}
			.title_left_a{
				display: inline-block;
				color: green;
				font-family: '微软雅黑';
				background-image: -webkit-gradient(linear, 0 0, 0 bottom, from(rgb(234, 86, 86)), to(rgba(226, 70, 70, 0.61)));
				-webkit-background-clip: text;
				-webkit-text-fill-color: transparent;
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
			color:#585151;
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