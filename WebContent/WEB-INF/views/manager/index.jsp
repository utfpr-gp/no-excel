<jsp:include page="../includes/header.jsp"/>

<jsp:include page="../includes/nav_user.jsp"/>

<form method="post" action="<%= request.getContextPath() %>/manager/transaction">
<div class="container col-md-12 row">
	<div class="panel panel-primary col-md-8 col-md-offset-2">
    <div class="panel-heading">
        <h3 class="panel-title">Busca de Aluno</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
    <label class="control-label" for="ra">RA do Aluno</label>
    <input type="text" class="form-control" name="ra" id="ra">
    <button type="submit" class="btn btn-primary search">Buscar</button>
</div>
    </div>
</div>
</div>
</form>
<jsp:include page="../includes/footer.jsp"/>
