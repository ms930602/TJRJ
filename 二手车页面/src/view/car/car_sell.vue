<template>
	<yd-layout id='carSell'>
		<div class="sell_header">
			<img class="header_img" src="../../assets/img/maititle.jpg" style="width: 100%;" alt="" />
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
					<img class="list_img" src="../../assets/img/mb.png" alt="" />
					<p>在线登记</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="../../assets/img/md.png" alt="" />
					<p>客服致电</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="../../assets/img/ma.png" alt="" />
					<p>上门检测</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="../../assets/img/me.png" alt="" />
					<p>最高报价</p>
				</div>
				<div class="lc_list">
					<img class="list_img" src="../../assets/img/mc.png" alt="" />
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
				<img class="list_img" src="../../assets/img/cc1.png" alt="" />
				<p class="p_1">买家多</p>
				<p class="p_2">万千买家竞价</p>
				<p class="p_3">高价胜出</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="../../assets/img/cc2.png" alt="" />
				<p class="p_1">零费用</p>
				<p class="p_2">从登记信息到成交</p>
				<p class="p_3">全程0费用</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="../../assets/img/cc4.png" alt="" />
				<p class="p_1">更安全</p>
				<p class="p_2">专属1对1服务</p>
				<p class="p_3">信息保安全</p>
			</div>
			<div class="fwjs_list">
				<img class="list_img" src="../../assets/img/cc3.png" alt="" />
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
				<yd-accordion-item class='accordion_before' title="买车流程是什么？" open>
					<div style="padding: .24rem;color:#5f5959;margin-left: 10px;">
						<p>在报名页填写预约买车信息，或填写信息咨询我们；</p>
						<p>客服会在24小时内致电邀约检测时间，由专门检测师免费上门为您检测爱车；</p>
						<p>检测报告上传拍场，全国5万家经销商一同竞价；</p>
						<p>双方确认价格后，在门店完成交易。</p>
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="在门店交易要多久">
					<div style="padding: .24rem;color:#5f5959;margin-left: 10px;">
						<p>通常我们的成交手续会在120分钟内完成；</p>
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="完成交易后,办理过户手续有哪些事项？">
					<div style="padding: .24rem;color:#5f5959;margin-left: 10px;">
						<p>在拿到退牌单（沪牌）或过户证明（外牌）后，将在4个工作日内完成客户押金的退还；</p>
						<p>手续常规办理时限：收齐上家材料起；</p>
						<p>上海：</p>
						<p>沪大牌：6个工作日、沪C牌：10个工作日、外地牌：20个工作日内完成过户。</p>
						<p>北京、天津：</p>
						<p>本地牌：7个工作日、外地牌：15个工作日内完成过户。</p>
						<p>广州、东莞、深圳、佛山：</p>
						<p>本地牌、外地牌：20个工作日内完成过户。</p>
						<p>成都、重庆、武汉、南京、苏州、杭州：</p>
						<p>本地牌、外地牌：7个工作日内完成过户。</p>
						<p style="color: red;">*以上时间均为工作日</p>
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="如果在门店未能如愿提交,后续会如何处理？">
					<div style="padding: .24rem;color:#5f5959;margin-left: 10px;">
						<p>如您今天最终未能如愿成交，我们建议您选择进行二次拍卖，已找到更加合理的价格出售。</p>
					</div>
				</yd-accordion-item>
				<yd-accordion-item class='accordion_before' title="到店成交需要哪些材料？">
					<div style="padding: .24rem;color:#5f5959;margin-left: 10px;">
						<p>机动车行驶证</p>
						<p>机动车登记证（产证）</p>
						<p>车辆主钥匙、备用钥匙</p>
						<p>车辆购置税完税证</p>
						<p>交强险保单</p>
						<p>车辆说明书</p>
						<p>车主身份证明原件</p>
						<p>车主银行卡复印件</p>
						<p>保养手册</p>
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
				form:{
					
				},
				phoneNum: '',
				phoneYzm: '',
				submitPhoneNum:''
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
			submit() {
				if(this.submitPhoneNum == this.phoneNum){
					this.$dialog.toast({
						mes: '申请成功，客服马上与您联系!！',
						timeout: 1500
					});
					return;
				}
				this.submitPhoneNum = this.phoneNum
				if(!this.phoneNum) {
					this.$dialog.toast({
						mes: '请输入手机号码！',
						timeout: 1500
					});
					return
				}
				if(this.isPhone) {
					this.$root.ajax({
						name:'carTo/saveConsu',
						params:{
							phone:this.phoneNum,
							status:0,
							context:'我要卖车'
						},
					}).then((d)=>{
						if(d.state == 0){
							this.$dialog.toast({
								mes: '申请成功，客服马上与您联系！',
								timeout: 1500
							});
						}else{
							this.$dialog.toast({
								mes: '申请失败，后台错误！',
								timeout: 1500
							});
						}
					})
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