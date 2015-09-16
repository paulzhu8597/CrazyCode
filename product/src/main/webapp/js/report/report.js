$(function (){
	var myDate = new Date();
	var month  = 0;
	if(parseInt(myDate.getMonth())<9){
		month = "0"+(parseInt(myDate.getMonth())+1);
	}else{
		month = parseInt(myDate.getMonth())+1;
	}
	var defaultdate = myDate.getFullYear()+"-"+month+"-"+myDate.getDate();
	$('#printtime').val(defaultdate);
	if(ismonth=="1"){
		$('#printtime').val(myDate.getFullYear()+"-"+month);
		$('#printtime').Zebra_DatePicker({
		    format: 'Y-m'   //  note that because there's no day in the format
		                    //  users will not be able to select a day!
		});
	}else
	{
		$('#printtime').Zebra_DatePicker();
    }
	
	$("#query").click("click", function() {
		refreshDalidyReceivedBody();
		refreshDalidyIrradationBody();
		refreshDalidyOutCargoesbody();
		refreshDalidyChargeBody();
	});
	$("#Print").click("click", function() {
		goprint();
	});
	refreshDalidyReceivedBody();
	refreshDalidyIrradationBody();
	refreshDalidyOutCargoesbody();
	refreshDalidyChargeBody();
});

function goprint(){
	 window.open("/product/report/goprintpage.do?time="+$("#printtime").val()+"&ismoth="+ismonth,'_blank');
}

//刷新已收货物
function refreshDalidyReceivedBody(){
	var data = CommnUtil.normalAjax("/report/refreshDalidyReceivedBody.do","date="+$("#printtime").val()+"&ismoth="+ismonth,"json");
	if(CommnUtil.notNull(data)){
		var html = "";
		for(var i=0;i<data.length;i++){
			html = html+
			"<tr>"
			+"<td style='text-align: center'>"+data[i].receivetime+"</td>"
			+"<td style='text-align: center'>"+data[i].takecaroorg+"</td>"
			+"<td style='text-align: center'>"+data[i].bringcargopeople+"</td>"
			+"<td style='text-align: center'>"+data[i].cargoname+"</td>"
			+"<td style='text-align: center'>"+data[i].count+"</td>"
			+"<td style='text-align: center'>"+data[i].countorg+"</td>"
			+"<td style='text-align: center'>"+data[i].weight+"</td>"
			+"</tr>";
		}
		$("#dalidyReceivedBody").html(html);
	}
}

//刷新易福朝
function refreshDalidyIrradationBody(){
	var data = CommnUtil.normalAjax("/report/refreshDalidyIrradationBody.do","date="+$("#printtime").val()+"&ismoth="+ismonth,"json");
	if(CommnUtil.notNull(data)){
		var html = "";
		for(var i=0;i<data.length;i++){
			html = html+
			"<tr>"
			+"<td style='text-align: center'>"+data[i].cargoname+"</td>"
			+"<td style='text-align: center'>"+data[i].takecargoorg+"</td>"
			+"<td style='text-align: center'>"+data[i].count+"</td>"
			+"<td style='text-align: center'>"+data[i].countorg+"</td>"
			+"<td style='text-align: center'>"+data[i].weight+"</td>"
			+"<td style='text-align: center'>"+data[i].position+"</td>"
			+"<td style='text-align: center'>"+data[i].irradationtype+"</td>"
			+"</tr>";
		}
		$("#dalidyIrradationBody").html(html);
	}
}

//刷新当日出货
function refreshDalidyOutCargoesbody(){
	var data = CommnUtil.normalAjax("/report/refreshDalidyOutCargoesbody.do","date="+$("#printtime").val()+"&ismoth="+ismonth,"json");
	if(CommnUtil.notNull(data)){
		var html = "";
		for(var i=0;i<data.length;i++){
			html = html+
			"<tr>"
			+"<td style='text-align: center'>"+data[i].takecargotime+"</td>"
			+"<td style='text-align: center'>"+data[i].takecargoorg+"</td>"
			+"<td style='text-align: center'>"+data[i].takecargoproxyorg+"</td>"
			+"<td style='text-align: center'>"+data[i].takecargopeople+"</td>"
			+"<td style='text-align: center'>"+data[i].caroname+"</td>"
			+"<td style='text-align: center'>"+data[i].count+"</td>"
			+"</tr>";
		}
		$("#dalidyOutCargoesbody").html(html);
	}
}

//刷新当日收款
function refreshDalidyChargeBody(){
	var data = CommnUtil.normalAjax("/report/refreshDalidyChargeBody.do","date="+$("#printtime").val()+"&ismoth="+ismonth,"json");
	if(CommnUtil.notNull(data)){
		var html = "";
		for(var i=0;i<data.length;i++){
			html = html+
			"<tr>"
			+"<td style='text-align: center'>"+data[i].chargetime+"</td>"
			+"<td style='text-align: center'>"+data[i].chargeorg+"</td>"
			+"<td style='text-align: center'>"+data[i].chargeamount+"</td>"
			+"<td style='text-align: center'>"+data[i].operater+"</td>"
			+"</tr>";
		}
		$("#dalidyChargeBody").html(html);
	}
}

