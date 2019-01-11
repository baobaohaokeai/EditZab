
	/*初始化入口*/
	$(function(){
		initJqGrid.init();
//		query();
	});
	
	/*查询数据*/
	function query(){
		$.ajax({
			type : "POST",
			async : true,
			url : ROOF.Utils.projectName() + '/report04/get.action', // 这是数据的请求地址
			data : {
				hostName:$('#hostName option:selected').val(),
				key_: selectedKeyObj.val(),
				resultType: selectedKeyObj.attr("resultType")
			},
			dataType : "json",
			success : function(data) {
				//处理jqgrid
				loadJqGrid(data);
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	
	/*加载jqgrid*/
	function loadJqGrid(data){
		$("#con_grid_div_grid_1").clearGridData();
		$("#con_grid_div_grid_1").jqGrid('setGridParam', {
			datatype : 'local',
			data : data,
		}).trigger("reloadGrid");
	}
