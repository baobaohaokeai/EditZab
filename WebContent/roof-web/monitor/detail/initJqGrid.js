var initJqGrid = (function (){
	var colNames1 = ['监控项id','时间','ns','时间id','值'];
	
	var colModel1= [{name:'itemid',index:'itemid', width:100, align:"center",sortable:false
            },{name:'time_show',index:'time_show', width:100, align:"center",editable:true,sortable:true
            },{name:'ns',index:'ns', width:100, align:"center",editable:true,sortable:false,hidden:false
            },{name:'clock',index:'clock', width:100, align:"center",editable:true,sortable:false,hidden:true
            },{name:'value',index:'value', width:100, align:"center",editable:true,sortable:false
            }];
	
	function init(name){
		initColNames(name);
		initGrid(1);
	}
	
	function initColNames(){
		colNames1.pop();//删除'值'
		colNames1.push(name);//插入动态值
		console.log(colNames1);
	}
	
	//初始化grid的方法
	function initGrid(type){
//		$.jgrid.GridUnload("con_grid_div_grid_1");
		$("#con_grid_div_grid_1").GridUnload();//摧毁jqGrid,重新加载colNames
		
		$("#con_grid_div_grid_"+type).jqGrid({
            height : 405,
            rowNum : 15,
            viewrecords : true,//显示总记录数
            altRows : true,//行颜色交替显示
            rownumbers : true, //显示序号
            datatype: "local",
            autowidth : true,
            shrinkToFit : true,//列过多时设置为false(根据设置的宽度展现)
            autoScroll: true,
            scrollOffset : 0,//右边下拉框样式
            colNames : eval("colNames"+type),
            colModel : eval("colModel"+type),
            pager: "#con_grid_div_gridPager_"+type
        });
		
//		/*多个表头,用以下代码*/
//		$("#con_grid_div_grid_1").jqGrid("setGroupHeaders",{
//			useColSpanStyle : true, 
//			groupHeaders:[
//				{startColumnName:'itemid',numberOfColumns:3,titleText:'测试1'},
//				{startColumnName:'clock',numberOfColumns:2,titleText:'测试2'}
//			 ]
//		});
		
		/*增删改查询按钮设置*/
//        $("#con_grid_div_grid_"+type).navGrid(
//        		"#con_grid_div_gridPager_"+type, {
//    				search : true, // 显示查询按钮
//    				add : false,
//    				edit : false,
//    				del : false,
//    				refresh : true
//    			}, {}, // edit options
//    			{}, // add options
//    			{}, // delete options
//    			{
//    				multipleSearch : true,
//    				closeAfterSearch : true,
//    				closeOnEscape : true,
//    				searchOnEnter : true,
//    				Find : "查找"
//    			});
//    		 $('#search_con_grid_div_grid_'+type).show();
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
