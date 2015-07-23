//$('#irradtime').Zebra_DatePicker();
var editfalg = "";
$(function() {
	$("#adddialog").dialog({
		autoOpen : false,// 设置对话框打开的方式 不是自动打开
		show : "bind",
		hide : "explode",
		modal : true,
		height : 500,
		width : 450,
		buttons : {
			'保存' : function() {
				if("add"==editfalg){
					if (addcargo()) {
						$(this).dialog("close");
						search(0, "true");
					}
			     }
				else if("edit"==editfalg){
					alert("lllll");
					saveEditCargo();
				}
			},
			"取消" : function() {
				$(this).dialog("close");
			}
		},
		open : function(ev, ui) {
			if("edit"==editfalg){
				initeditcargo();
			}
			// CommnUtil.cleanInputValue("addcargoname,org,irradtype,irradtime,timeorg");
		},
		close : function(ev, ui) {
			CommnUtil.cleanInputValue("addcargoname,org,irradtype,irradtime,timeorg");
		}
	});
	$("#search").click("click", function() {// 绑定查询按扭
		search(0, "true");
	});
	$("#pre").click("click", function() {
		dopre();
	});
	$("#next").click("click", function() {
		donext();
	});
	$("#editcargo").click("click", function() {
		editfalg = "edit";
		if(CommnUtil.isHaveSelectOneCheckbox("cargoes")){
			$('#adddialog ').dialog('open');
		}
		else{
			alert("只能选择一个货物！");
		}
	});
	$("#deletecargo").click("click", function() {
		deletecargo();
	});
	$('#addcargo').click(function() {
		editfalg = "add";
		$('#adddialog').dialog('open');
	});
});

function search(pagenow, isfromsearch) {
	var data = CommnUtil.normalAjax("/system/cargoinfo/findByPage.do",
			"pageNow=" + pagenow + "&pageSize=20&isfromsearch=" + isfromsearch
					+ "&cargoname=" + $("#cargoname").val(), "json");
	if ("null" != data && 'undefined' != data) {
		var html = "";
		for (var i = 0; i < data.length; i++) {
			// alert(data[i].id+"@_@"+data[i].cargoname+"@_@"+data[i].org+"@_@"+data[i].irradtype+"@_@"+data[i].irradtime+"@_@"+data[i].timeorg);
			html = html
					+ "<tr>"
					+ "<td style='text-align: center'><input type='checkbox' name='cargoes' value='"+ data[i].id + "@_@" + data[i].cargoname + "' /> </td>"
					+ "<td style='text-align: center'>" + data[i].cargoname + " </td>" 
					+ "<td style='text-align: center'>"+ data[i].org + " </td>"
					+ "<td style='text-align: center'>" + data[i].irradtype + " </td>"
					+ "<td style='text-align: center'>" + data[i].irradtime + " </td>"
					+ "<td style='text-align: center'>" + data[i].timeorg + "</td>"  
					+ "</tr>";
		}
		$("#cargoes").html(html);
		if("true"==isfromsearch){
			setPageInfo(0);
		}
	}
}

function setPageInfo(pagenow) {
	var data = CommnUtil.normalAjax("/system/cargoinfo/getCount.do","cargoname=" + $("#cargoname").val(), "json");
	if ("null" != data && 'undefined' != data) {
		var pagerecode = data;
/*		alert(pagenow + " : " + pagerecode + " : "
				+ Math.ceil(parseInt(pagerecode) / 20));*/
		var totalpage = Math.ceil(parseInt(pagerecode) / 20);
		if (pagenow < 0 || pagenow >= totalpage) {
			return false;
		}
		$("#pagerecode").text(pagerecode);
		$("#pageNow").text(pagenow);
		$("#totalpage").text(totalpage);
	}
	return true;
}

function dopre() {
	var pageNow = $("#pageNow").text().trim();
	if (setPageInfo(parseInt(pageNow) - 1)) {
		search(parseInt(pageNow) - 1, "false");
	}
}
function donext() {
	var pageNow = $("#pageNow").text().trim();
	if (setPageInfo(parseInt(pageNow) + 1)) {
		search(parseInt(pageNow) + 1, "false");
	}
}
function initeditcargo() {
		var idAndName = CommnUtil.getCheckBoxValueOfSelect("cargoes");
		var data = CommnUtil.normalAjax("/system/cargoinfo/getOneCargo.do" , "idAndName="+idAndName , "json");
		if(CommnUtil.notNull(data)){
			$("#addcargoname").val(data.cargoname);
			$("#org").val(data.org);
			$("#irradtype").val(data.irradtype);
			$("#irradtime").val(data.irradtime);
			$("#timeorg").val(data.timeorg);
		}
}

function saveEditCargo(){
	if (!CommnUtil.notNull($("#addcargoname").val())) {
		alert("货物名称必须填写！");
		return false;
	}
	if(!validatetime($("#irradtime").val())){
		alert("时间输入格式不正确！");
		return false;
	}
	var data = CommnUtil.normalAjax("/system/cargoinfo/saveEditCargo.do",
			"addcargoname=" + $("#addcargoname").val() + 
			"&org=" + $("#org").val() + 
			"&irradtype=" + $("#irradtype").val() +
			"&irradtime=" + $("#irradtime").val() +
            "&timeorg=" + $("#timeorg").val(),
			"json");
	if (CommnUtil.notNull(data) && "ok" == data) {
		alert("编辑成功！");
		return true;
	} else {
		alert("编辑失败！\n 错误信息：\n " + data);
		return false;
	}
	return false;
}

function addcargo() {
	if (!CommnUtil.notNull($("#addcargoname").val())) {
		alert("货物名称必须填写！");
		return false;
	}
	if(!validatetime($("#irradtime").val())){
		alert("时间输入格式不正确！");
		return false;
	}

	var data = CommnUtil.normalAjax("/system/cargoinfo/doAddCargo.do",
			"addcargoname=" + $("#addcargoname").val() + 
			"&org=" + $("#org").val() + 
			"&irradtype=" + $("#irradtype").val() +
			"&irradtime=" + $("#irradtime").val() +
            "&timeorg=" + $("#timeorg").val(),
			"json");
	if (CommnUtil.notNull(data) && "ok" == data) {
		alert("添加成功！");
		return true;
	} else {
		alert("添加失败！\n 错误信息：\n " + data);
		return false;
	}
	return false;
}
function deletecargo() {
	layer.confirm('是否删除？', function(index) {
		var url = rootPath + '/role/deleteEntity.shtml';
		var s = CommnUtil.ajax(url, {
			ids : cbox.join(",")
		}, "json");
		if (s == "success") {
			layer.msg('删除成功');
			grid.loadData();
		} else {
			layer.msg('删除失败');
		}
	});
}

// ==========================================================添加========================================================
function validatetime(intime){
	alert("intime : "+intime);
	var rex = /^(\d{4})\-(\d{2})\-(\d{2})$/;
	if(CommnUtil.notNull(intime)&&rex.test(intime)){
		return true;
	}
	return false;
}
