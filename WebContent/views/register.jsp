<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

<div class="navbar navbar-noexcel">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:void(0)"><img alt="NoExcel" src="<%= request.getContextPath() %>/img/noexcel.png" class="logo"></a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="login.jsp"> <span class="glyphicon mdi-action-home"></span> Início</a></li>
        </ul>
    </div>
</div>

<div class="container row col-md-12">
	<c:forEach var="entry" items="${flashMessage}">
		<div class="alert alert-dismissable alert-${flashType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
	    		<strong>${entry.key}</strong> ${entry.value}.
		</div>
	</c:forEach>
	<div class="col-md-8 col-md-offset-2">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Cadastro no sistema</h3>
        </div>
        <div class="panel-body">
	        <div class="col-md-12">
	            <form action="<%= request.getContextPath() %>/register" method="post" class="form-customer">
	                <div class="form-group col-md-6">
	                    <label class="control-label">RA ou CPF (Para público externo)</label>
	                    <input class="form-control" name="login" type="text" placeholder="Login (Ra)" required autofocus>
	                </div>
	                <div class="form-group col-md-6">	
	                    <label for="select" class="form-group control-label">Tipo de Pessoa</label>
	                    <div class="form-group">
	                        <select class="form-control" name="type" required>
	                            <option value="">Tipo de Cliente</option>
	                            <option value="Aluno">Aluno</option>
	                            <option value="Professor">Professor</option>
	                            <option value="Servidor">Técnico</option>
	                            <option value="Externo">Público Externo</option>
	                        </select>	
	                    </div>
	                </div>
	                <div class="form-group col-md-6">
	                    <label class="control-label">Nome Completo</label>
	                    <input class="form-control" name="name" type="text" placeholder="Nome" required>
	                </div>
	                <div class="form-group col-md-6">
	                    <label class="control-label">Senha</label>
	                    <input class="form-control" name="password" type="password" placeholder="Senha" required>
	                </div>
	                <div class="form-group col-md-12">
	                    <label class="control-label">Email</label>
	                    <input class="form-control" name="email" type="email" placeholder="email" required>
	                </div>
	                <div class="form-group col-md-6" name="showColleger">
	                    <label class="form-group">Bolsista</label>
	                    <div class="form-group">
	                        <div class="radio radio-primary">
	                            <label>
	                                <input type="radio" name="colleger" value="yes">Sim	
	                            </label>
	                        </div>
	                        <div class="radio radio-primary">
	                            <label>
	                                <input type="radio" name="colleger" value="no" checked="">Não
	                            </label>
	                        </div>
	                    </div>
	                </div>
	                <div class="clearfix"></div>
	                <div class="input-group-btn submit">
	                	<button class="btn btn-primary pull-right" type="submit">Salvar</button>
	                	<a href="login.jsp"><button class="btn btn-warning pull-left" type="button">Voltar</button></a>
	                </div>
	            </form>
            </div>
        </div>
    </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/customer.js"></script>