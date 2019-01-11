	
	/**
	 * 加载监控类型(权限不控制)
	 */
	function loadType(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/monitorCommon/loadType.json',
			success : function(data) {
				$("#type").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#type").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+">"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载已知类型的监控项(权限不控制)
	 */
	function loadItemByType(type){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/monitorCommon/loadItemByType.json',
			data :{type:type},
			success : function(data) {
				$("#"+type).find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#"+type).append( "<option value='"+item.key+"' "+(i==0?"selected":"")+" resultType='"+item.resultType+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载热门监控项(权限不控制)
	 */
	function loadHotItem(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/monitorCommon/loadHotItem.json',
			data :{},
			success : function(data) {
				$("#hotItem").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#hotItem").append( "<option value='"+item.key+"' "+(i==0?"selected":"")+" resultType='"+item.resultType+"'>"+item.name+"</option>" );
				}
			}
		});
	}
