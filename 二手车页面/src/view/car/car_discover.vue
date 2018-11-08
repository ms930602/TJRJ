<template>
	<yd-layout id='carDiscover'>
		
    <yd-search slot='top' v-model="value1" class='buy_search_input' :on-submit="submitHandler"></yd-search>
    <img class="header_img" src="../../assets/img/tjc.jpg" alt="" style="width: 100%;"/>
    	
    <!--<yd-search :result="result" fullpage v-model="value1" :item-click="itemClickHandler" :on-submit="submitHandler"></yd-search>-->
		<div class="car_search_bq">
			<div class="car_search_bq_1">
				<span>筛选条件：</span>
				<select  class="car_search_bq_1_1" name="" :value="1" id="">
				<option value="1">智能排序</option>
				<option value="2">价格最低</option>
				<option value="3">最新发布</option>
				<option value="4">车龄最短</option>
				<option value="5">里程最少</option>
				<option value="6">资料最全</option>
				</select>
			</div>
			<div class="car_search_bq_1">
				<span>品牌：</span>
				<div @click='carPp' class="car_pp car_search_bq_1_1">不限品牌</div>
			</div>
			<div class="car_search_bq_1">
				<span>价格区间：</span>
				<select name="" class="car_search_bq_1_1" :value="1" id="">
					<option value="1">不限</option>
					<option value="2">0-3万</option>
					<option value="3">3-5万</option>
					<option value="4">5-10万</option>
					<option value="5">10-15万</option>
					<option value="6">15-20万</option>
					<option value="7">20-30万</option>
					<option value="8">30-50万</option>
					<option value="9">50万以上</option>
				</select>
			</div>
		</div>
			
		<!--<yd-infinitescroll :callback="loadList" ref="infinitescrollDemo">-->
			<div class="other_like">
				<div class="like_list" @click='goCarXq(item)' v-for='item in 15'>
					<img src="" class="list_img" alt="" />
					<div class="list_right">
						<div class="list_name"><span>促销</span>车子名字车子名字车子名字车子名字车子名字车子名字车子名字</div>
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
			<!-- 数据全部加载完毕显示 -->
			<!--<span slot="doneTip">啦啦啦，啦啦啦，没有数据啦~~</span>-->

			<!-- 加载中提示，不指定，将显示默认加载中图标 -->
			<!--<img slot="loadingTip" src="http://static.ydcss.com/uploads/ydui/loading/loading10.svg" />-->

		<!--</yd-infinitescroll>-->
	</yd-layout>
</template>

<script>
	import { Search } from 'vue-ydui/dist/lib.rem/search';
	import { TabBar, TabBarItem } from 'vue-ydui/dist/lib.rem/tabbar';
	import {InfiniteScroll} from 'vue-ydui/dist/lib.rem/infinitescroll';
	export default {
		components: {
			[TabBar.name]: TabBar,
			[TabBarItem.name]: TabBarItem,
			[Search.name]: Search,
			[InfiniteScroll.name]: InfiniteScroll,
		},
		data() {
			return {
				pageNum:1,
				pageSize:10,
				value1: '',
				result: [],
				rightPopup:false,
				carListShow:false,
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
//			this.loadList()
		},
		methods: {
			carPp(){
				this.rightPopup=true
				this.$router.push({
					name:'car_list',
					params:{
						url:'car_discover'
					}
				})
			},
			loadList(){
				this.$root.ajax({
					name:'',
					params:{
						pageNum:this.pageNum,
						pageSzie:this.pageSize,
					},
				}).then((d)=>{
					

                    this.dataList = [...this.list, ...d.aaData];

                    if (this.dataList>=d.count) {
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
				this.$dialog.toast({
					mes: `搜索：${value}`
				});
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
	#carDiscover {
		.header_img{
			height: 2.5rem;
		}
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
						flex-grow: 1;
						font-weight: bold;
						font-size: .28rem;
						span{
							display: inline-block;
							padding: .05rem .1rem ;
							margin-right: .1rem;
							border-radius: .04rem;
							font-size: .24rem;
							line-height: .24rem;
							color: white;
							background: red;
						}
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