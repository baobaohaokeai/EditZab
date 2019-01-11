<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>报表</title>
<script type="text/javascript" src="${basePath}/common/js/jquery/jquery-1.7.2.min.js"></script>
<script src="${basePath}/js/menu.js"></script>
<script src="${basePath}/js/browser.js"></script>
<link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${basePath}/css/editor.css">

<script type="text/javascript">
</script>
</head>

<body>
    <div> 
        <div>
        	<iframe id="iframeId" frameborder="0" scrolling="auto" height="600px" width="100%" name="sinopec" style="margin:0;padding:0;" src="${reportUrl}">IFRAME2</iframe>
        </div>
    </div>
</body>
</html>