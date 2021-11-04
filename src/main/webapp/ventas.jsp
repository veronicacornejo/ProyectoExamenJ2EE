<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="com.model.Producto"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.beans.ListaProductosSessionLocal"%>
<%@page import="com.beans.ListaVentaSessionLocal"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Reporte de Ventas</title>
        <link rel="styleSheet" href="<%= request.getContextPath()%>/CSS/bootstrap.min.css ">
    </head>
    <body>
        <div class="container"> 

            <%@include file="cabecera.jsp" %>
            <div class="row" >
                <div class="mt-4 p-5 bg-primary text-white rounded"><h3>Tienda "La Case"</h3><center><h1>Reporte de Ventas</h1></center></div>
                <div class="mt-4 p-5 ">
                    <center>
                        <div class="container mt-3">
                            <h3>Ventas</h3>
                            
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Fecha</th>
                                        <th>NIT</th>
                                        <th>Apellido</th>
                                        <th>Producto</th>
                                        <th>Precio Unitario</th>
                                        <th>Cantidad</th>
                                        <th>Sub Total</th>
                                    </tr>
                                </thead>
                               <%if((String)request.getSession().getServletContext().getAttribute("listaV")!=null)%>
                                 <%= (String)request.getSession().getServletContext().getAttribute("listaV")%>
                                 
                            </table>
                        </div>
                    </center>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </body>
</html>