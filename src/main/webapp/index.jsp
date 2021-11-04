<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Usuario</title>
	<link rel="styleSheet" href="<%= request.getContextPath()%>/CSS/bootstrap.min.css ">
</head>
<body>
	<div class="container"> 
		<div class="row" >
			<div class="mt-4 p-5 bg-primary text-white rounded"><h3>Tienda "La Case"</h3><center><h1>Login Usuario</h1></center></div>
			<div class="mt-4 p-5 ">
				<center>
				<form action="login" method="post">
					<label for="text" class="form-label">Usuario:&nbsp;&nbsp;&nbsp;</label>
					<input type="text" name="usuario"/><br/><br/>
					<label for="pwd" class="form-label">Password:</label>
					<input type="password" name="password"/><br/><br/>
					<center><input type="submit" class="btn btn-primary" name="LOGIN" value="Iniciar Sesión"/></center><br/>
					
				</form>
				<p class="bg-danger text-white">
				<%
				if((String)request.getParameter("val")!=null)
					out.print("Usuario o password incorrectos!... No esta logueado.");
				%> 
				</p> 
				</center>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>