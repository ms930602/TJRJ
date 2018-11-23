<template>
	<yd-layout id='carList'>
		<div class="xq_header_c"  slot='top'>
			<div class="header_back" @click="$router.back()">
				<img class="header_img" src="../../assets/img/listd_icon_right@2x.png" alt="">
			</div>
			
		</div>
		<div @click="openCarLit()" class="popup_list">
			<div style="padding: .2rem;font-weight: bold;font-size: .28rem;">
				不限品牌&nbsp;&nbsp;<span style="border: 1px solid;color: #b2b2b2;font-size: 10px;">点击</span> </div>
			<hr/>
		</div>
		<div @click="openCarLit(item)" v-for='item in brandList' class="popup_list">
			<img :src="$root.config.img_url+item.imgStr" alt="" />
			<p>&nbsp;&nbsp;{{item.name}}</p>
		</div>
		<yd-popup v-model="carListShow" width='70%' class='p_2_z' position="right">
			<div class="p_2_title">
				<div>全部车系</div>
				<span @click='closeAll'>关闭</span>
			</div>
			<div class="p_2_name">{{selectItem.name}}</div>
			<div @click="closeTwoPopup(item)" v-for='item in brandTypeList' class="popup_2_list">
				<p>{{item}}</p>
				<div>车型</div>
			</div>
		</yd-popup>
	</yd-layout>
</template>

<script>
	import {Popup} from 'vue-ydui/dist/lib.rem/popup';
	export default {
		components: {
			[Popup.name]: Popup,
		},
		data() {
			return {
				carListShow: false,
				brandList:[],
				brandTypeList:[],
				selectItem:{},
			}
		},
		created() {
			if(!this.$route.params.url){
				this.$router.back()
			}
		},
		watch: {

		},
		computed: {

		},
		mounted() {
			this.loadBrand();
		},
		methods: {
			loadBrand(){
				this.$root.ajax({
					name:'carTo/queryBrand',
					params:{
						pageNum:1
					},
				}).then((d)=>{
					if(d.state == 0){
						this.brandList = d.aaData;
					}
				})
			},
			closeAll(){
				this.carListShow=false
			},
			closeTwoPopup(item){
				this.$router.push({
					name:this.$route.params.url,
					query:{
						carId1:this.selectItem.name,
						carId2:item,
						searchA:this.$route.params.searchA,
						searchB:this.$route.params.searchB
					}
				})
			},
			//
			openCarLit(item){
				if(item){
					this.selectItem = item;
					this.$root.ajax({
						name:'carTo/queryBrandType',
						params:{
							type:item.name
						},
					}).then((d)=>{
						if(d.state == 0){
							this.brandTypeList = d.aaData;
							this.carListShow=true
						}
					})
				}else{
					this.$router.push({
						name:this.$route.params.url,
						query:{
							carId1:'无限制',
							carId2:'无限制'
						}
					});
				}
			},
			//返回
			goBack(){
				this.$router.back();
			}
		}
	}
</script>

<style lang='scss'>
	#carList {
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
		.popup_header{
			display: flex;
			font-size: .32rem;
			align-items:center ;
			padding: .15rem .25rem;
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
			margin-left: .2rem;
			img{
				width: .8rem;
				height: .81rem;
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
	}
</style>