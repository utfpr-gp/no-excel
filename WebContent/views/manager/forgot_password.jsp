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
		<c:if test="${error_message.equals(\"\") == false}">
			<div class="alert alert-dismissable alert-danger">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>${error_message}</strong>
		</c:if>
	</div>

	<div
		class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
		<h2 class="form-signin-heading text-center">Esqueci minha senha</h2>
		<div class="card-s card-signin">
			<img class="img-circle profile-img" src="${ctx}/img/no-excel.png"
				alt="Noexcel">
			<form class="form-signin" action="${ctx}/ForgotPasswordServlet"
				method="POST">
				<div class="form-control-wrapper">
					<div class="form-group">
						<input class="form-control" id="email" placeholder="Email"
							type="text" name="email">
					</div>

					<div class="form-group">
						<button class="btn btn-lg btn-warning btn-block" type="submit">Enviar</button>

						<br /> <a href="${ctx}/views/manager/login.jsp"
							class="btn btn-lg btn-block btn-default" type="submit">
							Cancelar/Voltar </a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /container -->
	<script src="<%=request.getContextPath()%>/js/jquery-1.11.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ripples.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/material.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/app.js"></script>
</body>
</html>