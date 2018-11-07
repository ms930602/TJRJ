<template>
	<yd-layout id='carSell'>
		<div class="sell_header">
			<img class="header_img" src="" alt="" />
		</div>
		<div class="sell_car">
			<div class="popup_input popup_input_1">
				<div>
					<span>手机号</span>
					<input type="number" v-model="phoneNum" @input="changeInput(phoneNum)" pattern="\d*" oninput="if(value.length>11)value=value.slice(0,11)" placeholder="请输入手机号码" />
				</div>
			</div>
			<div class="popup_submit" @click='submit'>我要卖车</div>
		</div>

		<div class="sell_lc">
			<div class="lc_title">
				<div class="lc_title_c">
					<div class="henxian"></div>
					<div class="lc_name">卖车流程</div>
					<div class="henxian"></div>
				</div>
			</div>
			<div class="lc_list_f">
				<div class="lc_list">
					<img class="list_img" src="" alt="" />
					<p>在线登记</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="" alt="" />
					<p>客服致电</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="" alt="" />
					<p>上门检测</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="" alt="" />
					<p>最高报价</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="" alt="" />
					<p>交车打款</p>
				</div>
			</div>
		</div>
		<div class="lc_title">
			<div class="lc_title_c">
				<div class="henxian"></div>
				<div class="lc_name">服务介绍</div>
				<div class="henxian"></div>
			</div>
		</div>
		<div class="fwjs">

			<div class="fwjs_list">
				<img class="list_img" src="" alt="" />
				<p class="p_1">买家多</p>
				<p class="p_2">万千买家竞价</p>
				<p class="p_3">高价胜出</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="" alt="" />
				<p class="p_1">零费用</p>
				<p class="p_2">从登记信息到成交</p>
				<p class="p_3">全程0费用</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="" alt="" />
				<p class="p_1">更安全</p>
				<p class="p_2">专属1对1服务</p>
				<p class="p_3">信息保安全</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="" alt="" />
				<p class="p_1">成交快</p>
				<p class="p_2">高效检测上拍</p>
				<p class="p_3">快至一天售出</p>
			</div>
		</div>
		<div class="cjwt">
			<div class="lc_title">
				<div class="lc_title_c">
					<div class="henxian"></div>
					<div class="lc_name">常见问题和解答</div>
					<div class="henxian"></div>
				</div>
			</div>
			<yd-accordion accordion>
				<yd-accordion-item class='accordion_before' title="李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白李白" open>
					<div style="padding: .24rem;">
						李白（701年－762年），字太白，号青莲居士，又号“谪仙人”，是唐代伟大的浪漫主义诗人，被后人誉为“诗仙”，与杜甫并称为“李杜”，为了与另两位诗人李商隐与杜牧即“小李杜”区别，杜甫与李白又合称“大李杜”。其人爽朗大方，爱饮酒作诗，喜交友。
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="杜甫">
					<div style="padding: .24rem;">
						杜甫（712年—770年），字子美，汉族，本襄阳人，后徙河南巩县。自号少陵野老，唐代伟大的现实主义诗人，与李白合称“李杜”。为了与另两位诗人李商隐与杜牧即“小李杜”区别，杜甫与李白又合称“大李杜”，杜甫也常被称为“老杜”。
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="王维">
					<div style="padding: .24rem;">
						王维（701年－761年，一说699年—761年），河东蒲州（今山西运城）人，祖籍山西祁县。唐朝著名诗人、画家，字摩诘，号摩诘居士。
					</div>
				</yd-accordion-item>
			</yd-accordion>
		</div>
		 <yd-backtop></yd-backtop>
	</yd-layout>
</template>

