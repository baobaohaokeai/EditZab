;(function($){
	/**
	 * name 就是需要验证组建的name
	 * type 组件类型
	 * validate_name 验证框,提示的时候要用到
	 * required 表示是否必填
	 * validate_type 表示验证类型,目前就三种 normal -- 只验证是否必输,digits -- 整数
	 * validate_format 格式,当validate_type=positiveNumber,验证小数点位数
	 * minvalue 最小值   maxvalue 最大值
	 * minlength 最小长度  maxlength 最大长度
	 */
	function SelfValidateObj (opt) {
		// 默认
		var defaults = {
			form_name : "",
			form_name_rule : null
		};

		// 把defaults和opt合并
		this.options = $.extend(true, defaults, opt);
		this.init();
		this.required_message = "该项为必输项,不能为空!";
		this.positiveNumber_message = "必须输入一个正数!";
		this.scale_messgae = "小数点位数不能超过";
		this.positiveInteger_message = "必须输入一个正整数!";
		this.digits_message = "必须输入一个整数!";
		this.number_message = "必须输入一个数字!";
		this.mobile_message = "请输入正确的手机号码";
	}

	SelfValidateObj.prototype = {
		init: function(){
			var that = this;
			opts = that.options;
		},
		validate: function(){
			var that = this;
			var form = $("#"+this.options.form_name);
			var is_validate = true;
			$.each(this.options.form_name_rule,function(index,ob){
				var rule_name = ob.name;
				var rule_type = ob.type;
				var validate_type = ob.validate_type;
				var required = ob.required;
				var validate_name = ob.validate_name;
				var component_name = $(form).find("'"+rule_type+"[name="+rule_name+"]'");
				var component_val = $(component_name).val();
				var validate_format = parseInt(ob.validate_format);
				if(required == true){	//验证必输
					if($(component_name).val() == null || $(component_name).val() == ""){
						var message = validate_name+that.required_message;
						is_validate = false;
						alert(message);
						return is_validate;
					}
				}
				if(validate_type == 'positiveNumber' ){//正数
					var r = that.getScale(validate_format);
					var v = parseFloat(component_val);
					var message = validate_name+that.positiveNumber_message;
					if(!component_val || !v){
						is_validate = false;
						alert(message);
						return is_validate;
					}if(!r.test(component_val)){
						is_validate = false;
						alert(message+","+that.scale_messgae+validate_format+"位!");
						return is_validate;
					}else {
						$(component_name).val(v);
					}
				}
				
				if(validate_type == 'positiveInteger'){//正整数
					var r = /^\+?[1-9][0-9]*$/;
					var v = parseInt(component_val);
					var message = validate_name+that.positiveInteger_message;
					if(!r.test(component_val)){
						is_validate = false;
						alert(message);
						return is_validate;
					}else{
						$(component_name).val(v);
					}
				}
				
				if(validate_type == 'digits'){ //验证整数
					var r = /^(-|\+)?\d+$/;
					var v = parseInt(component_val);
					var message = validate_name+that.digits_message;
					if(!r.test(component_val)){
						is_validate = false;
						alert(message);
						return is_validate;
					}else{
						$(component_name).val(v);
					}
				}
				if(validate_type == 'mobile'){ //手机号码
					var mobile = /^((1[0-9]{1}[0-9]{1})+\d{8})$/;
					if(!component_val){
						var message = validate_name+that.mobile_message;
						is_validate = false;
						alert(message);
						return is_validate;
					}else if(!mobile.test(component_val)&&component_val.length!=11){
						var message = validate_name+"："+that.mobile_message;
						is_validate = false;
						alert(message);
						return is_validate;
					}
				}
				
			});
			return is_validate;
		},
		getScale : function(val){
			if(val == 1){
				var r = /^\d+(\.\d{0,1})?$/;
				return  r;
			}else if(val == 2){
				var r = /^\d+(\.\d{0,2})?$/;
				return  r;
			}else if(val == 3){
				var r = /^\d+(\.\d{0,3})?$/;
				return  r;
			}
		}
	}

	window.SelfValidateObj = SelfValidateObj;
})(jQuery);