<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="/roof-web/monitor/common/base.jsp"%>

<script src="${basePath}/roof-web/monitor/detail/monitorCommon.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/monitor/detail/initJqGrid.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/monitor/detail/toExport.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/monitor/detail/echartsCommon.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/monitor/detail/echartsHandle.js" type="text/javascript" language="javascript"/></script>
<script src="${basePath}/roof-web/monitor/detail/detail.js" type="text/javascript" language="javascript"/></script>

<script type="text/javascript">
	var _hostName = '<%=request.getParameter("hostName")%>';
	var _type = '<%=request.getParameter("type")%>';
	
	$(function (){
		init();
	});
</script>
	
<title>Monitor demo</title>
</head>
<body style="padding:10px;background-color:#E3ECFC;">
	<!-- header -->
	<div style="text-align: center;display:none;"><h1>Zabbix demo</h1></div>
	<div id="header" style="display:none;"><h3>当前Zabbix版本为:<span id = "version">1.0</span></h3></div>
	
	<div><!--主机:-->
		<select id = "hostName" style="width:130px;margin-right:20px;display:none;" onchange="changeKey_();">
			<option value="Zabbix server" >Zabbix server</option>
			<option value="Zabbix agentd 001" selected>Zabbix agentd</option>
		</select>
		<!--监控类型:-->
		<select id = "type" style="width:80px;margin-right:20px;display:none;" onchange="changeType(this.value);">
			<option value="cpu" selected>CPU</option>
			<option value="memory" >内存</option>
			<option value="disk" >硬盘</option>
			<option value="if" >网卡</option> 
			<option value="process">进程</option> 
			<option value="swap" >交换分区</option> 
			<option value="agent" style="">agent</option> 
		</select>
		监控项:<!--value:对应监控项中的key_,type:根据key_查询的结果集中value_的返回类型(0:浮点 3:整数) -->
		<select id = "cpu" name="key_" style="width:170px;margin-right:20px;" onchange="changeKey_(this.value);">
			<option value="system.cpu.load[percpu,avg1]" selected type="0">1分钟平均负载值</option>
			<option value="system.cpu.load[percpu,avg5]" type="0">5分钟平均负载值</option>
			<option value="system.cpu.load[percpu,avg15]" type="0">15分钟平均负载值</option>
			<option value="system.cpu.util[,idle]" type="0">闲置占比(%)</option>
			<option value="system.cpu.util[,system]" type="0">系统占比(%)</option>
			<option value="system.cpu.util[,user]" type="0">用户占比(%)</option>
			<option value="system.cpu.util[,iowait]" type="0">iowait占比(%)</option>
			<option value="system.cpu.switches" type="3">上下文交换(sps)</option>
			<option value="system.cpu.intr" type="3">中断(ips)</option>
		</select>
		<select id="memory" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="vm.memory.size[total]" selected type="3">总容量(MB)</option>
			<option value="vm.memory.size[available]" type="3">可用容量(MB)</option>
			<option value="vm.memory.size[used]" type="3">已用容量(MB)</option>
			<option value="vm.memory.size[free]" type="3">空闲容量(MB)</option>
			<option value="vm.memory.size[buffers]" type="3">缓存区容量(MB)</option>
			<option value="vm.memory.size[cached]" type="3">缓存容量(MB)</option>
			<option value="vm.memory.size[pavailable]" type="0">可用容量占比(%)</option>
			<option value="vm.memory.size[pused]" type="0">已用容量占比(%)</option>
		</select>
		<select id="disk" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="vfs.fs.size[/,total]" type="3" selected>总容量(GB)</option>
			<option value="vfs.fs.size[/,free]" type="3"> 空闲容量(GB)</option>
			<option value="vfs.fs.size[/,used]" type="3"> 已用容量(GB)</option>
			<option value="vfs.fs.size[/,pfree]" type="0" >空闲容量占比(%)</option>
			<option value="vfs.fs.size[/,pused]" type="0" >已用容量占比(%)</option>
			<option value="vfs.dev.read[,sps,]" type="0" > 1分钟平均读取状态(sps)</option>
			<option value="vfs.dev.read[,sps,avg5]" type="0" > 5分钟平均读取状态(sps)</option>
			<option value="vfs.dev.read[,sps,avg15]" type="0" > 15分钟平均读取状态(sps)</option>
			<option value="vfs.dev.write[,sps,]" type="0" >1分钟平均写入状态(sps)</option>
			<option value="vfs.dev.write[,sps,avg5]" type="0" >5分钟平均写入状态(sps)</option>
			<option value="vfs.dev.write[,sps,avg15]" type="0" >15分钟平均写入状态(sps)</option>
		</select>
		<select id="swap" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="system.swap.size[,total]" type="3" selected>总容量(MB)</option>
			<option value="system.swap.size[,free]" type="3" >空闲容量(MB)</option>
			<option value="system.swap.size[,used]" type="3" >已用容量(MB)</option>
			<option value="system.swap.size[,pfree]" type="0" >空闲容量占比(%)</option>
			<option value="system.swap.size[,pused]" type="0" >已用容量占比(%)</option>
			<option value="system.swap.in[,count]" type="3" >磁盘到内存的数量(个)</option>
			<option value="system.swap.in[,sectors]" type="3" >磁盘到内存的扇区数(个)</option>
			<option value="system.swap.in[,pages]" type="3" >磁盘到内存的页数(页)</option>
			<option value="system.swap.out[,count]" type="3" >内存到磁盘的数量(个)</option>
			<option value="system.swap.out[,sectors]" type="3" >内存到磁盘的扇区数(个)</option>
			<option value="system.swap.out[,pages]" type="3" >内存到磁盘的页数(页)</option>
		</select>
		<select id="if" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="net.if.total[eth0]" type="3" selected>入/出口流量的速率(bps)</option>
			<option value="net.if.total[eth0,packets]" type="3" >入/出口流量的包数量(个)</option>
			<option value="net.if.total[eth0,errors]" type="3" >入/出口流量的错误数量(个)</option>
			<option value="net.if.total[eth0,dropped]" type="3" >入/出口流量的丢包数量(个)</option>
			<option value="net.if.in[eth0]" type="3" >入口流量的速率(bps)</option>
			<option value="net.if.in[eth0,packets]" type="3" >入口流量的包数量(个)</option>
			<option value="net.if.in[eth0,errors]" type="3" >入口流量的错误数量(个)</option>
			<option value="net.if.in[eth0,dropped]" type="3" >入口流量的丢包数量(个)</option>
			<option value="net.if.out[eth0]" type="3" >出口流量的速率(bps)</option>
			<option value="net.if.out[eth0,packets]" type="3" >出口流量的包数量(个)</option>
			<option value="net.if.out[eth0,errors]" type="3" >出口流量的错误数量(个)</option>
			<option value="net.if.out[eth0,dropped]" type="3" >出口流量的丢包数量(个)</option>
			<option value="net.if.in[eth1]" type="3" >eth1网卡入口流量的速率(Kbps)</option>
			<option value="net.if.out[eth1]" type="3" >eth1网卡出口流量的速率(Kbps)</option>
		</select>
		<select id="process" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="proc.num[]" type="3" selected>所有用户的进程数量(个)</option>
			<option value="proc.num[,,run]" type="3" >所有用户运行的进程数量(个)</option>
			<option value="proc.num[,zabbix]" type="3" >zabbix用户的进程数量(个)</option>
			<option value="proc.num[,zabbix,run]" type="3" >zabbix用户运行的进程数量(个)</option>
			<option value="proc.num[zabbix_server,zabbix]" type="3" >zabbix用户zabbix_server进程的数量(个)</option> 
			<option value="proc.num[,root]" type="3" >root用户的进程数量(个)</option>
			<option value="proc.num[,root,run]" type="3" >root用户运行的进程数量(个)</option>
			<option value="proc.mem[]" type="3" >所有用户的进程所占内存(GB)</option>
			<option value="proc.mem[zabbix_server,zabbix]" type="3" >zabbix用户运行的zabbix_server进程所占内存(GB)</option> 
			<option value="proc.mem[,root]" type="3" >root用户的进程所占内存(GB)</option>
		</select>
		<select id="agent" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
			<option value="agent.hostname" type="1" >主机名称</option>
			<option value="agent.ping" type="3" selected>ping</option>
			<option value="agent.version" type="1" >版本号</option>
		</select>
		<select id="hotItem" name="key_" style="width:170px;margin-right:20px;display:none;" onchange="changeKey_(this.value);">
		
		</select>
		<input type ="button" id="host" value="查询" style="margin-right:20px;" onclick="query(true);"/>
		<input type ="button" value="切换" onclick="change2();"/>
	</div>
	
	<div id ="title"  style="display:none;">
		<h3 style="font-size: 20px;font-weight: bold;">
				监控详情
		</h3>			
	</div>
	
	<div id="content" style="padding:15px 5px;">
		<div id ="chart_div" >
			 <div id="main" style="height:450px;width:100%"></div>
		</div>
		<div id ="chart_div2" style="display:none;">
			 <div id="main2" style="height:450px;width:100%"></div>
		</div>
		<div id= "grid_div" style="display:none;">
			<div id="con_grid_div_1" style="">
				<table id="con_grid_div_grid_1"></table>
				<div id="con_grid_div_gridPager_1"></div>
			</div>
			<div style="clear:both;"></div>
			<input type="button" value="导出" onclick="toExcel();" style="display:non;"></input>
		</div>
	</div>
</body>
</html>