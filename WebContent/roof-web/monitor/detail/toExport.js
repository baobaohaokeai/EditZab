
var ToExportCommon = (function() {
	/*替换指定格式的html代码*/
	function replaceStr(str){
		str = str.replace(/<[\s]*br[\s]*[\/]?[\s]*>/gmi, "");
		str = str.replace(/<a[\s]*[^>]*>/gmi, "");
		str = str.replace(/<a[\s]+[^>]+>/gmi, "");
		str = str.replace(/<\/[\s]*a[\s]*>/gmi, "");
		return str;
	}
	
	/**
	 * isHidden : 是否隐藏隐藏列;
	 * isExportComplexHeader : 是否导出复杂表头(多级表头)
	 * isExportRowNumber : 是否导出序号
	 */
	function _ToExport(_obj) {
		var myGrid = _obj.myGrid;
		var action = _obj.action; 
		var title = _obj.title;  
		var isHidden = _obj.isHidden; 
		var isExportComplexHeader = _obj.isExportComplexHeader;
		var isExportRowNumber = _obj.isExportRowNumber;
		
		if(isHidden == undefined || typeof(isHidden) != 'boolean'){
			isHidden = true;
		}
		if(isExportComplexHeader == undefined || typeof(isExportComplexHeader) != 'boolean'){
			isExportComplexHeader = false;
		}
		if(isExportRowNumber == undefined || typeof(isExportRowNumber) != 'boolean'){
			isExportRowNumber = false;
		}

		var extraParams = {};
		var headerStr = "";
		
		if (myGrid.localReader && myGrid.jsonReader) {//通过jqgrid的两个重要属性判断是否是jqgrid的表格导出
			extraParams = myGrid.postData;
			var _obj = handleExportData(myGrid, isHidden, isExportComplexHeader, isExportRowNumber);
			headerStr = _obj.headerStr;
		}
		var myForm = document.createElement("form");
		myForm.method = "post";
		myForm.target = "_blank";
		myForm.acceptCharset = "utf-8";
		myForm.action = action;
		document.body.appendChild(myForm);
		// 创建隐藏表单
		for (var p in extraParams) {
			if (p === "_search") {
				continue;
			}
			var name = p;// 属性名称
			var value = extraParams[p];// 属性对应的值
			var newElement = document.createElement("input");
			newElement.setAttribute("name", name);
			newElement.setAttribute("type", "hidden");
			newElement.setAttribute("value", value);
			myForm.appendChild(newElement);
		}
		var newElement = document.createElement("input");
		newElement.setAttribute("name", "FileTitle");
		newElement.setAttribute("type", "hidden");
		newElement.setAttribute("value", title);
		myForm.appendChild(newElement);
		
		newElement = document.createElement("input");
		newElement.setAttribute("name", "HeaderTitle");
		newElement.setAttribute("type", "hidden");
		newElement.setAttribute("value", headerStr);
		myForm.appendChild(newElement);
		
		myForm.submit();
		document.body.removeChild(myForm);
	};
	
	/**
	 * myGrid : gridObj,
	 * isHidden : 是否隐藏隐藏列
	 * isExportComplexHeader : 是否导出复杂表头
	 * isExportRowNumber : 是否导出序号
	 * */
	function handleExportData(myGrid, isHidden, isExportComplexHeader, isExportRowNumber){
		var flag = 0;//标记是否显示序号和显示了复选框(jqgrid如果显示,会占用列个数)
		var colIndex = myGrid.colModel;
		var colName = myGrid.colNames;//["序号", "时间", "地市", "地市id"]
		
		/*处理一级表头name和index*/
		var firstTitleName = [];
		var firstTitleIndexName = [];
		var firstTitleIndexIsHidden = [];
		
		for(var i = 0 ; i < colIndex.length;i++){
			//rn,cb为jqgrid自己定义的列名.
			if(colIndex[i].name == 'rn'){//如果设置了显示序号(即有序号列)
				if(isExportRowNumber){
					firstTitleName.push("序号");	
					firstTitleIndexName.push(colIndex[i].name);	
					firstTitleIndexIsHidden.push("false");
				}else{
					flag++;
					continue;
				}
			}else if(colIndex[i].name == 'cb'){//如果设置了显示复选框(即有复选框列)
				flag++;
				continue;
			}else {//正常列
				firstTitleName.push(replaceStr(colName[i]));
				firstTitleIndexName.push(colIndex[i].name);	
				
				/*处理隐藏列*/
				if (isHidden && colIndex[i].hidden) {//
					firstTitleIndexIsHidden.push("true");
				}else{
					firstTitleIndexIsHidden.push("false");
				}
			}
		}

		/*处理二级表头name和startIndex以及endIndex*/
		var secondTitleName = [];
		var secondTitleStartIndex = [];
		var secondTitleEndIndex = [];
		if(isExportComplexHeader && myGrid.groupHeader){
			var groupHeaders = myGrid.groupHeader.groupHeaders;/*2级表头,(3级表头暂时无法获取)*/
			for(var i = 0 ; i < groupHeaders.length;i++){
				//{startColumnName: "attach_success", numberOfColumns: 4, titleText: "接入性"}
				var startIndex = getIndex(colIndex,groupHeaders[i].startColumnName) - flag;//(由于序号和复选框会占用index数目,所以这里减去)
				var endIndex = startIndex + groupHeaders[i].numberOfColumns - 1;//如果从0开始 ,占2列  结束列为0+2-1=1
				
				secondTitleName.push(groupHeaders[i].titleText);
				secondTitleStartIndex.push(startIndex);
				secondTitleEndIndex.push(endIndex);
			}
		}
		
		var headerArray = [];
		var splitSign1 = ",#,";//同一类型字段拆分标识
		var splitSign2 = ";#;";//不同类型字段拆分标识
		
		headerArray.push(firstTitleName.join(splitSign1));
		headerArray.push(firstTitleIndexName.join(splitSign1));
		headerArray.push(firstTitleIndexIsHidden.join(splitSign1));
		headerArray.push(secondTitleName.join(splitSign1));
		headerArray.push(secondTitleStartIndex.join(splitSign1));
		headerArray.push(secondTitleEndIndex.join(splitSign1));
		
		return {
			headerStr : headerArray.join(splitSign2)
		};
	}
	
	/*获取二级表头开始列名对应的列序号*/
	function getIndex(colIndex,name){
		if(name && colIndex){
			for(var i = 0 ; i < colIndex.length;i++){
				if(colIndex[i].name == name){
					return i;
				}
			}
		}
		return -1;
	}
	
	return {
		_ToExport : _ToExport
	};
})();

function ToExport(myGrid){
	ToExportCommon._ToExport(myGrid);
}