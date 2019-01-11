;(function($){
	function ComponentObj (opt) {
		// 默认
		var defaults = {
			unselect_class: "",
			select_class: 'selected',// 选中要添加的颜色
			p_id: 'xx',// 父组建的ID
			childName: 'li'
		};

		// 把defaults和opt合并
		this.options = $.extend(true, defaults, opt);
		this.children = [];
		this.init();
	}

	ComponentObj.prototype = {
		init: function(){
			var that = this;
			opts = that.options;
			children = $("#"+that.options.p_id).find(that.options.childName);
			
			$("#"+that.options.p_id).find(that.options.childName).on('click',function(){
				that.component_select($(this));
			});
		},
		component_select: function(obj){
			var that = this;
			if($(obj).attr('class') == that.options.select_class){
				$(obj).removeClass(that.options.select_class);
				$(obj).addClass(that.options.unselect_class);
			}else{
				$(obj).removeClass(that.options.unselect_class);
				$(obj).addClass(that.options.select_class);
			}
		},
		getSelected: function(){
			var selected_component = new Array();
			var that = this;
			var objs = $("#"+that.options.p_id).find("'"+that.options.childName+"'[class="+that.options.select_class+"]");
			$.each(objs,function(index,ob){
				selected_component.push($(ob).text());
			});
			return selected_component.toString();
		}
	}

	window.ComponentObj = ComponentObj;
})(jQuery);