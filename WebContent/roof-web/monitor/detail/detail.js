
	// 基于准备好的dom，初始化echarts图表
	var chart1 = new EchartsCommon('main');
	var chartDataObj = {
		indexName : {x:'time_show',y:'value'},//从后台返回结果集中获取x,y(y2,y3...)坐标数据对应的index名称
		unit : {y : ''},//y(y2..)坐标数据对应的单位.不需要处理,默认即可
		title : "",
		legend : [],
		data : [] //存储结果集
	};
	
	/*初始化入口*/
	function init(){
//		initJqGrid.init();
//		getVersion();//获取zabbix版本信息
		
		_hostName = _hostName == 'null' ? 'Zabbix agentd 001':_hostName;
		_type = _type == 'null' ? 'hotItem':_type;//
		$('#hostName').val(_hostName);			
		$('#type').val(_type);
		
//		loadType();//加载监控类型
		if(_type != 'hotItem'){
			loadItemByType(_type);//加载指定类型的监控项			
		}else{
			loadHotItem();//加载热门监控项
		}
		changeType(_type);//切换监控项并查询数据
	}
	
	/*切换类型*/
	function changeType(value){
		$('select[name="key_"]').hide();
		$('#' + value).show();
		changeKey_();
	}
	
	/*切换监控项*/
	function changeKey_(value){
		query(true);//第一次加载全部数据
	}
	
	/*查询监控项数据*/
	function query(init){
		var selectedKeyObj = $('select[name="key_"]:visible option:selected');
		var name = selectedKeyObj.text();
		
		chartDataObj.unit.y = '';
		if(name.indexOf("(") != -1){
			chartDataObj.unit.y = name.substring(name.indexOf("(")+1,name.indexOf(")"));//获取单位			
		}
		chartDataObj.legend = [];
		chartDataObj.legend.push(name);
		var name2 = replaceStr(name);
		chartDataObj.title = name2 + "趋势图";
		
		if(init){
			initJqGrid.init(name);
			chart1.initChart();
		}
		$.ajax({
			type : "POST",
			async : true,
			url : ROOF.Utils.projectName() + '/monitorHistoryAction/get.action', // 这是数据的请求地址
			data : {
				hostName:$('#hostName option:selected').val(),
				key_: selectedKeyObj.val(),
				resultType: selectedKeyObj.attr("resultType")
			},
			dataType : "json",
			success : function(data) {//后台数据是根据时间倒序排列的
				if(init){//第一次加载时
					chartDataObj.data = data;
				}else{//再次加载只取最新数据,实现滚动效果
					if(data && chartDataObj.data[0].time_show != data[0].time_show){
						chartDataObj.data.pop();//删除最后一个元素
						chartDataObj.data.unshift(data[0]);//向数组的开头添加一个或更多元素	
					}
				}
				
				//处理echarts
				loadEcharts();
				
				//处理jqgrid
				loadJqGrid();
			},
			error:function(err){
				console.log(err);
				chart1.hideLoading();
			}
		});
	}
	
	/*周期显示最新记录*/
	var interval = setInterval(query, 60*1000);
	
	/*加载jqgrid*/
	function loadJqGrid(){
		$("#con_grid_div_grid_1").clearGridData();
		$("#con_grid_div_grid_1").jqGrid('setGridParam', {
			datatype : 'local',
			data : chartDataObj.data,
		}).trigger("reloadGrid");
	}
	
	/*加载echarts*/
	function loadEcharts(){
		var handleOption = echartsHandle.handleOption(chartDataObj);
		chart1.loadChart(handleOption);
	}
	
	/*去除str中包含的(????):比如(%),(GB)等*/
	function replaceStr(str){
		str = str.replace(/\(.+\)/gmi, "");
		return str;
	}
	
	/*切换echarts和grid*/
	function change2(){
		if($('#chart_div').is(':hidden')){
			$('#grid_div').hide();
			$('#chart_div').show();
			
			//调整echarts大小
			chart1.resize();
		}else{
			$('#chart_div').hide();
			$('#grid_div').show();
			
			//调整jgGrid大小
			initJqGrid.resize("con_grid_div_grid_1");
		}
	}
	
	//@Deprecated
	/*获取zabbix版本*/
	function getVersion(){
		$.ajax({
			type : "POST",
			async : true,
			url : ROOF.Utils.projectName() + '/monitorHistoryAction/getVersion.action', // 这是数据的请求地址
			data : {},
			dataType : "json",
			success : function(data) {
				console.log(data);
				if(data && data.result){
					$('#version').text(data.result);
				}else{
					$('#version').text("1.0");
				}
			}
		});
	}
	
	/*导出*/
	function toExcel(){
		var myGrid = $("#con_grid_div_grid_1").jqGrid("getGridParam");
		var action = ROOF.Utils.projectName() + '/monitorHistoryAction/toExcel.action';
		var title = 'zabbix_history_demo_导出测试';
		
		ToExport({
			myGrid : myGrid,
			action : action,
			title : title,
			isExportComplexHeader : true,//是否导出多级表头，暂支持两级表头,
			isExportRowNumber : true //是否导出序号,需要走在jqgrid中配置显示序号
		});
	}