<script>
	import {BackTop} from 'vue-ydui/dist/lib.rem/backtop';
	import { SendCode } from 'vue-ydui/dist/lib.rem/sendcode';
	import { Accordion, AccordionItem } from 'vue-ydui/dist/lib.rem/accordion';
	export default {
		components: {
			[SendCode.name]: SendCode,
			[Accordion.name]: Accordion,
			[AccordionItem.name]: AccordionItem,
			[BackTop.name]: BackTop,
		},
		data() {
			return {
				firstStart: false,
				start: false,
				phoneNum: '',
				phoneYzm: '',
			}
		},
		created() {

		},
		watch: {

		},
		computed: {

		},
		mounted() {
			this.$root.ajax({
				name: 'inmarketdetail/updateStatusByMainId',
				params: {
					id: 31,
					statusId: 1,
					inWeight: 33,
					token: "45791d63-4602-4ef7-b0e2-999a6f803734",
				}
			}).then(() => {

			})
		},
		methods: {
			submit() {
				if(!this.phoneNum) {
					this.$dialog.toast({
						mes: '请输入手机号码！',
						timeout: 1500
					});
					return
				}
				if(this.isPhone) {
					this.$root.ajax({})
				} else {
					this.$dialog.toast({
						mes: '请输入正确的手机号码！',
						timeout: 1500
					});
					return
				}
			},
			changeInput(val) {
				var reg = /^1[345789][0-9]{9}$/;
				if(reg.test(val)) {
					this.isPhone = true
				} else {
					this.isPhone = false
				}
			},
		}
	}
</script>

<style lang='scss'>
	#carSell {
		margin-bottom: .5rem;
		.sell_header {
			.header_img {
				height: 2.5rem;
			}
		}
		.yd-scrollview:after {
			/*display: none;*/
		}
		.popup_input {
			margin: .2rem;
			border-bottom: 1px solid #DDDDDD;
			padding: .2rem 0;
			display: flex;
			align-items: center;
			font-size: .28rem;
			span {
				margin-right: .2rem;
			}
			input {
				outline: none;
				border: none;
			}
		}
		.popup_input_1 {
			justify-content: space-between;
		}
		.popup_submit {
			border-radius: .04rem;
			margin: .4rem auto 0;
			width: 90%;
			font-size: .4rem;
			text-align: center;
			line-height: 0.8rem;
			background: #F56C6C;
			color: white;
		}
		.sell_car {
			padding: .3rem 0;
			box-shadow: 0 0 3px 3px rgba(221, 221, 221, .5);
			width: 93.33%;
			margin: .3rem auto 0;
			.popup_input {
				width: 90%;
				margin: auto;
			}
		}
		.lc_title {
			justify-content: center;
			/*align-items: center;*/
			display: flex;
			.lc_title_c {
				display: flex;
				align-items: center;
				justify-content: space-between;
				display: flex;
				.henxian {
					width: 1rem;
					height: 1px;
					background: #D6D6D6;
				}
				.lc_name {
					font-size: .32rem;
					font-weight: bold;
					margin: .3rem .2rem;
				}
			}
		}
		.sell_lc {
			.lc_list_f {
				display: flex;
				.lc_list {
					position: relative;
					width: 25%;
					.list_img {
						width: 1rem;
						height: 1rem;
						margin: 0 auto .2rem;
					}
					p {
						text-align: center;
					}
					&:after {
						content: '';
						width: 0;
						height: 0;
						display: inline-block;
						border-top: .07rem solid #D6D6D6;
						border-right: .07rem solid #D6D6D6;
						border-bottom: .07rem solid transparent;
						border-left: .07rem solid transparent;
						transform: rotate(45deg);
						position: absolute;
						right: 0;
						top: .42rem;
					}
					&:last-child:after {
						display: none;
					}
				}
			}
		}
		.fwjs {
			display: flex;
			flex-wrap: wrap;
			.fwjs_list {
				text-align: center;
				margin-bottom: .25rem;
				width: 50%;
				.list_img {
					width: 2rem;
					height: 2rem;
					margin: 0 auto .2rem;
				}
				.p_1 {
					font-size: .32rem;
					font-weight: bold;
				}
			}
		}
		.cjwt{
			.accordion_before{
				
				.yd-accordion-title{
					position: relative;
					&:before{
						content: '';
						width: .07rem;
						height: .07rem;
						display: inline-block;
						position: absolute;
						border-radius: 50%;
						left: 0rem;
						background: red;
						top: 45%;
					}
				}
				
				.yd-accordion-title{
					span{
						padding-left: .2rem;
					}
					
				}
			}
		}
		.yd-backtop.yd-backtop-inlay{
			background: rgba(0,0,0,.3);
			&:after{
				color: white;
			}
		}
	}
</style>