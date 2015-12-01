<%@page import="java.util.HashMap"%>
<jsp:include page="../includes/header.jsp"/>

<jsp:include page="../includes/nav_user.jsp"/>

<div class="row">
  <%	HashMap<String, String> msgs = (HashMap)request.getAttribute("msg");
	  
  	if(msgs != null){
		  for(String key : msgs.keySet()){
	      	String msg = msgs.get(key);		%>
	  	  	<span class="col-md-12 alert alert-<%= key %>"><%= msg %></span>	    
	<% 
	} 
 	%>	  
  <% 
  } 
  %>
</div>

<form method="post" action="<%= request.getContextPath() %>/manager/transaction">
<div class="container col-md-12 row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-success">
		    <div class="panel-heading">
		        <h3 class="panel-title">Busca de Aluno</h3>
		    </div>
		    <div class="panel-body">
		        <div class="form-group">
		    		<label class="control-label" for="ra">RA do Aluno</label>
		    		<input type="text" class="form-control" name="ra" id="ra">
		    		<br/>
		    		<button type="submit" class="btn btn-success search">Buscar</button>
				</div>
	    	</div>
		</div>
	</div>
</div>
</form>
<jsp:include page="../includes/footer.jsp"/>
