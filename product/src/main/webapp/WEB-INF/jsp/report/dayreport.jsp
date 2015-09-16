<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.crazycode.org/commontaglib" prefix="crazy"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="styles.css">
    <title>日报表</title>
<style type="text/css">
#prat1{
width: 50%;
height: 300px;
/* background: blue; */
float: left;
overflow:auto;
border: 1px;
border-color: red;
}
#prat2{
width: 50%;
height: 300px;
/* background: red; */
float: left;
overflow:auto;
border: 1px;
border-color: red;
}
#prat3{
width: 50%;
height: 300px;
/* background: yellow; */
float: left;
clear: left;
overflow:auto;
border: 1px;
border-color: red;
}
#prat4{
width: 50%;
height: 300px;
/* background: green; */
float: left;
overflow:auto;
border: 1px;
border-color: red;
}
</style>
    
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.18.custom.min.js"></script>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/jquery-ui-1.8.18.custom.css">
 <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/notebook/notebook_files/bootstrap.css"> 

 <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/default.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/reset.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/style.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ZebraDatepicker/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ZebraDatepicker/zebra_datepicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/report/report.js"></script>
<script type="text/javascript">
 var ismonth = "${ismoth}";
</script>
  </head>
  <body>
  <div class="m-b-md" >
  统计日期： <input type="text" id="printtime"  /> <input type="button" value="query" id="query"  /> <input type="button" value="Print" id="Print" />
  </div>
  <div class="m-b-md" id="printdiv"> 
	<div id="prat1">
		<table id="dalidyReceived" class="pp-list table  table-bordered" title="当日收获">
		<caption align="top">当日收货</caption> 
		<thead>
			<tr>
			<td>收货时间</td>
			<td>送货单位</td>
			<td>送货人</td>
			<td>货物名称</td>
			<td>数量</td>
			<td>数量单位</td>
			<td>重量(吨)</td>
			</tr>
		</thead>
		<tbody id="dalidyReceivedBody">
		
		</tbody>
		</table>
	</div>
	<div id="prat2">
		<table id="dalidyIrradation" class="pp-list table  table-bordered" title="当日辐照">
		<caption align="top">当日辐照</caption> 
		<thead>
		<tr>
		<td>货物名称</td>
		<td>送货单位</td>
		<td>数量</td>
		<td>单位</td>
		<td>重量(吨)</td>
		<td>吊具位置</td>
		<td>辐照方式</td>
		</tr>
		</thead>
		<tbody id="dalidyIrradationBody" > 
		
		</tbody>
		</table>
	</div>
	<div id="prat3">
		<table id="dalidyOutCargoes" class="pp-list table  table-bordered" title="当日出货" >
		<caption align="top">当日出货</caption>  
		<thead>
		<tr>
		<td>发货时间</td>
		<td>取货单位</td>
		<td>委托单位</td>
		<td>取货人</td>
		<td>货物名称</td>
		<td>数量</td>
		</tr>
		</thead>
		<tbody id="dalidyOutCargoesbody">
		
		</tbody>
		</table>
	</div>
	<div id="prat4">
		<table id="dalidyCharge"  class="pp-list table  table-bordered" title="当日 收款">
		<caption align="top">当日收款</caption> 
		<thead>
		<tr>
		<td>收货时间</td>
		<td>交款单位</td>
		<td>交款金额</td>
		<td>操作员</td>
		</tr>
		</thead>
		<tbody id="dalidyChargeBody">
		
		</tbody>
		</table>
	</div>
  </div>
  </body>
</html>
