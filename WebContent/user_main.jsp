<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8"></meta>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"></meta>
<script type="text/javascript"
	src="${basePath}/common/js/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${basePath}/bootstrap/css/bootstrap.min.css"></link>
<script type="text/javascript">
	$(function() {
		var h = $(window).height() - 65;
		$("#main_frame").attr("height", h);
	});
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li><a target="main_frame"
					href="${basePath}/fruit/areaAction/list.action">地区</a></li>
				<li><a target="main_frame"
					href="${basePath}/fruit/price_planAction/list.action">价格计划</a></li>
				<li><a target="main_frame"
					href="${basePath}/fruit/shopAction/list.action">区域店</a></li>
				<li><a target="main_frame"
					href="${basePath}/fruit/configAction/list.action">配置信息</a></li>
				<li><a target="main_frame"
					href="${basePath}/fruit/fruits_partnerAction/list.action">水果供应商</a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">用户<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/user_commission_configAction/list.action">用户佣金配置</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/user_order_statAction/list.action">用户订单统计</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/user_storeAction/list.action">用户提货点</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/userAction/list.action">用户</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">商品<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/item_typeAction/list.action">类目</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/itemAction/list.action">商品</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">佣金 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/commission_balanceAction/list.action">佣金结算记录</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/commission_instanceAction/list.action">佣金记录</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">订单<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/order_couponAction/list.action">订单优惠券信息</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/order_extAction/list.action">订单扩展</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/order_itemAction/list.action">订单详情</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/order_statDayAction/list.action">日订单统计</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/orderAction/list.action">订单</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/orderAction/groupOrderByItemType.action">采购单信息</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/orderAction/groupOrderByStore.action">发货单信息</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">优惠券 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/coupon_defAction/list.action">优惠卷定义</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/coupon_eventAction/list.action">优惠券发行事件</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/coupon_instanceAction/list.action">优惠卷实例</a></li>
					</ul></li>



				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">套餐<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/package_itemAction/list.action">套餐商品</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/package_priceAction/list.action">套餐价格</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/packageAction/list.action">套餐</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">提货合作<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a target="main_frame"
							href="${basePath}/fruit/store_partnerAction/list.action">提货合作公司</a></li>
						<li><a target="main_frame"
							href="${basePath}/fruit/storeAction/list.action">提货点</a></li>
					</ul></li>

				<li><a target="_top"
					href="${basePath}/systemAction/j_spring_security_logout">登出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<iframe src="" width="100%" id="main_frame" name="main_frame"
		frameborder="0" scrolling="yes"
		style="padding-left: 0; padding-right: 0"></iframe>
</body>
</html>