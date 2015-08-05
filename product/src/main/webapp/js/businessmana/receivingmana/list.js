$(function() {
	$('#receivetime').Zebra_DatePicker();
	//CommnUtil.disableOrEnabledInputValue("detailTable,cargoname,cargocount,reqreagent,cargoweight,funguscount,irradtime,save",true);
	$("#save").click("click", function() {
		dosave();
	});
	$("#asCurrentRecord").click("click", function() {
		if($("#asCurrentRecord").attr("checked")==true){
			$("#asCurrentRecord").val("1");
		}
	});
});

function dosave(){
	if(CommnUtil.haveOneTagIsNull("receivetime,showorgs,showBringTakeInfos,telnum,cargoname,irradtypes")){
		return;
	}
	var param = "receivetime,showorgs,showBringTakeInfos,telnum,cargoname,cargocount,showcountorginfos,reqreagent,irradtime,timeorgs,irradflags,asCurrentRecord";
	var data = CommnUtil.normalAjax("/business/saveReceiveCargo.do",CommnUtil.UrlOfInputValue(param),"json");
	alert(data.result);
	CommnUtil.cleanInputValue("detailTable,cargocount,reqreagent,cargoweight,funguscount,irradtime");
}