<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/nav_admin.jsp"/>

<div class="container">
<div class="col-md-12">
	<div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title">Transação</h3>
    </div>
    <div class="panel-body">
        <form method="post" action="<%= request.getContextPath() %>/manager/register-transaction">
        	<div class="form-group col-md-6">
   			 	<label class="control-label" for="disabledInput">RA</label>
    		 	<input class="form-control" id="ra" type="text" value="${login}" placeholder="Ra" disabled>
    		 	<input type="hidden" id="city" name="customer_id" value="${id}">
			</div>
			<div class="form-group col-md-6">
   			 	<label class="control-label" for="disabledInput">Foto</label>
    		 	<div><img src="img/img.svg" alt="..." class="img-rounded"></div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group col-md-6">
   			 	<label class="control-label" for="disabledInput">Nome</label>
    		 	<input class="form-control" id="name" type="text" value="${name}" placeholder="Nome" disabled>
			</div>
			<div class="clearfix"></div>
			<div class="form-group col-md-4">
    			<label class="control-label">Saldo</label>
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<input type="text" id="balance" value="${value}" class="form-control" disabled>
    			</div>
			</div>
			
			<div class="form-group col-md-4">
            <label class="control-label">Operação</label>
        		<div class="radio radio-primary col-md-12">
                    <label>
                        <input type="radio" name="operation" id="type" value="true" checked="">
                        Débito
                    </label>
                    <label>
                        <input type="radio" name="operation" id="type" value="false">
                        Crédito
                    </label>
                </div>
   			</div>          
			<div class="clearfix"></div>
			<div class="form-group col-md-4">
    			<label class="control-label">Valor</label>
    			<div class="input-group">
        			<span class="input-group-addon">R$</span>
        			<input type="text" name="value" id="value" data-thousands="." data-decimal="," class="form-control">
        		<span class="input-group-btn">
            		<button class="btn btn-primary" type="submit">Finalizar</button>
       		 	</span>
    			</div>
			</div>
        </form>
    </div>
</div>
	
	
</div>

<jsp:include page="../includes/footer.jsp"/>