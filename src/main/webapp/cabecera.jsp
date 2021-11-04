<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="row" >
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		  <div class="container-fluid">		  	
		  	  <div class="col-sm-11">
		  	  </div>
			  <div class="col-sm-4 right navbar-nav">
			  	<ul class="nav-link active nav justify-content-end ">Usuario: <%= (String)session.getAttribute("username")%>
			  </div>		    
		  </div>		
	</nav>
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="formulario.jsp">Registrar Venta</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ventas.jsp">Total Ventas</a>
	      </li>
	    </ul>
	  </div>
	</nav>	
</div>
