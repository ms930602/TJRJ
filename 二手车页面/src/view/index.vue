<template>
	<yd-layout id='index'>
		<router-view/>
		<yd-tabbar slot="tabbar"  active-color='#ff0000'>
	        <yd-tabbar-item title="首页" @click.native='footerNav(1)' :active='active1' link="/index">
	            <yd-icon name="home"  slot="icon" size="0.54rem"></yd-icon>
	        </yd-tabbar-item>
	        <yd-tabbar-item title="买车" @click.native='footerNav(2)' :active='active2' link="/car_buy">
	            <yd-icon name="maiche2" custom slot="icon" size="0.39rem"></yd-icon>
	        </yd-tabbar-item>
	        <yd-tabbar-item title="卖车" @click.native='footerNav(3)' :active='active3' link="/car_sell">
	            <yd-icon name="maiche1" custom slot="icon" size="0.54rem"></yd-icon>
	        </yd-tabbar-item>
	        
	        <yd-tabbar-item title="促销" @click.native='footerNav(4)' :active='active4' link="/car_discover">
				<yd-icon name="iconfontzhizuobiaozhun0299" custom slot="icon" size="0.42rem"></yd-icon>
	        </yd-tabbar-item>
	    </yd-tabbar>
	</yd-layout>
</template>

<script>
	import {TabBar, TabBarItem} from 'vue-ydui/dist/lib.rem/tabbar';
	export default {
		components:{
			[TabBar.name]:TabBar,
			[TabBarItem.name]:TabBarItem,
		},
		data() {
			return {
				active1:false,
				active2:false,
				active3:false,
				active4:false,
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
			footerNav(val){
				this.active1=false
				this.active2=false
				this.active3=false
				this.active4=false
//				this['active'+val]=true
			}
		}
	}
</script>

<style lang='scss'>
	#index{
		.yd-scrollview:after{
			display: none !important;
		}
		.router-link-active {
			color: red !important;
		}
	}
</style>