import axios from 'axios';
import { Toast } from 'vant';
import {  Loading } from 'vue-ydui/dist/lib.rem/dialog';
export default {
	data() {
		return {
			traceablityNo:'',
			config:config,
			userInfo:sessionStorage.getItem('qr_userinfo')?JSON.parse(sessionStorage.getItem('qr_userinfo')):'',
			openId:sessionStorage.getItem('qr_openId'),
			isPhone:false,
			isPcPhone:false,
		}
	},
	mounted() {
		this.isPhone=!this.isPcOS()
		this.isPcPhone=this.isPcOS()&&!this.isPc()
	},
	methods: {
		ajax({
			//左边代表那边传过来的参数，右边代表新建
			url: url,
			user:user,
			name:name,
			params: params,
			type: type,
			errormsg:error,//false,true
			otherUrl:otherUrl,
			closeDia:closeDia,
		} = {}) {
			if(type == 'post' || type == 'get') {
				type = type
			} else {
				type = 'post'
			}
			error?error=true:error=false;
			if(this.userInfo){
				params.token?params.token=params.token:params.token=this.userInfo.token
			}
			url?url=url:url=this.config.api_url
			if(user){
				url=url+'api/user/'+name
			}else{
				url=url+name
			}
			
			if(type == 'post') {
				return new Promise((resolve, reject) => {
					Loading.open('加载中，请稍后...');
					axios({
							method: type,
							url: url,
							headers: { "Content-Type": "application/x-www-form-urlencoded" },
							data: params,	
							transformRequest: [function(params) {
								var paramStr = '';
								for(var key in params) {
									paramStr += key + "=" + params[key] + "&";
								}
								return paramStr;
							}],
						}).then(function(response) {
							Loading.close();
							if(response.data.success) {
								resolve(response.data)
							} else {
								if(error){
									resolve(response.data)
								}
								if(!closeDia){
									Toast(response.data.msg);
								}
							}
						})
						.catch(function(error) {
							Loading.close();
							console.log(error);
							Toast('接口异常');
						});
				})
			} else {
				return new Promise((resolve, reject) => {
					Loading.open('加载中，请稍后...');
					axios.get(url, {
							params: params
						})
						.then(function(response) {
							Loading.close();
							if(response.data.success) {
								resolve(response.data)
							} else {
								resolve(response.data)
								Toast(response.data.msg);
							}
						})
						.catch(function(error) {
							Loading.close();
							console.log(error);

						});
				})
			}
		},
		//判断是否电脑的模拟手机并且给swiper加onClick或者onTap事件
		getOS() {
			if(this.isPcOS()) {
				return 'pcOS'
			} else {
				return 'sjOS'
			}
		},
		//判断操作系统
		isPcOS() {
			var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");
			if(isWin) return true; //'Win'
			var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
			if(isMac) return true; //'Mac'
			var isUnix = (navigator.platform == "X11") && !isWin && !isMac;
			if(isUnix) return true; //'Unix'
			var isLinux = (String(navigator.platform).indexOf("Linux") > -1);
			if(isLinux) return true; //'Linux'
		},
		//获取是否PC端
		isPc() {
			var ua = navigator.userAgent;
			if((ua.match(/(Android|webOS|iPhone|iPad|iPod|BlackBerry|Windows Phone)/i))) {
				if(/iPhone|iPad|iPod/.test(ua)) {
					//'ios'
					return false
				} else if(/Android/.test(ua)) {
					//'android'
					return false
				}
			} else {
				//'pc'
				return true
			}
		},
		//获取手机名称
		getDeviceInfo(ua, a) {
			//		var ua = navigator.userAgent;
			//		var mm = ['iPhone', 'iPad', 'iPod', 'Nexus', 'BenQ-Siemens', 'Meizu', 'Xiaomi', 'BlackBerry', 'CoolPad', 'Dell', 'HTC', 'Huawei', 'Kindle', 'K-Touch', 'Lenovo', 'LG', 'Motorola', 'Nintendo', 'Nokia', 'Onda', 'OPPO', 'OLPC', 'Palm', 'PlayStation', 'Samsung', 'SonyXperia', 'SonyEricsson', 'vivo', 'ZTE', 'UbuntuPhone', 'UbuntuTablet', 'WindowsPhone']
			var devices = a,
				device,
				c,
				i = 0;
			while(device = devices[i++]) {
				var d = new RegExp("(" + device + ")", "i");
				if(d.test(ua.toLowerCase())) c = device;
			}
			switch(c) {
				case undefined:
					c = 'Android';
					break;
				case 'iPhone OS':
					c = 'iOS';
					break;
			}
			return c;
		},
		//获取时间格式化
		getDate(date) {
			var year = date.getFullYear()
			var month = date.getMonth()
			var day = date.getDate()
			var d = date.getFullYear() + '-' + (month < 10 ? '0' + (month + 1) : (month + 1)) + '-' + (day < 10 ? '0' + day : day)
			return d
		},
		getNumDate(n){
			var date=new Date();
			var newDate=new Date();
			date.setDate(date.getDate()-n);
			var month = date.getMonth() + 1
			var day = date.getDate()
			var d = date.getFullYear() + '-' + (month < 10 ? '0' + month  : month ) + '-' + (day < 10 ? '0' + day : day)
			return d
		},
		//导航栏路由跳转
		onClickLeft() {
			window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/')
		},
		onClickRight(){
			this.$router.push({name:'index',query:{traceablityNo:this.$route.query.traceablityNo}})
		},
		//获取url参数
		getQueryString(name) {
			var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
			var r = window.location.search.substr(1).match(reg);
			if(r != null) {
				return unescape(r[2]);
			}
			return null;
		},
		//获取来源渠道
		sources() {
			var ua = navigator.userAgent;
			var f = this.getQueryString('f');
			if(f != null) {
				return f;
			}
			var wxFrom = this.getQueryString('from');
			if(wxFrom != null) {
				if(wxFrom == 'groupmessage') {
					return 'Wechat';
				} else if(wxFrom == 'singlemessage') {
					return 'Weixin';
				}
			}
			if(f == null && wxFrom == null) {
				var str='FitIdx'
				if(ua.match(/QQ/i) == "QQ") {
					//return "QQ";
					str='QQ'
				}
				if(ua.match(/MicroMessenger/i) == "MicroMessenger") {
					//return "Weixin";
					str='Weixin'
				}
				return str
			}
		}
	},
}