;(function($){
	function TabChangeObj (opt) {
		// 默认
		var defaults = {
			unselect_class: "",
			select_class: 'cur',// 选中要添加的颜色
			p_id: 'xx',// 父组建的ID
			childName: 'li',
			reload_data : function(obj){

			}
		};

		// 把defaults和opt合并
		this.options = $.extend(true, defaults, opt);
		this.children = [];
		this.init();
	}

	TabChangeObj.prototype = {
		init: function(){
			var that = this;
			opts = that.options;
			children = $("#"+that.options.p_id).find(that.options.childName);
			
			$("#"+that.options.p_id).find(that.options.childName).on('click',function(){
				var selected = $(this).attr("class");
				if(selected == that.options.select_class){
					return;
				}
				that.tab_change($(this));
			});
		},
		tab_change: function(obj){
			var that = this;
			$(children).each(function(index,ob){
				$(ob).removeClass(that.options.select_class);
				$(ob).addClass(that.options.unselect_class);
			});
			$(obj).removeClass(this.options.unselect_class);
			$(obj).addClass(this.options.select_class);
			
			this.options.reload_data(obj);
		}
	}

	window.TabChangeObj = TabChangeObj;
})(jQuery);