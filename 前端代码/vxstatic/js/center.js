var ROOT_SERVER = "http://msserver.nat300.top/warehouse-pre-interface//api/ware/";
var ROOT_VX = "http://msserver.nat300.top/warehouse-pre-interface/vx/";
var FILE_ROOT   = "http://msserver.nat300.top/warehouse-pre-interface/servlet/getfile?path=";
var colorList = ['#928f21','#cac62c','#fdf835']
var phoneTo;
var priceLike = 10000;
var musicPlay = true;
var flagIndex = 0;
var kehuName = '王女士';
var kehuPhone = '';

function runA(){
	var textA = document.getElementById("buyPeopleNumA");
	var textB = document.getElementById("showPeopleNum");
	textA.style.color = colorList[flagIndex];
	textB.style.color = colorList[flagIndex];
	flagIndex ++ ;
	if(flagIndex == 3)flagIndex = 0;
	setTimeout("runA()",600);
}

  function isPoneAvailable(str) {
		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
		if (!myreg.test(str)) {
				return false;
		} else {
				return true;
		}
}


function payItem(){
	var username = $("#userName").val();
	var userPhone = $("#userPhone").val();
	
	if(!username && username == '' ){
		mui.alert("用户名不能为空~！","提示");
		return;
	}
	if(username.length > 100 ){
		mui.alert("用户名太长~！","提示");
		return;
	}
	
	if(!userPhone && userPhone == ''){
		mui.alert("手机号不能为空~！","提示");
		return;
	}
	
	if(!isPoneAvailable(userPhone)){
		mui.alert("手机号格式不正确~！","提示");
		return;
	}
	
	var cd = getParam("cd");
	var fx = getParam("fx");
	if(!cd || cd == ''){
		mui.alert("活动页面有误 code:12CD","提示");
		return;
	}
	if(!aid || aid == '' || aid <= 0){
		mui.alert("活动页面有误 code:12CD","提示");
		return ;
	}
	$("#payBtn").html("发起支付...");
	$("#payBtn").attr("disabled",true);
	var url = ROOT_SERVER+"infoTo/queryPaySign";
	var dataParam = {
		 "openId":cd,
		 "fx":fx,
		 "activitId":aid,
		 "username":username,
		 "userPhone":userPhone
	}
	mui.ajax(url,{
		data:dataParam,
		dataType:'json',//服务器返回json格式数据
		type:'post',//HTTP请求类型
		timeout:10000,//超时时间设置为10秒；
		success:function(req){
			if(req.success){
				if(req.aaData == null){
					mui.alert(req.msg,"提示");
				}else{
					if(req.state == 0){
						onBridgeReady(req.aaData);
					}else{
						mui.alert(req.msg,"提示");
					}
				}
			}else{
				mui.alert("活动以结束!!","提示");
			}
			$("#payBtn").html("立即支付");
			$("#payBtn").attr("disabled",false);
		},
		error:function(xhr,type,errorThrown){
			mui.alert("服务器异常!!","提示");
			$("#payBtn").html("立即支付");
			$("#payBtn").attr("disabled",false);
		}
	});
}

function onBridgeReady(param){
   WeixinJSBridge.invoke(
      'getBrandWCPayRequest', {
			"appId":param["appId"],
			"timeStamp": param["timeStamp"],
			"nonceStr":param["nonceStr"],
			"package":param["packageA"],
			"signType":param["signType"],
			"paySign": param["paySign"]
		},
      function(res){
      if(res.err_msg == "get_brand_wcpay_request:ok" ){
				mui.alert("支付成功!工作人员近期将与您联系!","支付提示")
				window.location.reload();
      } 
   }); 
}

function musicAction(){
	var audio = $("#mp3Audio")[0];
	if(musicPlay){
		audio.pause();  
	}else{
		audio.play();
	}
	musicPlay = !musicPlay;
}

function getParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
}
//打电话模态框
function showCallModel(){
	if(!kehuPhone || kehuPhone == ''){
		alert("活动未加载完毕！");
		return;
	}
	var btnArray = ['取消','拨打'];
	mui.confirm('客服电话: ' + kehuPhone, '客服：' + kehuName, btnArray, function(e) {
		if (e.index == 1) {
			window.location.href = "tel:" + kehuPhone
		}
	},'h5')
}
//加载活动 发送请求
function loadActivit(){
	var url = ROOT_SERVER+"infoTo/getVxInfo?id="+aid;
	mui.ajax(url,{
		dataType:'json',//服务器返回json格式数据
		type:'get',//HTTP请求类型
		timeout:5000,//超时时间设置为10秒；
		headers:{'Content-Type':'application/json'},	              
		success:function(req){
			if(req.success){
				if(req.aaData == null){
					alert("该活动已关闭！")
					return;
				}else{
					setMessageInfo(req.aaData);
				}
			}else{
				alert("无信息！")
			}
		},
		error:function(xhr,type,errorThrown){
			alert("无信息!!")
		}
	});
}
//设置页面数据
function setMessageInfo(obj){
	document.title=obj.activitiName;
	
	$("#vxText").html(obj.vxText);
	$("#mp3Audio").attr("src", FILE_ROOT + obj.mp3Path);
	$("#topImg").attr("src", FILE_ROOT + obj.topImg);
	$("#buyPeopleNumA").html( obj.buyPeopleNum );
	kehuPhone = obj.kgPhone;
	kehuName= obj.khName;
	if(obj.merchant != null){
		phoneTo = obj.merchant.phone
		$("#cellk_span").html( obj.merchant.phone );
		$("#cellkName_span").html( obj.merchant.name );
	}
	$("#showPeopleNum").html( obj.showPeopleNum );
	$("#peopleBan").html( obj.peopleBan );
	$("#priceSpan").html( obj.price );
	priceLike = obj.price * 1.00 / 100;
	var num = priceLike.toFixed(2);
	$("#buy_info_b").html(num + "元");
	var goalVal = obj.peopleBan + '';
	var raiVal = obj.buyPeopleNum + '';
	var jd = parseInt(raiVal / goalVal * 100);
	$("#dJinDu").html( jd );
	mui("#jinduT").progressbar().setProgress(jd);
	MyDownCount(obj.endTime);
	var htmlList = '';
	if(obj.promtersList && obj.promtersList.length > 0){
		obj.promtersList.forEach(temp=>{
			htmlList = htmlList + '<tr>';
			htmlList = htmlList + '<td>1.</td>';
			htmlList = htmlList + '<td><img src="'+temp.headimgurl+'"  class="round_icon"></td>';
			htmlList = htmlList + '<td>&nbsp;'+temp.Nickname+'</td>';
			htmlList = htmlList + '<td>--</td>';
			htmlList = htmlList + '<td class="po_a">推广:'+temp.extNum+'<i class="mui-icon mui-icon-personadd"></i>';
			htmlList = htmlList + '</tr>';
		})
	}
	$("#pListTbody").html(htmlList);
	var detailHTML = '';
	obj.detailImg.forEach(temp=>{
		detailHTML = detailHTML + '<img src="'+FILE_ROOT+temp+'" class="ms-bgimg">'
	})
	$("#detailImg").html(detailHTML);
}
function MyDownCount(endTime) {
	var obj;
	$('.countDown ul:first-child').show().siblings('ul').hide()
	//根据结束时间获取到结束的  年，月，日，时，分，秒
	var end_year=endTime.substr(0,4);//年

	var index1=endTime.indexOf("-"); 
	var index2=endTime.lastIndexOf("-"); 
	var cha=parseInt(index2)-(parseInt(index1)+1); 
	var end_month=endTime.substr((parseInt(index1)+1),cha);

	var kg=endTime.indexOf(" "); 
	cha=parseInt(kg)-parseInt(index2); 
	var end_day=endTime.substr(parseInt(index2)+1,cha);

	var mh=endTime.indexOf(":"); 
	cha=parseInt(mh)-(parseInt(kg)+1); 
	var end_hour=endTime.substr(parseInt(kg)+1,cha);

	var mh2=endTime.lastIndexOf(":"); 
	cha=parseInt(mh2)-(parseInt(mh)+1); 
	var end_minute=endTime.substr(parseInt(mh)+1,cha);

	var mh2=endTime.lastIndexOf(":"); 
	var end_second=endTime.substr(parseInt(mh2)+1);


	//获取当前年月日时分秒
	var myTime = new Date();
	var now_year = myTime.getFullYear();
	var now_month = myTime.getMonth() + 1;
	var now_day = myTime.getDate();
	var now_hour = myTime.getHours();
	var now_minute = myTime.getMinutes();
	var now_second = myTime.getSeconds();
	//console.log(now_hour)
	var now = Date.UTC(now_year, now_month, now_day ,now_hour ,now_minute ,now_second);
	var year = end_year,month = end_month,day=end_day,hour=end_hour,minute=end_minute,second=end_second;


	var end = Date.UTC(year, month, day ,hour ,minute ,second);
	var left = end - now;//时间差

	if (left<=0) {
		$('span.days').html('0');
		$('span.hours').html('00');
		$('span.minutes').html('00');
		$('span.seconds').html('00');
	} else{
		var leftDay,leftHour,leftMin,leftSec;
		leftSec = left/1000%60;
		leftMin = (Math.floor(left/1000/60))%60;
		leftHour_ = (left - leftSec*1000 - leftMin*60*1000)/1000/60/60;
		leftHour = leftHour_%24;
		leftDay = Math.floor(parseFloat(leftHour_)/24);

		$('span.days').html(leftDay);
		$('span.hours').html(leftHour);
		$('span.minutes').html(leftMin);
		$('span.seconds').html(leftSec);
		obj = setInterval(function(){
			var se = parseFloat($('span.seconds').html());
			var min = parseFloat($('span.minutes').html());
			var ho = parseFloat($('span.hours').html());
			var da = parseFloat($('span.days').html());
			if (ho==0) {
				ho='00';
			}
			var se_,min_,ho_;
			se--;
			hour();
			minute();
			day();
			if (se<10&&se>=0) {
				se = '0'+parseFloat(se);
			}
			if (se<0) {
					se=59;
					if (min==0&&ho==0) {
						$('.countDown ul:first-child').show().siblings('ul').hide()
					} else{
					min--;
					if (min<10&&min>=0) {
						min = '0'+min;
					}
					if (min<0) {
						min=59;
						ho--;
					}
				}
			}
			function minute(){
				if (min<10&&min>=0) {
				min = '0'+min;
				}
			}

			function hour(){
				if (ho<10&&ho>=0) {
				ho = '0'+parseFloat(ho);
				}
			}

			function day(){
				if (se<0&&min==0&&ho==0) {
					da--;
					ho=23;
					min=59;
					se=59;
				}
			}
			$('span.seconds').html(se);
			$('span.minutes').html(min);
			$('span.hours').html(ho);
			$('span.days').html(da);
		},1000);

		var obj2 = setInterval(function(){
			var se_ = parseFloat($('span.seconds').html());
			var min_ = parseFloat($('span.minutes').html());
			var ho_ = parseFloat($('span.hours').html());
			var da_ = parseFloat($('span.days').html());
			if (se_==0&&min_==0&&ho_==0&&da_==0) {
				clearInterval(obj);
			}
		})
	}
}