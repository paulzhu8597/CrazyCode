<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf" %>
<script type="text/javascript" src="${ctx}/js/system/role/add.js">
</script>
<style type="text/css">
.col-sm-3 {
	width: 15%;
	float: left;
}

.col-sm-9 {
	width: 85%;
	float: left;
}
label[class^="btn btn-default"]{
	margin-top: -4px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/cargoinfo/addcargoinfo.do">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-3 control-label">货物名称</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入货物名称" name="cargoname" id="cargoname">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">单位</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入单位" name="org" id="org">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">irradtype</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入辐射方式"
						name="irradtype" id="irradtype">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">irradtype</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入辐射时间"
						name="irradtime" id="irradtime">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">irradtype</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入时间单位"
						name="timeorg" id="timeorg">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
		</div>
		<footer class="panel-footer text-right bg-light lter">
			<button type="submit" class="btn btn-success btn-s-xs">提交</button>
		</footer> 
		</section>
	</form>
</body>
</html>