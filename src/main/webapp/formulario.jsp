<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--%@page import="com.model.Producto"%-->
    <%@page import="java.util.LinkedList"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
    <!--%@page import="com.beans.ListaProductosSessionLocal"%-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Venta</title>
	<link rel="styleSheet" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css ">
	<!-- js -->
	<script type="text/javascript" src="/ECPCS_2.0/js/jquery/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/ECPCS_2.0/js/jquery/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="/ECPCS_2.0/js/funciones.js"></script>

<!-- ------------------------------------------------------------------------------------------------------------------------ -->
<script>
function ActualizaPrecio() {
	var valor= document.getElementById("producto").value;
	//alert(valor);
	switch(valor){
	case "Leche": document.getElementById("precio").value=5;
				break;
	case "Azucar": document.getElementById("precio").value=4;
				break;
	case "Aceite": document.getElementById("precio").value=18;
				break;
	case "Harina": document.getElementById("precio").value=12;
				break;
	case "Fideo": document.getElementById("precio").value=4;
				break;
	case "Mantequilla": document.getElementById("precio").value=10;
				break;
	case "Detergente": document.getElementById("precio").value=17;
				break;
	case "Cafe": document.getElementById("precio").value=35;
				break;
	case "Servilletas": document.getElementById("precio").value=10;
				break;
	case "Avena Instantanea": document.getElementById("precio").value=18;
				break;
	default:	document.getElementById("precio").value=0;
				break;
	}

}
</script>
	
</head>
<body>
	<div class="container"> 
		
			<%@include file="cabecera.jsp" %>
		<div class="row" >
			<div class="mt-4 p-5 bg-primary text-white rounded"><h3>Tienda "La Case"</h3><center><h1>Formulario de Venta</h1></center></div>
			<div class="mt-14 p-5 ">
				<center>
				<form action="venta" method="post">
					<jsp:useBean id="fecha" class="java.util.Date"/>
					<label for="text" class="form-label">Fecha:&nbsp;&nbsp;&nbsp;</label>
					<input type="text" name="fechaS" value="<%=fecha.toGMTString() %>" readonly="readonly"/>
					<label for="text" class="form-label">NIT Cliente:&nbsp;&nbsp;&nbsp;</label>
					<input type="number" name="nit"/>
					<label for="text" class="form-label">Apellido Cliente:&nbsp;&nbsp;&nbsp;</label>
					<input type="text" name="cliente"/>
					<input type="submit" class="btn btn-primary" name="Registrar" value="Registrar Venta"/><br/>					
				
				</form>
				
				<br/>
				<form action="listaProductos" method="post">
					<label for="text" class="form-label">Producto:&nbsp;&nbsp;&nbsp;</label>
					<select class="select" name="producto" id="producto" onchange="ActualizaPrecio()">	
						    <option value="">Seleccione un producto</option>
						    <option value="Leche">Leche</option>
							<option value="Azucar">Azucar</option>
							<option value="Aceite">Aceite</option>
							<option value="Harina">Harina</option>
							<option value="Fideo">Fideo</option>
							<option value="Mantequilla">Mantequilla</option>
							<option value="Detergente">Detergente</option>
							<option value="Cafe">Cafe</option>
							<option value="Servilletas">Servilletas</option>
							<option value="Avena Instantanea">Avena Instantanea</option>
					</select>
					<label for="text" class="form-label">Precio:</label>
					<input type="number" name="precio" id="precio" placeholder="0" readonly="readonly"/>
					<label for="text" class="form-label">Cantidad:</label>
					<input type="number" name="cantidad"/>
					<input type="submit" class="btn btn-success" name="agregarProd" value="Agregar"/><br/>					
				</form>				
				</center>
				<div class="container mt-3">
				  <h2>Productos seleccionados</h2>
				  <table class="table table-bordered">
				    <thead>
				      <tr>
				        <th>Producto</th>
				        <th>Precio Unitario</th>
				        <th>Cantidad</th>
				        <th>Sub Total</th>
				      </tr>
				    </thead>
                                   <%
                                    if(request.getParameter("t")!=null)
					out.print((String)request.getParameter("t"));
                                    %>
				    
				  </table>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>


</body>
</html>