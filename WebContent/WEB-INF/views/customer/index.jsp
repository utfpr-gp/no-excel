<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/material-fullpalette.min.css" rel="stylesheet">
<link href="css/roboto.min.css" rel="stylesheet">
<link href="css/ripples.min.css" rel="stylesheet">
<link href="css/material.min.css" rel="stylesheet">   
   <!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">

<title>Consultar Extrato - ${person.getName()}</title>
< script language="JavaScript" type="text/javascript">
   function mascaraData(campoData){
              var data = campoData.value;
              if (data.length == 2){
                  data = data + '/';
                  document.forms[0].data.value = data;
      return true;              
              }
              if (data.length == 5){
                  data = data + '/';
                  document.forms[0].data.value = data;
                  return true;
              }
         }
< /script>
</head>
<body>
<jsp:include page="../includes/nav_customer.jsp"/>
<div class="container">
	<h3 class='text-center'>As últimas 30 transações de ${person.getName()}</h3>
	<h2><span class="label label-success">Saldo Atual: ${person.getReal()}</span></h2>
	
	<div align="right">
		<form method="post" action="<%= request.getContextPath() %>/customer">
			<div class="form-group form-inline">
			  De: <input type="date" name="beginDate" OnKeyUp="mascaraData(this);"id="beginDate" class="form-control">
			   Até: <input type="date" name="endDate"OnKeyUp="mascaraData(this);" id="endDate" class="form-control">
			   <button type="submit" class="btn btn-primary">Filtrar</button>
			</div>
		</form>
	</div>
	<table class="table table-striped table-hover ">
	    <thead>
	        <tr>
	            <th>#</th>
	            <th>Data</th>
	            <th>Tipo da Operação</th>
	            <th>Valor</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="i" items="${transactions}">
		        <tr>
		            <td>${i.getId()}</td>
		            <td>
		            	<fmt:formatDate value="${i.getDate()}" pattern="dd-MM-yyyy" />
		            </td>
		            <c:choose>
					  <c:when test="${i.isOperation()}">
					    <td>Crédito</td>
					    <td><span class="label label-success"> R$: ${i.getValue()} </span></td>
					  </c:when>
					  <c:otherwise>
					    <td>Débito</td>
					  	<td><span class="label label-danger"> R$: ${i.getValue()} </span></td>
					  </c:otherwise>
					 </c:choose>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</div>
	
	<script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/app.js"></script>
</body>
</html>
