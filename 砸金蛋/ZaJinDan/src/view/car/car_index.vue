<template>

	<div id='carIndex'>
		<div style="height: 4.5rem;"></div>
		<div style="background-color: #883636b0;border-radius: 10%;">
			<br>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg1">
				<img src="../../assets/img/egg.png" alt=""  id="egg2">
				<img src="../../assets/img/egg.png" alt=""  id="egg3">
			</div>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg4">
				<img src="../../assets/img/egg.png" alt="" id="egg5">
				<img src="../../assets/img/egg.png" alt="" id="egg6">
			</div>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg7">
				<img src="../../assets/img/egg.png" alt="" id="egg8">
				<img src="../../assets/img/egg.png" alt="" id="egg9">
			</div>
		</div>
		
		<div class="fkzl">
			<div class="fkzl_children">
				<div  class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<img src="../../assets/img/88redb.png" alt="">
				</div>
				<div class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<img src="../../assets/img/88redb.png" alt="">
				</div>
				<div class="fkzl_list" ref='fkzlRef' @click='goCarShowinfo()'>
					<img src="../../assets/img/88redb.png" alt="">
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
				isStatus:0,
				index:1,
				left:'rotate(-15deg)',
				center:'rotate(0deg)',
				right:'rotate(15deg)',
			}
		},
		filters:{
		},
		created() {

		},
		watch: {

		},
		computed: {

		},
		mounted() {
			setInterval(this.runEgg,300);
		},
		methods: {
			runEgg(){
				var id = 'egg' + this.index;
				var egg = document.getElementById(id);
				if(this.isStatus == 0){
					this.isStatus = 1;
					egg.style.transform=this.left;
				}else if(this.isStatus == 1){
					this.isStatus = 2;
					egg.style.transform=this.right;
				}else{
					this.isStatus = 0;
					this.index = this.index  + 1;
					egg.style.transform=this.center;
				}
				
				if(this.index > 9){
					this.index = 1;
				}
			}
		}
	}
</script>

<style lang='scss'>
	html,body{
		width: 100%;
		height: 100%;
	}
	#carIndex {
		width: 100%;
		height: 100%;
		background-image: url(../../assets/img/800.jpg);
		background-size: 100% 100%;
		.egg-div{
			width: 100%;
			text-align:center;
			img{
				display: inline;
				width: 2rem;
			}
		}
		.fkzl {
			padding: .1rem .1rem;
			display: flex;
			margin: 0 0 .3rem .15rem;
			overflow: auto;
			background-color: white;
			&::-webkit-scrollbar {
				width: 0px;
				opacity: 0;
				-webkit-overflow-scrolling: touch;
			}
			.fkzl_children {
				display: flex;
				height: 1.5rem;
				width: 1.5rem;
			}
			.fkzl_list {
				box-shadow: 0px 0px 1px 1px #D6D6D6;
				padding: .2rem .4rem .2rem .44rem;
				width: 2.2rem;
				margin-right: .25rem;
				img{
					width: .9rem;
					height: .5rem;
				}
			}
		}
	}
</style>