var echartsHandle = (function(){
	
	/*加载option数据*/
	function _handleOption (_chartObj) {
		var values = handleData(_chartObj);
		if (values.length == 0) {
			return null;
		}
		values = values[0];
		
		var option = {
			title:{
				text : _chartObj.title
			},
			legend : {
				data : _chartObj.legend
			},
		    dataZoom: [
               {   // 这个dataZoom组件，默认控制x轴。
                   type: 'inside', // 这个 dataZoom 组件是 inside 型 dataZoom 组件
                   start: 50,      // 左边在 50% 的位置。
                   end: 100        // 右边在 100% 的位置。
               }
		    ],
			xAxis : {
				data : values.xAxisData// ['1月','2月','3月','4月']
			},
			series : [{
				name : _chartObj.legend[0],
				data : values.yAxisData
			}]
		};
		return option;
	}
	
	/*对结果集进行处理*/
	function handleData (_chartObj) {
		// 处理数据--开始
		var xAxisData = [];
		var yAxisData = [];
		var indexName = _chartObj.indexName;
		var data = _chartObj.data;
		if (data) {
			for(var i = data.length - 1;i >= 0 ;i--){
				var x_data = eval('data[i].' + indexName.x);
				xAxisData.push(x_data);
				
	 			var y_data = eval('data[i].' + indexName.y);
	 			if(_chartObj.unit && _chartObj.unit.y){
	 				var value = _chartObj.unit.y;
	 				var toUpperValue = value.toUpperCase();
	 				if(toUpperValue == 'KB'){
	 					y_data = (y_data/1024).toFixed(2);	
	 				}else if(toUpperValue == 'MB'){
	 					y_data = (y_data/1024/1024).toFixed(2);	 					
	 				}else if(toUpperValue == 'GB'){
	 					y_data = (y_data/1024/1024/1024).toFixed(2);	 					
	 				}else if(value == 'Kbps'){//zabbix默认b转换为Kb,除以1000;B转换为KB,除以1024;
	 					y_data = (y_data/1000).toFixed(2);	
	 				}else if(value == 'Mbps'){//zabbix默认b转换为Kb,除以1000;B转换为KB,除以1024;
	 					y_data = (y_data/1000/1000).toFixed(2);	
	 				}
	 			}
				yAxisData.push(y_data);
				
				/*处理y2*/
//				to do something 
			}
		}
		var values = [];
		values.push({
			"xAxisData" : xAxisData,
			"yAxisData" : yAxisData
		});
		return values;
	}
	
	return {
		handleOption : _handleOption
	};
})();