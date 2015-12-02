<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:set var="ctx" value="<%=request.getContextPath()%>" />

<link rel="icon" href="${ctx}/img/no-excel.png">

<title>NoExcel</title>

<!-- Bootstrap core CSS -->
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

<link href="${ctx}/css/roboto.min.css" rel="stylesheet">

<link href="${ctx}/css/ripples.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${ctx}/css/signin.css" rel="stylesheet">

<link href="${ctx}/css/style.css" rel="stylesheet">

</head>

<body class="hasGoogleVoiceExt">

	<div class="container">

		<div class="alert alert-dismissable alert-success">
			<button type="button" class="close" data-dismiss="alert">×</button>
			<strong>Sua senha foi alterada</strong>
		</div>
	</div>
	
	<br />
	
	<a href="${ctx}/views/manager/login.jsp"
		class="btn btn-lg btn-block btn-default" type="submit">
		Cancelar/Voltar </a>
		
	<!-- /container -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ripples.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/material.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/app.js"></script>
</body>
</html>