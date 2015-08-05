<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.crazycode.org/commontaglib" prefix="crazy"%>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.18.custom.min.js"></script>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/jquery-ui-1.8.18.custom.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/notebook/notebook_files/bootstrap.css">

 <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/default.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/reset.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/js/ZebraDatepicker/public/style.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ZebraDatepicker/core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ZebraDatepicker/zebra_datepicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/businessmana/receivingmana/list.js"></script>


</head>
<body>
	<div class="m-b-md">
			<form>
			<table class="pp-list table table-striped table-bordered">
				<tr>
				 <td >
				 <fieldset>
				 <legend>基本信息</legend>
					 <table class="pp-list table table-striped table-bordered">
						<tr><td>收获日期：</td><td><input id="receivetime" name="receivetime" type="text" class="input-medium ui-autocomplete-input" /> <td></tr>
						<tr> <td>送货单位：</td><td><crazy:dictselect id="showorgs" name="showorgs"  collection="${showorgs}" ></crazy:dictselect> </td> </tr>
						<tr> <td>送货人：</td><td><crazy:dictselect id="showBringTakeInfos" name="showBringTakeInfos"  collection="${showBringTakeInfos}"></crazy:dictselect> </td> </tr>
						<tr> <td>联系电话 ：</td><td><input id="telnum" name="telnum" type="text" class="input-medium ui-autocomplete-input"  /> </td> </tr>
					 </table>
					</fieldset>
				 </td> 
				 <td>
				 <fieldset>
				 <legend>详细信息</legend>
				 		<table class="pp-list table table-striped table-bordered" id="detailTable">
							<tr>
							<td colspan="1">货物名称：</td>
							<td colspan="5"><crazy:dictselect id="cargoname" name="cargoname"  collection="${showcargoinfos}"  ></crazy:dictselect> </td>
							</tr>
							
							<tr>
							<td>货物数量：</td><td><input id="cargocount" name="cargocount" type="text" class="input-medium ui-autocomplete-input" /> </td>
							<td>数量单位：</td><td><crazy:dictselect id="showcountorginfos" name="showcountorginfos" collection="${showcountorginfos }"/></td>
							<td>要求剂量：</td><td><input id="reqreagent" name="reqreagent" type="text" class="input-medium ui-autocomplete-input" /> </td>
							</tr>
						
						    <tr>
							<td>货物重量：</td><td><input id="cargoweight" name="cargoweight" type="text" class="input-medium ui-autocomplete-input" /> </td>
							<td>含  菌   数：</td><td><input id="funguscount" name="funguscount" type="text" class="input-medium ui-autocomplete-input" /> </td>
							<td>辐照方式：</td> <td><crazy:dictselect id="irradtypes" name="irradtypes" collection="${irradtypes }"/>  </td>
						    </tr>
						
						    <tr>
						    <td>辐照时间：</td> <td><input id="irradtime" name="irradtime" type="text" class="input-medium ui-autocomplete-input" /></td>
						    <td>时间单位：</td> <td><crazy:dictselect id="timeorgs" name="timeorgs" collection="${timeorgs }"/></td>
						    <td>辐照类型：</td> <td><crazy:dictselect id="irradflags" name="irradflags" collection="${irradflags }"/></td>
						    </tr>
					    </table>
					</fieldset>
				 </td> 
				</tr>
                <tr> <td colspan="2">  <input type="button" id="save" value="Save"> <input type="checkbox"  id="asCurrentRecord" value="0" /> </td></tr>
			</table>
			</form>
		<fieldset>
			<legend>详细信息</legend>
			<header>
				<div>
					<form action="" class="form-horizontal">
						<table class="pp-list table table-striped table-bordered"
							style="margin-bottom: -3px;">
							<thead>
								<tr style="line-height: 27px;">
									<td style="text-align: center"><input type="checkbox"
										id="checkall" /> 选择</td>
									<td style="text-align: center">货物名称</td>
									<td style="text-align: center">单位</td>
									<td style="text-align: center">辐照方式</td>
									<td style="text-align: center">辐照时间</td>
									<td style="text-align: center">时间单位</td>
								</tr>
							</thead>
							<tbody id="cargoes">
							</tbody>
						</table>
					</form>
				</div>
			</header>
		</fieldset>
	</div>
</body>
</html>