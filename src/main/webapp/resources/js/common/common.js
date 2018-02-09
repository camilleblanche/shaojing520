	//JavaScript时间格式化
	Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "H+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    	return fmt;
	}
	var curDateString = new Date().Format("yyyy-MM-dd HH:mm:ss");//当前时间字符串
	
	//自定义字典对象  
	function Map() {  
	    this.data = new Array();  
	  
	    this.put = function(key, value) {  
	        this.data[key] = value;  
	    };  
	  
	    this.get = function(key) {  
	        return this.data[key];  
	    };  
	  
	    this.remove = function(key) {  
	        this.data[key] = null;  
	    };  
	  
	    this.isEmpty = function() {  
	        return this.data.length == 0;  
	    };  
	  
	    this.size = function() {  
	        return this.data.length;  
	    };  
	}
	var map = new Map();//typeof(map.get(key)) == "undefined"
	
	//查找指定的元素在数组中的位置即索引
	Array.prototype.indexOf = function(val) {
		for (var i = 0; i < this.length; i++) {
			if (this[i] == val) 
				return i;
		}
		return -1;
	};
	//数组删除指定元素
	Array.prototype.remove = function(val) {
		var index = this.indexOf(val);
		if (index > -1) {
			this.splice(index, 1);
		}
	};
	
	$(function(){ 
		//toastr初始化设置
	    toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "positionClass": "toast-top-center",
		  "onclick": null,
		  "showDuration": "1000",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
	});
	