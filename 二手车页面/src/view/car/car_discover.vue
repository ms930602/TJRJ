<template>
	<yd-layout id='carBuy'>
    <yd-search slot='top'  v-model="value1" class='buy_search_input' :on-submit="submitHandler" :on-cancel="cancelHandler"></yd-search>
    <img class="header_img" src="../../assets/img/tjc.jpg" alt="" style="width: 100%;" />
		<div class="had-mod" v-if="modelIs" @click="closeShow()"></div>
		<div class="search-div">
			<div style="display: flex;align-items: center;" class="dis-a">
				&nbsp;&nbsp;&nbsp;
				<div @click="openZN()" :class="{'show-index':selectA}">
					智能排序<img src="../../assets/img/search.png" alt="">
				</div>&nbsp;&nbsp;&nbsp;
				<div @click="carPp">
					&nbsp;&nbsp;&nbsp;&nbsp;品牌<img src="../../assets/img/search.png" alt="">
				</div>&nbsp;&nbsp;&nbsp;
				<div @click="openJG()" :class="{'show-index':selectB}">
					&nbsp;&nbsp;&nbsp;&nbsp;价格<img src="../../assets/img/search.png" alt="">
				</div>&nbsp;&nbsp;&nbsp;
			</div>
			<span @click="reset" style="float: right;" >清空&nbsp;&nbsp;&nbsp;</span>
		</div>
		<div class="my-xiala-a" v-if="selectA">
			<div :class="{'search-pa-color':searchA==1,'search-padiv':true}" @click="selectActionA(1)">
				<span>智能排序</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchA==1"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchA==2,'search-padiv':true}" @click="selectActionA(2)">
				<span>价格最低</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchA==2"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchA==3,'search-padiv':true}" @click="selectActionA(3)">
				<span>最新发布</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchA==3"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchA==4,'search-padiv':true}" @click="selectActionA(4)">
				<span>里程最少</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchA==4"></yd-icon>
			</div>
			<br>
		</div>
		<div class="my-xiala-a" v-if="selectB">
			<div :class="{'search-pa-color':searchB==5,'search-padiv':true}" @click="selectActionA(5)">
				<span>无限制</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==5"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==6,'search-padiv':true}" @click="selectActionA(6)">
				<span>0 ~ 5 万</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==6"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==7,'search-padiv':true}" @click="selectActionA(7)">
				<span>5 ~ 10 万</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==7"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==8,'search-padiv':true}" @click="selectActionA(8)">
				<span>10 ~ 15 万</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==8"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==9,'search-padiv':true}" @click="selectActionA(9)">
				<span>15 ~ 20 万</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==9"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==10,'search-padiv':true}" @click="selectActionA(10)">
				<span>20 ~ 30 万</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==10"></yd-icon>
			</div>
			<div :class="{'search-pa-color':searchB==11,'search-padiv':true}" @click="selectActionA(11)">
				<span>30 以上</span>
				<yd-icon name="checkoff" size=".25rem" v-if="searchB==11"></yd-icon>
			</div>
			<br>
		</div>
		<div class="y-badge">
			<yd-badge shape="square" type="hollow" scale="1.1" v-if="brandType!=null && brandType!=''" @click.native="removeBadge(2)">
				{{brandType}} 
				<i style="color: black;margin-left: .1rem;">X</i>
			</yd-badge>
			<yd-badge shape="square" type="hollow" scale="1.1" v-if="searchParam.orderField!=null" @click.native="removeBadge(1)">
				<span v-if="searchParam.orderField=='f_show_price'">价格最低</span>
				<span v-if="searchParam.orderField=='f_createtime'">最新发布</span>
				<span v-if="searchParam.orderField=='f_mileage'">里程最少</span>
				<i style="color: black;margin-left: .1rem;">X</i>
			</yd-badge>
			<yd-badge shape="square" type="hollow" scale="1.1" v-if="searchParam.maxPrice!=null" @click.native="removeBadge(3)">
				<span >
				{{searchParam.minPrice}}&nbsp;&nbsp;~&nbsp;&nbsp;{{searchParam.maxPrice==10000?'*':searchParam.maxPrice}}&nbsp;万
				</span>
				<i style="color: black;margin-left: .1rem;">X</i>
			</yd-badge>
		</div>
		<!-- <img :src="$root.config.img_url" alt=""> -->
		<yd-infinitescroll :callback="loadList" ref="infinitescrollDemo">
			<div class="other_like" slot="list" >
				<div class="like_list"  @click='goCarXq(item.id)' v-for='item in dataList'>
					<img :src="$root.config.img_url+item.topImgStr" class="list_img" alt="" />
					<div class="list_right">
						<div class="list_name">{{item.title}}</div>
						<div class="list_badge">{{item.address}}&nbsp;/&nbsp;{{item.mileage}}万公里&nbsp;/&nbsp;{{item.upbkTime?item.upbkTime.split(' ')[0].split('-')[0]:''}}年&nbsp;/&nbsp;商家</div>
						<div class="list_bottom">
							<strong>{{item.price}}万</strong>
							<span class="list_b_1">准新车</span>
							<span class="list_b_1">{{item.transferNum}}过户</span>
							<span class="list_b_2">质保</span>
						</div>
						<div class="c_time">距结束:{{item.endTime|haveDate}}</div>
					</div>
				</div>
			</div>
			<!-- 数据全部加载完毕显示 -->
			<span slot="doneTip">啦啦啦，啦啦啦，没有数据啦~~</span>

			<!-- 加载中提示，不指定，将显示默认加载中图标 -->
			<img slot="loadingTip" src="http://static.ydcss.com/uploads/ydui/loading/loading10.svg" />

		</yd-infinitescroll>
	</yd-layout>
