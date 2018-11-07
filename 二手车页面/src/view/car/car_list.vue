<template>
	<yd-layout id='carList'>
		<div class="popup_header">
			<img @click="goBack" src="../../assets/img/listd_icon_right@2x.png" alt="" />
			<div>选择品牌</div>
			<div></div>
		</div>
		<div @click="openCarLit()" class="popup_list">
			<div style="padding: .2rem;font-weight: bold;font-size: .28rem;">不限品牌</div>
		</div>
		<div @click="openCarLit(item)" v-for='item in 30' class="popup_list">
			<img src="" alt="" />
			<p>奥迪{{item}}</p>
		</div>
		<yd-popup v-model="carListShow" width='70%' class='p_2_z' position="right">
			<div class="p_2_title">
				<div>全部车系</div>
				<span @click='closeAll'>关闭</span>
			</div>
			<div class="p_2_name">奥迪汽车</div>
			<div @click="closeTwoPopup" v-for='item in 15' class="popup_2_list">
				<p>奥迪{{item}}</p>
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
			}
		},
		created() {
			console.log(this.$route.query.url)
			console.log(this.$route.params.url)
			if(!this.$route.params.url){
				this.$router.back()
			}
		},
		watch: {

		},
		computed: {

		},
		mounted() {

		},
		methods: {
			closeAll(){
				this.carListShow=false
			},
			closeTwoPopup(item){
				this.$router.push({
					name:this.$route.params.url,
					query:{
						carId1:'1',
						carId2:'2'
					}
				})
			},
			//
			openCarLit(item){
				if(item){
					this.carListShow=true
				}else{
					this.$router.push({
						name:this.$route.params.url,
						query:{
							
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
	}
</style>