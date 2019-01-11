	/*初始化EchartsCommon对象*/
	function EchartsCommon(chartId){
		this.chartId = chartId;//初始化chartId信息
	}
	
	/*初始化chart的基本信息*/
	EchartsCommon.prototype.initChart = function () {
		this.createChart();
		this.showLoading();
	};
	
	/*创建chart对象(不在创建本对象时初始化,因为那时dom可能还没有初始化完毕)*/
	EchartsCommon.prototype.createChart = function (){
		this.myChart = echarts.init(document.getElementById(this.chartId));
	};
	
	/*加载chart数据*/
	EchartsCommon.prototype.loadChart = function (handleOption) {
		this.hideLoading();
		
		var option = $.extend(false, {}, this.initCommonOption(), handleOption);
		this.myChart.setOption(option);
	};
	
	/*初始化一些公共的option*/
	EchartsCommon.prototype.initCommonOption = function (){
		var option = {
			tooltip : {// 提示内容
				trigger : 'axis'//坐标轴,饼图散点图用'item'
			},
//			toolbox : {
//		        feature: {
//		            dataView: {},
//		            magicType: {type: ['line', 'bar']},
//		            restore: {},
//		            saveAsImage: {}
//		        }
//			},
			grid:{
				containLabel : true
			},
			xAxis : {
				splitLine : {
					show : false
				},
				boundaryGap : false,//
				axisLabel : {
					show : true,
					rotate : 90,
					interval : 0
				}
			},
			yAxis : {
				type : 'value' //数值轴，适用于连续数据(默认)
			},
			series : [{
				type : 'line',//默认折线图
				smooth : true,
				itemStyle : {
					normal : {
						color : 'blue'
					}
				}
			}]
		};
		return option;
	};
	
	/*清空chart对象:清空后调用 getOption 方法返回一个{}空对象*/
	EchartsCommon.prototype.clear = function (){
		this.myChart.clear();
	};
	
	/*销毁chart对象*/
	EchartsCommon.prototype.dispose = function (){
		this.myChart.dispose();
	};
	
	/*动态加载*/
	EchartsCommon.prototype.showLoading = function (){
		this.myChart.showLoading();
	};
	
	/*隐藏动态加载*/
	EchartsCommon.prototype.hideLoading = function (){
		this.myChart.hideLoading();//隐藏动态加载
	};
	
	/*刷新宽度*/
	EchartsCommon.prototype.resize = function (){
		this.myChart.resize();
	};
	
	/*清空chart对象:清空后调用 getOption 方法返回一个{}空对象*/
	EchartsCommon.prototype.clear = function (){
		this.myChart.clear();
	};
	
	/*销毁chart对象*/
	EchartsCommon.prototype.dispose = function (){
		this.myChart.dispose();
	};