</template>

<script>
	import 'vue-ydui/dist/ydui.base.css';
	import { Search } from 'vue-ydui/dist/lib.rem/search';
	import { TabBar, TabBarItem } from 'vue-ydui/dist/lib.rem/tabbar';
	import {InfiniteScroll} from 'vue-ydui/dist/lib.rem/infinitescroll';
	import {ActionSheet} from 'vue-ydui/dist/lib.rem/actionsheet';
	import {Badge} from 'vue-ydui/dist/lib.rem/badge';
	export default {
		components: {
			[TabBar.name]: TabBar,
			[TabBarItem.name]: TabBarItem,
			[Search.name]: Search,
			[InfiniteScroll.name]: InfiniteScroll,
			[ActionSheet.name]:ActionSheet,
			[Badge.name]:Badge,
		},
		data() {
			return {
				modelIs:false,
				selectA:false,
				selectB:false,
				searchParam:{
					offerStatue:1,//特价车
					orderField:null,
					pageSize:10,
					pageNum:1,
					searchType:2,//1 非特价车 2 特价车
					type:'',//车型
					minPrice:null,
					maxPrice:null
				},
				brandType:'',
				pageNum:1,
				pageSize:10,
				value1: '',
				result: [],
				rightPopup:false,
				carListShow:false,
				dataList:[],
				searchA:1,
				searchB:5,
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
			value2(val) {
				this.result = this.getResult(val);
			}
		},
		computed: {

		},
		mounted() {
			var carId1 = this.$route.query.carId1
			var carId2 = this.$route.query.carId2
			var paramA = this.$route.query.searchA
			var paramB = this.$route.query.searchB
			
			if(carId1 && carId2){
				if(carId1 == '无限制'){
					this.brandType = '';
					this.searchParam.type = '';
				}else{
					this.brandType=carId1+"--"+carId2;
					this.searchParam.type = carId2;
				}
			}
			
			if(paramA && paramA > 1 && paramA < 5){
				this.setSearchParam(parseInt(paramA));
			}
			
			if(paramB && paramB > 5 && paramB < 12){
				this.setSearchParam(parseInt(paramB));
			}
			this.reLoadList()
		},
		methods: {
			closeShow(){
				this.selectA = false;
				this.selectB = false;
				this.modelIs = false;
			},
			setSearchParam(index){
				switch(index)
				{
					case 1:
						this.searchParam.orderField = null;
						break;
					case 2:
						this.searchParam.orderField = 'f_show_price';
				console.log(index)
						break;
					case 3:
						this.searchParam.orderField = 'f_createtime';
						break;
					case 4:
						this.searchParam.orderField = 'f_mileage';
						break;
					case 5:
						this.searchParam.minPrice = null;
						this.searchParam.maxPrice = null;
						break;
					case 6:
						this.searchParam.minPrice = 0;
						this.searchParam.maxPrice = 5;
						break;
					case 7:
						this.searchParam.minPrice = 5;
						this.searchParam.maxPrice = 10;
						break;
					case 8:
						this.searchParam.minPrice = 10;
						this.searchParam.maxPrice = 15;
						break;
					case 9:
						this.searchParam.minPrice = 15;
						this.searchParam.maxPrice = 20;
						break;
					case 10:
						this.searchParam.minPrice = 20;
						this.searchParam.maxPrice = 30;
						break;
					case 11:
						this.searchParam.minPrice = 30;
						this.searchParam.maxPrice = 10000;
						break;
				}
				if(index < 5){
					this.searchA = index;
				}else{
					this.searchB = index;
				}
			},
			selectActionA(index){
				this.closeShow();
				this.setSearchParam(index);
				this.reLoadList();
			},
			openZN(){
				this.selectB = false;
				
				this.selectA = !this.selectA;
				this.modelIs = this.selectA;
			},
			openJG(){
				this.selectA = false;
				this.selectB = !this.selectB;
				this.modelIs = this.selectB;
			},
			removeBadge(index){
				if(index == 1){
					this.searchParam.orderField = null;
				}else if(index == 2){
					this.brandType = '';
					this.searchParam.type = '';
				}else if(index == 3){
					this.searchParam.minPrice = null;
					this.searchParam.maxPrice = null;
				}
				this.reLoadList()
			},
			reset(){
				this.searchParam = {
					offerStatue:1,
					orderField:null,
					pageSize:10,
					pageNum:1,
					searchType:2,//1 非特价车 2 特价车
					type:'',//车型
					minPrice:null,
					maxPrice:null
				};
				this.brandType = '';
				this.reLoadList();
			},
			carPp(){
				this.rightPopup=true
				this.$router.push({
					name:'car_list',
					params:{
						url:'car_discover',
						searchA:this.searchA,
						searchB:this.searchB
					}
				})
			},
			reLoadList(){
				this.dataList = [];
				this.loadList();
			},
			loadList(){
				this.searchParam.title = this.value1;
				this.searchParam.pageNum = this.pageNum;
				this.$root.ajax({
					name:'carTo/queryInfo',
					params:this.searchParam,
				}).then((d)=>{
					
                    this.dataList = [...this.dataList, ...d.aaData];
                    if (this.dataList>=d.dataCount) {
                        /* 所有数据加载完毕 */
                        this.$refs.infinitescrollDemo.$emit('ydui.infinitescroll.loadedDone');
                        return;
                    }

                    /* 单次请求数据完毕 */
                    this.$refs.infinitescrollDemo.$emit('ydui.infinitescroll.finishLoad');

                    this.pageNum++;
				})
			},
			getResult(val) {
				if(!val) return [];
				return [
					'Apple', 'Banana', 'Orange', 'Durian', 'Lemon', 'Peach', 'Cherry', 'Berry',
					'Core', 'Fig', 'Haw', 'Melon', 'Plum', 'Pear', 'Peanut', 'Other'
				].filter(value => new RegExp(val, 'i').test(value));
			},
			cancelHandler() {
				this.value1='';
				this.searchParam.title='';
				this.reLoadList();
			},
			submitHandler(value) {
				this.reLoadList();
			},
			goCarXq(item) {
				this.$router.push({
					name: 'car_xq',
					query: {
						id: item
					},
					params: {
						a: 1
					}
				})
			}
		}
	}
</script>

<style lang='scss'>
	.search-padiv{
		display: flex;
		justify-content: space-between;
	}
	.search-pa-color{
		color: #ff6000;
	}
	.search-pb-color{
		color:#736a6a;
	}
	.show-index{
		z-index: 101;
	}
	.hide-index{
		height: 0;
	}
	.had-mod{
		position: absolute;
		left:0;
		width: 100%;
		height: 100%;
		margin-top: 1rem;
		background-color: #d0cbcb96;
		z-index: 100;
	}
	.search-div{
		width: 100%;
		display: flex;
		align-items: center;
		border-bottom: 1px #eee solid;
		justify-content: space-between;
		.dis-a{
			div{
				background-color: white;
				font-size: .27rem;
				display: flex;
				color: #444;
				align-items: center;
			}
			img{
				margin-top: .05rem;
				width: .43rem;
				display: inline-table;
			}
			
		}
	}
	.sx_badge{
		color: #000000b3;
		font-weight: bold;
	}
	.c_time{
		color:#f44;
	}
	.header_img {
		height: 2.5rem;
	}
	#carBuy {
		.my-xiala-a{
			position: absolute;
			background-color: white;
			width: 100%;
			left:0;
			z-index: 101;
			div{
				font-size: .27rem;
				margin-top: .6rem;
				margin-left: .25rem;
				border-bottom: 1px #f3f3f3 solid;
			}
			i{
				margin-right: .2rem;
			}
		}
		.y-badge{
			margin-top: .1rem;
			margin-left: .26rem;
			span{
				margin-right: .2rem;
				margin-bottom: .1rem;
			}
		}
		.buy_search_input{
			.yd-search-input{
				background: white;
			}
			.search-input{
				background: #efeff4;
				border-radius: .56rem;
			}	
		}
		.car_search_bq{
			padding: .2rem .25rem;
			display: flex;
			flex-direction: column;
			/*justify-content: space-around;*/
			.car_pp{
				border: 1px solid #DDDDDD;
				width: 1.5rem;
				margin: .25rem 0;
			}
			select{
				width: 1.5rem;
			}
			.car_search_bq_1{
				align-items: center;
				display: flex;
				span{
					width: 1.5rem;
					text-align: right;
					margin-right: .2rem;
					flex-grow: 0;
				}
				.car_search_bq_1_1{
					width: 2rem;
					flex-grow: 1;
				}
				select{
					border: 1px solid #DDDDDD;
					height: .44rem;
				}
			}
		}
		.popup_header{
			display: flex;
			font-size: .32rem;
			align-items:center ;
			justify-content: space-between;
			img{
				width: .32rem;
				height: .52rem;
				transform: rotate(180deg);
			}
		}
		.popup_list{
			display: flex;
			padding: 0 .2rem;
			align-items: center;
			font-size: .26rem;
			img{
				width: .5rem;
				height: .5rem;
			}
			p{
				border-bottom: 1px solid #DDDDDD;
				flex-grow: 1;
				padding: .25rem 0;
				overflow: hidden;
				overflow: hidden;
				text-overflow:ellipsis;
				white-space: nowrap;
				margin-left: .2rem;
			}
		}
		.yd-tabbar{
			z-index: 999 !important;
		}
		.p_1_z{
			.yd-popup-show {
				z-index: 1501;
			}
		}
		.p_2_z{
			.yd-mask{
				/*z-index: 1999 !important;*/
			}
			.yd-popup-content{
				box-shadow: -1px 0 10px 3px rgba(214,214,214,.3);
				z-index: 2001 !important;
			}
			.yd-popup-show {
				z-index: 2000 ;
			}
			.p_2_title{
				font-size: .32rem;
				font-weight: bold;
				padding:.2rem .15rem ;
				display: flex;
				align-items: center;
				justify-content: space-between;
				span{
					font-size: .26rem;
					font-weight: 500;
				}
			}
			.p_2_name{
				font-size: .28rem;
				background: #D9D9D9;
				padding: .15rem ;
			}
			.popup_2_list{
				display: flex;
				justify-content: space-between;
				padding: .2rem .15rem;
				border-bottom: 1px solid #DDDDDD;
				font-size: .26rem;
				p{
					flex-grow: 1;
					padding-right: .15rem;
					overflow: hidden;
					text-overflow:ellipsis;
					white-space: nowrap;
				}
				div{
					width: .82rem;
					padding-left: .2rem;
					border-left: 1px solid #DDDDDD;
				}
			}
		}
		.other_like {
			padding: 0 .25rem .1rem .25rem;
			border-bottom: 1px #00A3FF solid;
			.like_list {
				margin-bottom: .42rem;
				line-height: .35rem;
				display: flex;
				border-bottom: 1px #d9d9d9 solid;
				.list_img {
					width: 2rem;
					height: 1.5rem;
					background: #dddddd;
					margin-right: .25rem;
					flex-grow: 0;
				}
				.list_right {
					width: 3rem;
					flex-grow: 1;
					.list_name {
						font-size: .28rem;
						font-weight: bold;
						overflow: hidden;
						white-space: nowrap;
						text-overflow: ellipsis;
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