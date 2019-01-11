<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/roof-web/head.jsp"%>
<script type="text/javascript" src="${basePath }/common/js/zTree/js/jquery.ztree.all-3.1.min.js"></script>
<script type="text/javascript" src="${basePath }/roof-web/monitor/index/index.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}/common/js/zTree/zTreeStyle/zTreeStyle.css" />
<title></title>
</head>
<body>
	<div class="ztree" style="width: 15%; height: 100%; float: left;"></div>
	<div style="width: 83%; height: 100%; float: right;">
		<iframe src="${basePath }/monitorHistoryAction/detail.action" frameborder="0" scrolling="auto" width="100%" height="650px"></iframe>
	</div>
</body>
</html>