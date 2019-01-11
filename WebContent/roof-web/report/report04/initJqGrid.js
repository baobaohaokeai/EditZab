var initJqGrid = (function (){
	//jqGrid自带序号列(配置 rownumbers : true, //显示序号)
	var colNames = ['订单编号','业务类型','电话号码','互联网账号','客户名称'
//	                ,'客户统计属性','客户等级','营销服务属性','贵宾卡号','星级卡号',
//	                '合同号','宽带电路编号','客户经理工号','客户经理姓名','联系人姓名',
//	                '联系人电话','区县公司','支局','地址局向','停机类型',
//	                '装机地址','停机竣工时间'
	               ];
	
	var colModel = [{name:'orderNo',index:'orderNo', width:100, align:"center",sortable:false
            },{name:'businessType',index:'businessType', width:100, align:"center",editable:true,sortable:true
            },{name:'tel',index:'tel', width:100, align:"center",editable:true,sortable:false,
            },{name:'internetId',index:'internetId', width:100, align:"center",editable:true,sortable:false,
            },{name:'consumerName',index:'consumerName', width:100, align:"center",editable:true,sortable:false
            }
//            ,{name:'orderNo',index:'orderNo', width:100, align:"center",sortable:false
//            },{name:'businessType',index:'businessType', width:100, align:"center",editable:true,sortable:true
//            },{name:'ns',index:'ns', width:100, align:"center",editable:true,sortable:false,
//            },{name:'clock',index:'clock', width:100, align:"center",editable:true,sortable:false,
//            },{name:'value',index:'value', width:100, align:"center",editable:true,sortable:false
//            },
//            {name:'orderNo',index:'orderNo', width:100, align:"center",sortable:false
//            },{name:'businessType',index:'businessType', width:100, align:"center",editable:true,sortable:true
//            },{name:'ns',index:'ns', width:100, align:"center",editable:true,sortable:false,
//            },{name:'clock',index:'clock', width:100, align:"center",editable:true,sortable:false,
//            },{name:'value',index:'value', width:100, align:"center",editable:true,sortable:false
//            },
//            {name:'orderNo',index:'orderNo', width:100, align:"center",sortable:false
//            },{name:'businessType',index:'businessType', width:100, align:"center",editable:true,sortable:true
//            },{name:'ns',index:'ns', width:100, align:"center",editable:true,sortable:false,
//            },{name:'clock',index:'clock', width:100, align:"center",editable:true,sortable:false,
//            },{name:'value',index:'value', width:100, align:"center",editable:true,sortable:false
//            },
//            {name:'orderNo',index:'orderNo', width:100, align:"center",sortable:false
//            },{name:'businessType',index:'businessType', width:100, align:"center",editable:true,sortable:true
//            }
            ];
	
	function init(){
		initGrid();
	}
	
	//初始化grid的方法
	function initGrid(){
//		$.jgrid.GridUnload("con_grid_div_grid_1");
//		$("#con_grid_div_grid_1").GridUnload();//摧毁jqGrid
		
		$("#con_grid_div_grid_1").jqGrid({
            height : 405,
            rowNum : 15,
//            height : 270,
//            rowNum : 10,
            viewrecords : true,//显示总记录数
            altRows : true,//行颜色交替显示
            rownumbers : true, //显示序号
            datatype: "local",
            autowidth : true,
            shrinkToFit : true,//列过多时设置为false(根据设置的宽度展现)
            autoScroll: true,
            scrollOffset : 0,//右边下拉框样式
            colNames : colNames,
            colModel : colModel,
            pager: "#con_grid_div_gridPager_1"
        });
		
//		/*多个表头,用以下代码*/
//		$("#con_grid_div_grid_1").jqGrid("setGroupHeaders",{
//			useColSpanStyle : true, 
//			groupHeaders:[
//				{startColumnName:'itemid',numberOfColumns:3,titleText:'测试1'},
//				{startColumnName:'clock',numberOfColumns:2,titleText:'测试2'}
//			 ]
//		});
		
		/* 加载固定数据 举例 */
		var data = [
		            {orderNo:'01',businessType:'业务类型01',tel:'138',internetId:001,consumerName:'张三'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            {orderNo:'02',businessType:'业务类型01',tel:'139',internetId:002,consumerName:'张4'},
		            ];
		$("#con_grid_div_grid_1").clearGridData();
		$("#con_grid_div_grid_1").jqGrid('setGridParam', {
			datatype : 'local',
			data : data,
		}).trigger("reloadGrid");
		
	}
	
	function resize(id){
//		var scrollOffset = $('#'+id).jqGrid("getGridParam").scrollOffset;

		var parentWidth = $('#gbox_'+id).parent().width();
		$('#'+id).setGridWidth(parentWidth - 2);
	}
	
	return {
		init : init,
		resize: resize
	};
})();
