(function($){
 /**
  * 为jqgrid增加默认设置，全局的默认设置
  */
 $.jgrid = $.jgrid || {};
 $.extend($.jgrid.defaults,{
  windowresize:true,
  rowNum : 10,//默认10行
  scrollOffset :18,//最后预留的垂直滚动条，如不需要设置成0
     altRows : true,//行颜色交替显示
  viewrecords : true,//现在总记录数
  hidegrid : false,//收缩grid
     shrinkToFit : true,//此属性用来说明当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
     autowidth : false,//如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
  datatype : "json",//这个参数用于设定将要得到的数据类型。我最常用的是"json"，其余的类型还包括：xml、xmlstring、local、javascript、function
  mtype : 'POST',//定义使用哪种方法发起请求，GET或者POST
  prmNames : {
   page : "page", // 表示请求页码的参数名称
   rows : "limit" // 表示请求行数的参数名称
  },
  mergers : null,//合并单元格
  loadComplete: function() {// 如果数据不存在，提示信息
      var _id = $(this).closest("table.ui-jqgrid-btable").attr('id').replace(/_frozen([^_]*)$/,'$1');
   var _gridId = _id;
   var _gridNoRecordsId = _id+"norecords_";
   var _grid = $("#"+_gridId);
      var rowNum = _grid.jqGrid('getGridParam','records');
      if (rowNum == 0 || rowNum == null){
       if($("#"+_gridNoRecordsId).html() == null){
        var colModel = _grid.jqGrid('getGridParam','colModel');
        var tds = 0;
        if (colModel != null && colModel.length>0) {
         for (var x = 0; x < colModel.length; x++) {
          if (!colModel[x].hidden || colModel[x].hidden=="false") {
           tds ++;
          }
         }
        }
        if (tds <4) {
         tds = 3
        }
        _grid.append("<tr id='"+_gridNoRecordsId+"' class='ui-widget-content ui-row-ltr'>" +
          "<td colspan='"+tds+"' style='text-align:center;' >无数据显示</td></tr>");
              //$("#"+$id).append("<pre><div id='norecords'>无数据显示</div></pre>");
          }
          $("#"+_gridNoRecordsId).show();
      }else{// 如果存在记录，则删除提示信息。
          $("#"+_gridNoRecordsId).remove();
      }
  },
  gridComplete: function() {// 如果grid 第一次加载的时候
   var _id = $(this).closest("table.ui-jqgrid-btable").attr('id').replace(/_frozen([^_]*)$/,'$1');
   var _gridId = _id;
   var _gridNoRecordsId = _id+"norecords_";
   var _grid = $("#"+_gridId);
      var rowNum = _grid.jqGrid('getGridParam','records');
      if (rowNum == 0 || rowNum == null){
       if($("#"+_gridNoRecordsId).html() == null){
        var colModel = _grid.jqGrid('getGridParam','colModel');
        var tds = 0;
        if (colModel != null && colModel.length>0) {
         for (var x = 0; x < colModel.length; x++) {
          if (!colModel[x].hidden || colModel[x].hidden=="false") {
           tds ++;
          }
         }
        }
        if (tds <4) {
         tds = 3
        }
        _grid.append("<tr id='"+_gridNoRecordsId+"' class='ui-widget-content ui-row-ltr'>" +
          "<td colspan='"+tds+"' style='text-align:center;' >无数据显示</td></tr>");
              //$("#"+$id).append("<pre><div id='norecords'>无数据显示</div></pre>");
          }
          $("#"+_gridNoRecordsId).show();
      }else{// 如果存在记录，则删除提示信息。
          $("#"+_gridNoRecordsId).remove();
      }
      //合并单元格
      var mergerFun = _grid.jqGrid('getGridParam','mergers');
      if (typeof mergerFun === 'function') {
       mergerFun();
      }
  },
  jsonReader : {
   root : "data.elements",
   page : "data.pageNo",
   records : "data.total",
   total: "data.pageNum",
   repeatitems: false
  }
 });
 
 /**
  * 复杂表头合并
  * jqGrid complexGroupHeaders
  * 手动触发表格宽度重新计算
  * jqGrid jqGridResize 
  * 增加window 的resize事件，触发表格宽度重新计算
  * jqGrid onWindowResize
  * version 0.2
  * date 2015-05-22
 **/
 $.jgrid.extend({
  /**
   * 当某一个jqgrid的宽度变化时，调用此方法
   * @param {} jqId
   */
  jqGridResize : function(o) {
   var _o = $.extend(true,{
        compel : false
       },o||{});
   var $t = this[0];
   if(!$t.grid) { return; }
   // Get width of parent container
   var parWidth = $("#gbox_"+$t.id).parent().width();
   var curWidth = $("#gbox_"+$t.id).width();
   //console.log("span width " + parWidth + " gridWidth " + curWidth);
   var w = parWidth - 1; // Fudge factor to prevent horizontal scrollbars
   if (Math.abs(w - curWidth) > 2 || _o.compel) {
    //alert("resize to " + width);
    //console.log("span width " + parWidth + " gridWidth " + curWidth);
    if (w<(curWidth-3)) {
     //scrollOffset :0,时，增加表格由大变小后，出现滚动条的问题
     //让表格先变成最新，然后再扩大，就能避免这个问题了
     $("#"+$t.id).setGridWidth(100);
    }
    $("#"+$t.id).setGridWidth(w);
    //console.log("new width " + w);
   }
  },
  /**
   * 初始化某一个jqgrid，使它的宽度随着浏览器大小变化而变化
   * @param {} jqId
   */
  _jqgridResizeObj : {},
  onWindowResize : function(o) {
   var me = this;
   var $t = this[0];
   if(!$t.grid) { return; }
   $(window).on('resize', function(event, ui) {
    if(me._jqgridResizeObj[$t.id]){
     clearTimeout(me._jqgridResizeObj[$t.id]);
    }
    me._jqgridResizeObj[$t.id] = setTimeout(function(){
     me.jqGridResize($t.id);
    },700);
   }).trigger('resize');
  },
  customGridComplete : function(o) {
   var $t = this[0];
   if(!$t.grid) { return; }
  },
  setNavGrid : function(o) {
   var $t = this[0];
   if(!$t.grid) { return; }
   var _o = $.extend(true,{
     excel : true,
     edit : false,
     add : false,
     del : false,
     search : false,
     refresh : true,
     view : false
    },o||{});
   var _grid = $("#"+$t.id);
   var _pager = _grid.jqGrid('getGridParam','pager');
      _grid.navGrid(_pager, _o);
   if(_o.excel){
    // add export excel button
    _grid.navButtonAdd(_pager, {
       id : $t.id+'_excel',
       buttonicon : "ui-icon-document",
       title : "导出到Excel",
       caption : "导出",
       position : "last"
      });
   }
  },
  setComplexGroupHeaders : function(o) {
   var $t = this[0];
   if(!$t.grid) { return; }
   var $ghs;
   if(o.groupHeaders){
    $ghs = o.groupHeaders;
    $(this).setGroupHeaders(o);
   }else{
    $ghs = $t.p.groupHeader;
   }
   var $cghs = o.complexGroupHeaders;
   if(!$cghs){return;}
   var colModel = $t.p.colModel;
   var s_ths = $("#gbox_"+$t.id+" .ui-jqgrid-htable .jqg-second-row-header > th");
   for(var i=0;i<$ghs.length;i++){
    var ghItem = $ghs[i];
    var count_secondCol = 0;
    for(var j=0;j<colModel.length;j++){
     if(colModel[j].name==ghItem.startColumnName){
      break;
     }
     count_secondCol++;
    }
    for(var j=0;j<i;j++){
     count_secondCol = count_secondCol - ($ghs[j].numberOfColumns-1);
    }
    $(s_ths[count_secondCol]).attr("startColName","s_" + ghItem.startColumnName)
    .attr("numberOfColumns",ghItem.numberOfColumns);
   }
   var newTr = $('<tr role="rowheader" class="ui-jqgrid-labels jqg-four-row-header"></tr>');
   var moveThs = {};
   var setThStatus = function(columnName,th,status){
    var thItem = moveThs[columnName];
    if(!thItem){
     moveThs[columnName] = th;
     thItem = th;
    }
    if(thItem.attr("status")!=0 && thItem.attr("status")!=3){
     thItem.attr("status",status);
    }
   };
   
   var startIndex,endIndex;
   for(var i=0;i<$cghs.length;i++){
    for(var j=0;j<colModel.length;j++){
     var colItem = colModel[j];
     if(colItem.name == $cghs[i].startColumnName){
      startIndex = j;
      endIndex = startIndex + $cghs[i].numberOfColumns;
      break;
     }
    }
    for(var j=0;j<colModel.length;j++){
     var colItem = colModel[j];
     var thItem = $("thead #" + $t.id + "_" + colItem.name);
     if(j<startIndex||j>=endIndex){
      if(thItem.attr("rowspan")==2){
       thItem.attr("sortable",colItem.sortable);
       thItem.attr("colmodeName",colItem.name);
       setThStatus(colItem.name,thItem,1);
      }else if(!thItem.attr("rowspan")){
       var th = $("#gbox_"+$t.id+" .ui-jqgrid-htable .jqg-second-row-header th[startcolname='s_"+colItem.name+"']");
       if(th.length!=0){
        setThStatus("s_" + colItem.name,th,2);
       }
      }
     }else if(j==startIndex){
      var newTh = $('<th role="columnheader" class="ui-state-default ui-th-column-header ui-th-ltr" style="height: 22px; border-top-width: 0px; border-top-style: none; border-top-color: initial; "></th>');
      newTh.attr("colspan",$cghs[i].numberOfColumns).html($cghs[i].titleText);
      setThStatus(colItem.name,thItem,0);
      setThStatus("n_"+colItem.name,newTh,3);
      var th = $("#gbox_"+$t.id+" .ui-jqgrid-htable .jqg-second-row-header th[startcolname='s_"+colItem.name+"']");
      if(th.length!=0){
       var clonTh = th.clone(true);
       setThStatus("s_" + colItem.name,clonTh,0);
      }
     }else{
      setThStatus(colItem.name,thItem,0);
      var th = $("#gbox_"+$t.id+" .ui-jqgrid-htable .jqg-second-row-header th[startcolname='s_"+colItem.name+"']");
      if(th.length!=0){
       var clonTh = th.clone(true);
       setThStatus("s_" + colItem.name,clonTh,0);
      }
     }
    }
   }
   for (prop in moveThs) {
    var item = moveThs[prop];
    var status = item.attr("status");
    if(status==1){
     item.attr("rowSpan","3");
     var cloneItem = item.clone(true);
     if(cloneItem.attr("sortable")=='true'){
      cloneItem.unbind("click");
      cloneItem.click(function(){
       $("#gbox_"+$t.id+" .ui-jqgrid-htable .s-ico").css("display","none");
       var name = $(this).attr("colmodeName");
       $t.p.sortname = name;
       $(this).find("span.s-ico").css("display","inline");
       var ascClass = $(this).find("span.ui-icon-asc").attr("class");
       var reg = /.*ui-state-disabled.*/ig;
       var result = reg.test(ascClass);
       if(result){
        $t.p.sortorder = 'asc';
        $(this).find("span.ui-icon-asc").removeClass("ui-state-disabled");
        $(this).find("span.ui-icon-desc").addClass("ui-state-disabled");
       }else{
        $t.p.sortorder = 'desc';
        $(this).find("span.ui-icon-desc").removeClass("ui-state-disabled");
        $(this).find("span.ui-icon-asc").addClass("ui-state-disabled");
       }
       $($t).trigger("reloadGrid");
      });
     }
     newTr.append(cloneItem);
     item.remove();
    }else if(status==2){
     item.attr("rowSpan","2");
     var cloneItem = item.clone(true);
     newTr.append(cloneItem);
     item.remove();
    }else if(status==3){
     newTr.append(item);
    }
   }
   var second_tr = $("#gbox_"+$t.id+" .ui-jqgrid-htable .jqg-second-row-header");
   newTr.insertBefore(second_tr);
  },
  setMerger : function(o) {
   var _o = $.extend(true,{
      cellNames : [],
      mergerAll : true//合并所有可以合并的列？true是合并所有可以合并的列，false是当前合并列之前的所有列都相同才可以合并
     },o);
   if (_o.cellNames && _o.cellNames instanceof Array) {
    //得到显示到界面的id集合
    var $t = this[0];
    if(!$t.grid) { return; }
    var mya = $("#" + $t.id + "").getDataIDs();
    //当前显示多少条
    var length = mya.length;
    for (var cs = 0; cs < _o.cellNames.length; cs++) {
     var CellName = _o.cellNames[cs];
     for (var i = 0; i < length; i++) {
      //从上到下获取一条信息
      var before = $("#" + $t.id + "").jqGrid('getRowData', mya[i]);
      //定义合并行数
      var rowSpanTaxCount = 1;
      for (j = i + 1; j <= length; j++) {
       //和上边的信息对比 如果值一样就合并行数+1 然后设置rowspan 让当前单元格隐藏
       var end = $("#" + $t.id + "").jqGrid('getRowData', mya[j]);
       var flag= true;
       if (!_o.mergerAll) {
                 for(var k=0; k<=cs; k++){
                  if(before[_o.cellNames[k]] != end[_o.cellNames[k]]){
                   flag= false;
                   break;
                  }
                 }
       }
       if (before[CellName] == end[CellName] && flag) {
        rowSpanTaxCount++;
        $("#" + $t.id + "").setCell(mya[j], CellName, '', {display : 'none'});
       } else {
        rowSpanTaxCount = 1;
        break;
       }
       //$("#" + CellName + "" + mya[i] + "").attr("rowspan", rowSpanTaxCount);
       $("td[aria-describedby='" + $t.id + "_" + CellName + "']","#" + $t.id + "").eq(i).attr("rowspan", rowSpanTaxCount);
      }
     }
    }
   }
  }
 });
})(jQuery);