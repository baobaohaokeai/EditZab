<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="/roof-web/report/common/base.jsp"%>

<script src="${basePath}/roof-web/report/report02/report.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/report/report02/initJqGrid.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/report/common/exportToExcel.js" type="text/javascript" language="javascript"/></script>
	
<title>清单</title>
</head>
<body style="padding:5px;">
	<!-- header -->
	<div style="text-align: center;"><h2>清单</h2></div>
	
	<!-- conditions -->
	<div style="padding:10px">
		<table border="0" cellpadding="0" cellspacing="1" class="ui-table" width="100%">
			<tbody>
				<tr>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请输入统计区间</td>
					<td width="15%"></td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">开始时间</td>
					<td width="15%"><input type="text" name="user.username" style="width:80%;" value=""></td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">结束时间</td>
					<td width="15%" colspan="3"><input type="text" name="user.username" style="width:80%;" value=""></td>
				</tr>
				
				<tr>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择地市公司</td>
					<td width="15%">
						<select id="areaCompany" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择区县公司</td>
					<td width="15%">
						<select id="countyCompany"  style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择支局</td>
					<td width="15%" colspan="3">
						<select id="subOffice" name="key_" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
				</tr>
				<tr>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择客户统计属性</td>
					<td width="15%">
						<select id="customerProp"  style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请输入客户等级</td>
					<td width="15%">
						<select id="customerLevel" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择营销服务属性</td>
					<td width="15%" colspan="3">
						<select id="marketServiceType" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
				</tr>
				<tr>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择停机类型</td>
					<td width="15%">
						<select id="haltType"  style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
					<td class="ui-table-header2" style="text-align: center;" width="10%">请选择业务类型</td>
					<td width="15%" colspan ="3">
						<select id="bussinessType" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
							
						</select>
					</td>
				</tr>
				
			</tbody>
		</table>
	</div>
	
	<div style="display:none;">
		<input type ="button" id="query" value="查询" style="margin-right:20px;" onclick="query();"/>
		<input type="button" value="导出" onclick="toExcel();" />
	</div>
	
	<div id="content" >
		<div id= "grid_div" style="padding:10px;">
			<div id="con_grid_div_1" style="">
				<table id="con_grid_div_grid_1"></table>
				<div id="con_grid_div_gridPager_1"></div>
			</div>
			<div style="clear:both;"></div>
			
		</div>
	</div>
</body>
</html>