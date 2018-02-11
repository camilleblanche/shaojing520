<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta charset="utf-8">
	<title>404</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="${ctx}/resources/css/404.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/resources/img/favicon.ico" rel="shortcut icon" />
    <script src="${ctx}/resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/js/404.js" type="text/javascript"></script>
</head>
<body>
	<div class="code">
		<p>ERROR 404</p>
	</div>
	<div class="road">
		<div class="shadow">
			<div class="shelt">
				<div class="head">
					<div class="eyes">
						<div class="lefteye">
							<div class="eyeball"></div>
							<div class="eyebrow"></div>
						</div>
						<div class="righteye">
							<div class="eyeball"></div>
							<div class="eyebrow"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="hat"></div>
			<div class="bubble">
				<a href="${ctx}/homepage">Go back Home?</a>
			</div>
		</div>
		<p>PAGE NOT FOUND</p>
	</div>
</body>
</html>