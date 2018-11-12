<template>
	<yd-layout id='carBuy'>
	<yd-actionsheet :items="myItems2" v-model="show2"></yd-actionsheet>
	<yd-actionsheet :items="myItems1" v-model="show1"></yd-actionsheet>
    <yd-search slot='top'  v-model="value1" class='buy_search_input' :on-submit="submitHandler" :on-cancel="cancelHandler"></yd-search>
    <!--<yd-search :result="result" fullpage v-model="value1" :item-click="itemClickHandler" :on-submit="submitHandler"></yd-search>-->
		<div style="background-color: #efeff4;" class="search-div">
			<div style="display: flex;align-items: center;">
				&nbsp;&nbsp;&nbsp;
				<span @click="carPp">
					品牌<img src="../../assets/img/search.png" alt="">
				</span>&nbsp;&nbsp;&nbsp;
				<span @click="show2 = true">
					智能排序<img src="../../assets/img/search.png" alt="">
				</span>&nbsp;&nbsp;&nbsp;
				<span @click="show1 = true">
					价格区间<img src="../../assets/img/search.png" alt="">
				</span>&nbsp;&nbsp;&nbsp;
			</div>
			<span @click="reset" style="float: right;margin-right: 10px;">点击重置</span>
		</div>
		<br/>
		&nbsp;&nbsp;&nbsp;
		<yd-badge type="warning" v-if="brandType!=null && brandType!=''">
			{{brandType}} 
			<span class="sx_badge" @click="removeBadge(2)">X</span>
		</yd-badge>
		<yd-badge type="warning" v-if="searchParam.orderField!=null">
			<span v-if="searchParam.orderField=='f_show_price'">价格最低</span>
			<span v-if="searchParam.orderField=='f_createtime'">最新发布</span>
			<span v-if="searchParam.orderField=='f_mileage'">里程最少</span>
			<span class="sx_badge" @click="removeBadge(1)">X</span>
		</yd-badge>
		<yd-badge type="warning" v-if="searchParam.maxPrice!=null">
			<span >
			{{searchParam.minPrice}}&nbsp;&nbsp;~&nbsp;&nbsp;{{searchParam.maxPrice==10000?'*':searchParam.maxPrice}}&nbsp;万
			</span>
			<span class="sx_badge" @click="removeBadge(3)">X</span>
		</yd-badge>
		<br/><br/>
		<!-- <img :src="$root.config.img_url" alt=""> -->
		<yd-infinitescroll :callback="loadList" ref="infinitescrollDemo">
			<div class="other_like" slot="list" >
				<div class="like_list"  @click='goCarXq(item.id)' v-for='item in dataList'>
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
			<!-- 数据全部加载完毕显示 -->
			<span slot="doneTip">啦啦啦，啦啦啦，没有数据啦~~</span>

			<!-- 加载中提示，不指定，将显示默认加载中图标 -->
			<img slot="loadingTip" src="http://static.ydcss.com/uploads/ydui/loading/loading10.svg" />

		</yd-infinitescroll>
		<hr/><br/>
		<div class="other_like_title" v-if="carList!=null && carList.length>0">你可能还喜欢</div>
		<div class="other_like"  v-if="carList!=null && carList.length>0">
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
	</yd-layout>
</template>

