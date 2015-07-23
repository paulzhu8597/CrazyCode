<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/system/cargoinfo/list.js"></script>
<div class="m-b-md">
	<form class="form-inline" role="form" id="searchForm" name="searchForm">
		<div class="form-group">
			<label class="control-label"> <span
				class="h4 font-thin v-middle">货物名称:</span></label> <input
				class="input-medium ui-autocomplete-input" id="name"
				name="roleFormMap.roleFormMap.name">
		</div>
		<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
		<input type="button" name="addcargo" value="新增" class="" btn btn-default"/>
		<input type="button" name="editcargo" value="编辑" class="" btn btn-default"/>
		<input type="button" name="deletecargo" value="删除" class="" btn btn-default"/>
	</form>
</div>
<header>
	<div>
		<form action="" class="form-horizontal">
			<table class="pp-list table table-striped table-bordered"
				style="margin-bottom: -3px;">
				<thead>
					<tr style="line-height: 27px;">
						<td>选择</td>
						<td>货物名称</td>
						<td>单位</td>
						<td>辐照方式</td>
						<td>辐照时间</td>
						<td>时间单位</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cargoes}" var="key">
						<tr>
							<td><input type="checkbox" name="cargoes" value="${key.id}@_@${key.cargoname}" /> </td>
							<td> ${key.cargoname} </td> 
							<td> ${key.org} </td>
							<td> ${key.irradtype} </td> 
							<td> <fmt:formatDate value="${key.irradtime}" type="date"/></td>
							<td> ${key.timeorg} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</header>
<div class="table-responsive">
	<div id="paging" class="pagclass"></div>
</div>
