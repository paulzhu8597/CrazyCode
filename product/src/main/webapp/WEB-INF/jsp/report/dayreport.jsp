<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.crazycode.org/commontaglib" prefix="crazy"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="styles.css">
    <title>日报表</title>
    
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
	<script type="text/javascript">
	$(function (){
		$('#printtime').Zebra_DatePicker();
		$("#query").click("click", function() {
		goprint();
		});
	});
	
	function goprint(){
		 window.open("/product/report/goprintpage.do",'_blank');
	}
	
	</script>
  </head>
  <body>
  <div class="m-b-md">
  统计日期： <input type="text" id="printtime"  /> <input type="button" value="query" id="query"  />
  </div>
  <div class="m-b-md" id="printdiv"> 
  <table width="100%" class="pp-list table table-striped table-bordered">
  <thead>
  <tr>
  <td> 收获时间</td>
  <td> 送货单位</td>
  <td> 送货人</td>
  <td> 货物名称</td>
  <td> 数量</td>
  <td> 重量(吨)</td>
  <td> 辐照方式</td>
  <td> 辐照时间</td>
  <td> 剂量要求</td>
  <td> 照前菌数</td>
  <td> 费用(元)</td>
  <td> 备注</td>
  <td> 操作员</td>
  </tr>
  </thead>
  <tbody>
  <tr>
  <td>2015-06-01</td>
  <td>阿里巴巴</td>
  <td>沈询</td>
  <td>蒜苗</td>
  <td>6</td>
  <td>斤</td>
  <td>动态辐照</td>
  <td>24</td>
  <td>1230</td>
  <td>10</td>
  <td>125</td>
  <td>第一批货物</td>
  <td>管理员</td>
  </tr>
  <tr>
  <td>2015-06-01</td>
  <td>阿里巴巴</td>
  <td>沈询</td>
  <td>蒜苗</td>
  <td>6</td>
  <td>斤</td>
  <td>动态辐照</td>
  <td>24</td>
  <td>1230</td>
  <td>10</td>
  <td>125</td>
  <td>第一批货物</td>
  <td>管理员</td>
  </tr>
  <tr>
  <td>2015-06-01</td>
  <td>阿里巴巴</td>
  <td>沈询</td>
  <td>蒜苗</td>
  <td>6</td>
  <td>斤</td>
  <td>动态辐照</td>
  <td>24</td>
  <td>1230</td>
  <td>10</td>
  <td>125</td>
  <td>第一批货物</td>
  <td>管理员</td>
  </tr>
  </tbody>
  </table>
  </div>
  
  </body>
</html>
