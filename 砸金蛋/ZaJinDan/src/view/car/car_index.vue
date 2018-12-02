<template>

	<div id='carIndex'>
		<div style="height: 4.5rem;"></div>
		<div style="background-color: #883636b0;border-radius: 10%;" @click="show1 = true">
			<br>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg1" >
				<img src="../../assets/img/egg.png" alt=""  id="egg2" >
				<img src="../../assets/img/egg.png" alt=""  id="egg3" >
			</div>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg4" >
				<img src="../../assets/img/egg.png" alt="" id="egg5" >
				<img src="../../assets/img/egg.png" alt="" id="egg6" >
			</div>
			<div class="egg-div">
				<img src="../../assets/img/egg.png" alt="" id="egg7" >
				<img src="../../assets/img/egg.png" alt="" id="egg8" >
				<img src="../../assets/img/egg.png" alt="" id="egg9" >
			</div>
		</div>
		
		<div style="position: fixed;bottom: 0;width: 100%;">
			<div class="fkzl">
				<div class="fkzl_children">
					<div  class="fkzl_list" ref='fkzlRef' style="">
						<img src="../../assets/img/asd.png" alt="">
					</div>
					<div  class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/88redb.png" alt="">
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/50redb.png" alt="">
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/10redb.png" alt="">
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/sjredb.png" alt="">
					</div>
					<div class="fkzl_list" ref='fkzlRef'>
						<img src="../../assets/img/lb.png" alt="" style="width: 1.5rem;height: 1.2rem;margin-top: -10px;">
					</div>
				</div>
			</div>
		</div>
		
		<yd-popup v-model="show1" position="center" width="90%">
            <div class="popDiv">
							<a href="javascript:void(0)" style="float: right;width: 1rem;" @click="show1=false">&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </div>
        </yd-popup>
	</div>
</template>

<script>
	import { Slider, SliderItem } from 'vue-ydui/dist/lib.rem/slider';
	import { Tab, TabPanel } from 'vue-ydui/dist/lib.rem/tab';
	import {Popup} from 'vue-ydui/dist/lib.rem/popup';
	export default {
		components: {
			[Slider.name]: Slider,
			[SliderItem.name]: SliderItem,
			[Tab.name]: Tab,
			[TabPanel.name]: TabPanel,
			[Popup.name]: Popup,
		},
		data() {
			return {
				show1:false,
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
				width: 1.5rem;
			}
		}
		.popDiv{
			height: 6rem;
			width: 90%;
			 background-image: url(../../assets/img/ddd.png);
			 background-size: 100%;
		}
		.fkzl {
			padding: .1rem .1rem;
			background-color: #ffdd00;
			&::-webkit-scrollbar {
				width: 0px;
				opacity: 0;
				-webkit-overflow-scrolling: touch;
			}
			.fkzl_children {
				display: flex;
				height: 1rem;
				width: 1rem;
			}
			.fkzl_list {
				width: 2.2rem;
				margin-right: .25rem;
				img{
					width: 1rem;
					height: 1rem;
				}
			}
		}
	}
</style>