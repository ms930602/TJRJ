<template>
	<yd-layout id='index'>
		<router-view/>
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