<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.crazycode.org/commontaglib" prefix="crazy"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="styles.css">
    <title>日报表</title>

<style type="text/css" media=print> 
.noprint{display : none } 
</style> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/print/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/print/jquery.printPage.js"></script>

	<script type="text/javascript">
	$(function (){
		printpreview();
	});
	
	function doprint(){
		document.body.innerHTML=document.getElementById("printdiv").innerHTML;
		window.print();
	}

	function printsetup(){
		// 打印页面设置
		wb.execwb(8,1);
	}
	
	function printpreview(){
		// 打印页面预览
		wb.execwb(7,1);
	}
	
	function printit()
	{
		if (confirm('确定打印吗？')) {
		   wb.execwb(6,6)
	    }
	}	
	
	</script>
  </head>
  <body>
    <OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height=0 id=wb name=wb width=0></OBJECT>
	<input class="noprint" type="button" name="button_print" value="打印" onclick="javascript:printit()">
	<input class="noprint" type="button"　name="button_setup" value="打印页面设置" onclick="javascript:printsetup();">
	<input class="noprint" type="button"　name="button_show" value="打印预览" onclick="javascript:printpreview();">
	<input class="noprint" type="button" name="button_fh" value="关闭" onclick="javascript:window.close();">
  <div id="printdiv"> 
  <table width="100%">
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
