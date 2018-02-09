<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="${ctx}/resources/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/pages/css/login-5.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/img/favicon.ico" rel="shortcut icon" />
    <script src="${ctx}/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap-toastr/toastr.min.js" type="text/javascript"></script>
</head>
<body class="login">
    <div class="user-login-5">
        <div class="row bs-reset">
            <div class="col-md-6 bs-reset mt-login-5-bsfix">
                <div class="login-bg" style="background-image:url(${ctx}/resources/assets/pages/img/login/bg1.jpg)">
                    <img class="login-logo" src="${ctx}/resources/assets/pages/img/login/logo.png" /> </div>
            </div>
            <div class="col-md-6 login-container bs-reset mt-login-5-bsfix">
                <div class="login-content">
                    <h1>Metronic Admin Login</h1>
                    <p> Some of us get dipped in flat, some in satin, some in gloss. But every once in a while you find someone who's iridescent, and when you do, nothing will ever compare. </p>
                    <form action="${ctx}/user/login" class="login-form" method="post">
                        <div class="alert alert-danger display-hide">
                            <button class="close" data-close="alert"></button>
                            <span>Enter any username and password. </span>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <input class="form-control form-control-solid placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="Username" id="account" id="account" name="username" required/> </div>
                            <div class="col-xs-6">
                                <input class="form-control form-control-solid placeholder-no-fix form-group" type="password" autocomplete="off" placeholder="Password" id="password" id="password" name="password" required/> </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="rem-password">
                                    <label class="rememberme mt-checkbox mt-checkbox-outline">
                                        <input type="checkbox" name="remember" value="1" /> Remember me
                                        <span></span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-sm-8 text-right">
                                <div class="forgot-password">
                                    <a href="javascript:;" id="forget-password" class="forget-password">Forgot Password?</a>
                                </div>
                                <button class="btn green" type="submit" id="submit-btn">Sign In</button>
                            </div>
                        </div>
                    </form>
                    <!-- BEGIN FORGOT PASSWORD FORM -->
                    <form class="forget-form" action="javascript:;" method="post">
                        <h3 class="font-green">Forgot Password ?</h3>
                        <p> Enter your e-mail address below to reset your password. </p>
                        <div class="form-group">
                            <input class="form-control placeholder-no-fix form-group" type="text" autocomplete="off" placeholder="Email" name="email" /> </div>
                        <div class="form-actions">
                            <button type="button" id="back-btn" class="btn green btn-outline">Back</button>
                            <button type="submit" class="btn btn-success uppercase pull-right">Submit</button>
                        </div>
                    </form>
                    <!-- END FORGOT PASSWORD FORM -->
                </div>
                <div class="login-footer">
                    <div class="row bs-reset">
                        <div class="col-xs-5 bs-reset">
                            <ul class="login-social" style="display: none">
                                <li>
                                    <a href="javascript:;">
                                        <i class="icon-social-facebook"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class="icon-social-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <i class="icon-social-dribbble"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-xs-7 bs-reset">
                            <div class="login-copyright text-right">
                                <p>Copyright &copy; Keenthemes 2015</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
var Login = function() {
    var handleLogin = function() {
        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                remember: {
                    required: false
                }
            },
            messages: {
                username: {
                    required: "Username is required."
                },
                password: {
                    required: "Password is required."
                }
            },
            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.login-form')).show();
            },
            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },
            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },
            errorPlacement: function(error, element) {
                error.insertAfter($('.close'));
            },
            submitHandler: function(form) {
            	//form.submit(); // form validation success, call ajax form submit
            	signIn();
            }
        });
        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    //$('.login-form').submit(); //form validation success, call ajax form submit
                	signIn();
                }
                return false;
            }
        });
        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });
        $('#forget-password').click(function(){
            $('.login-form').hide();
            $('.forget-form').show();
        });
        $('#back-btn').click(function(){
            $('.login-form').show();
            $('.forget-form').hide();
        });
    }
    return {
        //main function to initiate the module
        init: function() {
            handleLogin();
            // init background slide images
            $('.login-bg').backstretch([
                "${ctx}/resources/assets/pages/img/login/bg1.jpg",
                "${ctx}/resources/assets/pages/img/login/bg2.jpg",
                "${ctx}/resources/assets/pages/img/login/bg3.jpg"
                ], {
                  fade: 1000,
                  duration: 8000
                }
            );
            $('.forget-form').hide();
        }
    };
}();
function signIn(){
	var account=$.trim($('#account').val());
	var password=$.trim($('#password').val());
	var param = {
		'account' : account,
		'password': password
	};
	$.ajax({
		'type' : 'post',
		'url' : "${ctx}/user/login",
		'contentType' : 'application/json;charset=UTF-8',
		'data' : JSON.stringify(param),
		'dataType' : 'json',
		'beforeSend': function () {
	        // 禁用按钮防止重复提交
	        $('#submit-btn').attr("disabled","disabled");
	    },
		'success' : function(data){
			if(data.code==0){
				window.location.href="${ctx}/homepage";
			}else{
				toastr.error(data.msg);
			}
		},
	  	'complete' : function () {
	  		 $('#submit-btn').removeAttr('disabled');
	    }
	});
}
$(function(){ 
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
	Login.init();
});
</script>
</html>