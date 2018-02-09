<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="utf-8">
	<title>404</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="${ctx}/resources/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/assets/pages/css/error.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/img/favicon.ico" rel="shortcut icon" />
    <script src="${ctx}/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
</head>
<body class=" page-404-full-page">
	<div class="row">
	    <div class="col-md-12 page-404">
	        <div class="number font-red"> 404 </div>
	        <div class="details">
	            <h3>Oops! You're lost.</h3>
	            <p> We can not find the page you're looking for.
	                <br/>
	                <a href="${ctx}/homepage"> Return home </a> or try the search bar below. </p>
	            <form action="#">
	                <div class="input-group input-medium">
	                    <input type="text" class="form-control" placeholder="keyword...">
	                    <span class="input-group-btn">
	                        <button type="submit" class="btn red">
	                            <i class="fa fa-search"></i>
	                        </button>
	                    </span>
	                </div>
	                <!-- /input-group -->
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>