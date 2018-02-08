<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<title>首页</title>
</head>
<body>
<button id="updateBtn">click to update</button>
</body>
<script type="text/javascript">
$(function(){
	//alert(1);
})
$("#updateBtn").click(function(){
	// 提交表单数据到后台处理
	var $this=this;
	var param = {
		"userId" : 1,
		"password":"Jing0109"
	};
	$.ajax( {
		'type' : 'POST',
		'url' : "${ctx}/user/updateuser",
		'contentType' : 'application/json;charset=UTF-8',
		'data' : JSON.stringify(param),
		'dataType' : 'json',
		'beforeSend': function () {
	        // 禁用按钮防止重复提交
	        //$($this).attr("disabled","disabled");
	    },
		'success' : function(data){
			if(data.success){
				
			}
		},
	  	'complete' : function () {
	  		 //$($this).removeAttr("disabled");
	    }
	});
});
</script>
</html>