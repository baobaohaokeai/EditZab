/*! ******************************
  Handlebars helpers
  *******************************/
//  return the first item of a list only
// usage: {{#first items}}{{name}}{{/first}}
Handlebars.registerHelper('first', function(context, block) {
  return block(context[0]);
});
// a iterate over a specific portion of a list.
// usage: {{#slice items offset="1" limit="5"}}{{name}}{{/slice}} : items 1 thru 6
// usage: {{#slice items limit="10"}}{{name}}{{/slice}} : items 0 thru 9
// usage: {{#slice items offset="3"}}{{name}}{{/slice}} : items 3 thru context.length
// defaults are offset=0, limit=5
// todo: combine parameters into single string like python or ruby slice ("start:length" or "start,length")
Handlebars.registerHelper('slice', function(context, block) {
  var ret = "",
      offset = parseInt(block.hash.offset) || 0,
      limit = parseInt(block.hash.limit) || 5,
      i = (offset < context.length) ? offset : 0,
      j = ((limit + offset) < context.length) ? (limit + offset) : context.length;
 
  for(i,j; i<j; i++) {
    ret += block(context[i]);
  }
 
  return ret;
});
//  return a comma-serperated list from an iterable object
// usage: {{#toSentence tags}}{{name}}{{/toSentence}}
Handlebars.registerHelper('toSentence', function(context, block) {
  var ret = "";
  for(var i=0, j=context.length; i<j; i++) {
    ret = ret + block(context[i]);
    if (i<j-1) {
      ret = ret + ", ";
    };
  }
  return ret;
});
//  format an ISO date using Moment.js
//  http://momentjs.com/
//  moment syntax example: moment(Date("2011-07-18T15:50:52")).format("MMMM YYYY")
//  usage: {{dateFormat creation_date format="MMMM YYYY"}}
Handlebars.registerHelper('dateFormat', function(context, block) {
  if (window.moment) {
    var f = block.hash.format || "MMM Do, YYYY";
    if($.trim(context) !== ''){
    	return moment(new Date(context)).format(f);
    }else{
    	return context;
    }
	
  }else{
    return context;   //  moment plugin not available. return data as is.
  };
});
//{{#compare unicorns ponies operator="<"}}
// 	I knew it, unicorns are just low-quality ponies!
// {{/compare}}
// 
// (defaults to == if operator omitted)
//
// {{#equal unicorns ponies }}
// 	That's amazing, unicorns are actually undercover ponies
// {{/equal}}
// (from http://doginthehat.com.au/2012/02/comparison-block-helper-for-handlebars-templates/)
Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {

    if (arguments.length < 3)
        throw new Error("该函数需要两个参数");

    operator = options.hash.operator || "==";
    var operators = {
        '==':       function(l,r) { return l == r; },
        '===':      function(l,r) { return l === r; },
        '!=':       function(l,r) { return l != r; },
        '<':        function(l,r) { return l < r; },
        '>':        function(l,r) { return l > r; },
        '<=':       function(l,r) { return l <= r; },
        '>=':       function(l,r) { return l >= r; },
        'typeof':   function(l,r) { return typeof l == r; }
    }
    if (!operators[operator])
        throw new Error("缺少运算符 "+operator);

    var result = operators[operator](lvalue,rvalue);
    if( result ) {
        return options.fn(this);
    } else {
        return options.inverse(this);
    }
});
Handlebars.registerHelper('ifCond', function (v1, operator, v2, options) {
    switch (operator) {
        case '==':
            return (v1 == v2) ? options.fn(this) : options.inverse(this);
        case '===':
            return (v1 === v2) ? options.fn(this) : options.inverse(this);
        case '<':
            return (v1 < v2) ? options.fn(this) : options.inverse(this);
        case '<=':
            return (v1 <= v2) ? options.fn(this) : options.inverse(this);
        case '>':
            return (v1 > v2) ? options.fn(this) : options.inverse(this);
        case '>=':
            return (v1 >= v2) ? options.fn(this) : options.inverse(this);
        case '&&':
            return (v1 && v2) ? options.fn(this) : options.inverse(this);
        case '||':
            return (v1 || v2) ? options.fn(this) : options.inverse(this);
        case '!=':
            return (v1 != v2) ? options.fn(this) : options.inverse(this);
        default:
            return options.inverse(this);
    }
});

Handlebars.registerHelper('ifas',function(op1,operator,op2,op3,options){
	switch (operator) {
    case '%':
        return (op1 % op2 == op3) ? options.fn(this) : options.inverse(this);
    case '*':
        return (op1 * op2 == op3) ? options.fn(this) : options.inverse(this);
    default:
        return options.inverse(this);
}
});