<script>
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
				searchParam:{
					offerStatue:0,
					orderField:null,
					pageSize:10,
					pageNum:1,
					searchType:1,//1 非特价车 2 特价车
					type:'',//车型
					minPrice:null,
					maxPrice:null
				},
				brandType:null,
				pageNum:1,
				pageSize:10,
				value1: '',
				result: [],
				carList:[],
				rightPopup:false,
				carListShow:false,
				dataList:[],
				show2: false,
                myItems2: [
					{
						label: '智能排序',
						callback: () => {
							this.searchParam.orderField = null;
							this.reLoadList();
						}
					},
                    {
                        label: '最新发布',
                        callback: () => {
                            this.searchParam.orderField = 'f_createtime';
							this.reLoadList();
                        }
                    },{
                        label: '价格最低',
                        callback: () => {
                            this.searchParam.orderField = 'f_show_price';
                            this.reLoadList();
                        }
                    },{
                        label: '里程最少',
                        callback: () => {
                            this.searchParam.orderField = 'f_mileage';
                            this.reLoadList();
                        }
                    },
                ],
				show1: false,
				myItems1: [
					{
						label: '无限制',
						callback: () => {
							this.searchParam.minPrice = null;
							this.searchParam.maxPrice = null;
							this.reLoadList();
						}
					},
					{
						label: '价格区间：0 ~ 5 万',
						callback: () => {
							this.searchParam.minPrice = 0;
							this.searchParam.maxPrice = 5;
							this.reLoadList();
						}
					},{
						label: '价格区间：5 ~ 10 万',
						callback: () => {
							this.searchParam.minPrice = 5;
							this.searchParam.maxPrice = 10;
							this.reLoadList();
						}
					},{
						label: '价格区间：10 ~ 15 万',
						callback: () => {
							this.searchParam.minPrice = 10;
							this.searchParam.maxPrice = 15;
							this.reLoadList();
						}
					},{
						label: '价格区间：15 ~ 20 万',
						callback: () => {
							this.searchParam.minPrice = 15;
							this.searchParam.maxPrice = 20;
							this.reLoadList();
						}
					},{
						label: '价格区间：20 ~ 30 万',
						callback: () => {
							this.searchParam.minPrice = 20;
							this.searchParam.maxPrice = 30;
							this.reLoadList();
						}
					},{
						label: '价格区间：30以上',
						callback: () => {
							this.searchParam.minPrice = 30;
							this.searchParam.maxPrice = 10000;
							this.reLoadList();
						}
					}
				]
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
			if(carId1 && carId2){
				if(carId1 == '无限制'){
					this.brandType = carId1;
					this.searchParam.type = '';
				}else{
					this.brandType=carId1+"--"+carId2;
					this.searchParam.type = carId2;
				}
			}
			this.reLoadList()
		},
		methods: {
			queryCarInfo(){
				var searchPatam = {
					offerStatue:0,
					pageNum:1,
					pageSize:20,
					orderField:'f_upbk_time'
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
					offerStatue:0,
					orderField:null,
					pageSize:10,
					pageNum:1,
					searchType:1,//1 非特价车 2 特价车
					type:'',//车型
					minPrice:null,
					maxPrice:null
				};
				this.brandType = '';
				this.carList = [];
				this.reLoadList();
			},
			carPp(){
				this.rightPopup=true
				this.$router.push({
					name:'car_list',
					params:{
						url:'car_buy'
					}
				})
			},
			reLoadList(){
				this.dataList = [];
				this.carList = [];
				this.loadList();
			},
			cancelHandler() {
				this.value1='';
				this.searchParam.title='';
				this.reLoadList();
			},
			loadList(){
				this.searchParam.title = this.value1;
				this.searchParam.pageNum = this.pageNum;
				this.$root.ajax({
					name:'carTo/queryInfo',
					params:this.searchParam,
				}).then((d)=>{
					if(d.aaData == null || d.aaData.length == 0){
						this.queryCarInfo();
					}
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
			itemClickHandler(item) {
				this.$dialog.toast({
					mes: `搜索：${item}`
				});
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
	.search-div{
		display: flex;
		align-items: center;
		justify-content: space-between;
		span{
			font-size: .27rem;
			display: flex;
			align-items: center;
			color: #8a92a0;
		}
		img{
			display: inline-table;
		}
	}
	.sx_badge{
		color: #000000b3;
		font-weight: bold;
	}
	#carBuy {
		.buy_search_input{
			.yd-search-input{
				background: white;
			}
			.search-input{
				background: #efeff4;
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