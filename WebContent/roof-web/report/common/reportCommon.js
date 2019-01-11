	
	/**
	 * 加载地市公司(权限不控制)
	 */
	function loadAreaCompany(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadAreaCompany.json',
			success : function(data) {
				$("#areaCompany").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#areaCompany").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+">"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载区县公司(权限不控制)
	 */
	function loadCountyCompany(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadCountyCompany.json',
			data :{},
			success : function(data) {
				$("#countyCompany").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#countyCompany").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载支局(权限不控制)
	 */
	function loadSubOffice(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadSubOffice.json',
			data :{},
			success : function(data) {
				$("#subOffice").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#subOffice").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载客户统计属性
	 */
	function loadCustomerProp(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadCustomerProp.json',
			data :{},
			success : function(data) {
				$("#customerProp").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#customerProp").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载客户等级
	 */
	function loadCustomerLevel(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadCustomerLevel.json',
			data :{},
			success : function(data) {
				$("#customerLevel").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#customerLevel").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载营销服务类型
	 */
	function loadMarketServiceType(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadMarketServiceType.json',
			data :{},
			success : function(data) {
				$("#marketServiceType").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#marketServiceType").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载停机类型
	 */
	function loadHaltType(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadHaltType.json',
			data :{},
			success : function(data) {
				$("#haltType").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#haltType").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
	
	/**
	 * 加载部门/营业部门/受理部门?是不是都是一个
	 */
	function loadDept(){
		$.ajax({
			type : 'POST',
			async : false,//同步
			dataType : "json",
			url : ROOF.Utils.projectName() + '/reportCommon/loadDept.json',
			data :{},
			success : function(data) {
				$("#bussinessDept").find("option").remove();
				for(var i =0;i<data.length;i++){
					var item = data[i];
					$("#bussinessDept").append( "<option value='"+item.value+"' "+(i==0?"selected":"")+"'>"+item.name+"</option>" );
				}
			}
		});
	}
