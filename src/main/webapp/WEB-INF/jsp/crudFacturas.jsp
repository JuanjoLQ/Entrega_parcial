<%@page import="pojos.Usuario"%>
<%@page import="pojos.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Hashtable"%>
<%@page import="pojos.Producto"%>
<%@page import="java.util.Enumeration"%>
<%@ taglib uri="mistags" prefix="dad" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facturas</title>
</head>
<body>
	<dad:lugar nombre="Facturas"/>

<%
Boolean isAdmin = (Boolean) request.getSession().getAttribute("ISADMIN");
String botonUsuarios, botonProductos;
if(isAdmin){
	botonUsuarios = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"USUARIOS\">" +
			"<input type = \"submit\" value = \"Ir a Usuarios\">" +
			"</form>";
	out.println(botonUsuarios + "<br>");
}	
botonProductos = "<form action = \"Control\" method = \"post\">" + 
   		"<input type = \"hidden\" name=\"IDACCION\" value=\"PRODUCTOS\">" +
		"<input type = \"submit\" value = \"Ir a Productos\">" +
		"</form>";
out.println(botonProductos + "<br>");



Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
Enumeration productoEnumeration = productos.elements();

Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
Enumeration usuarioEnumeration = usuarios.elements();
%>

<br><h2>Crear factura</h2><br>

<form action = "Control" method = "post">
	<input type = "hidden" name="IDACCION" value="NEWFACTURA">
	Selecciona el usuario asociado a la factura: <label for="CREATEFACTURA">
    <select name="CREATEFACTURA">
	<%
		while(usuarioEnumeration.hasMoreElements()){
		    Usuario usuario = (Usuario) usuarioEnumeration.nextElement();
		    out.println("<option value = " + usuario.getUsername() + ">" + usuario.getUsername() + "</option>");
		}
	%>
	</select>
	<input type ="submit" value ="Crear nueva factura">
</form><br><br>

<%

String msg = (String) request.getSession().getAttribute("MSG");

if((msg != null)){
	out.println(msg + "<br><br>");
}



//Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
String mod = "";
String deleteFactura = "", deleteProducto = "";


	
out.println("<h2>Listado de productos</h2>");

Hashtable<String, Factura> facturas= (Hashtable<String, Factura>) request.getServletContext().getAttribute("FACTURAS");
Enumeration listaFacturas = facturas.elements();
String ini = "", end = "";

while(listaFacturas.hasMoreElements()){
    Factura factura = (Factura) listaFacturas.nextElement();
    
	deleteFactura = " [<a href = \"Control?IDACCION=ELIMINARFACTURA&IDFACTURA=" + factura.getId() +"\">Borrar factura</a>]";
	out.println("<br><br><b>ID: " + factura.getId() + "</b>" + deleteFactura);
	Hashtable<String, Producto> productosUsuario = factura.getProductos();
    Enumeration listaProductosUsuario = productosUsuario.elements();
    
	while(listaProductosUsuario.hasMoreElements()){
        Producto producto = (Producto) listaProductosUsuario.nextElement();
		deleteProducto = " [<a href = \"Control?IDACCION=ELIMINARPRODUCTOFACTURA&IDFACTURA=" + factura.getId() + "&DELETENAME=" + producto.getId() +"\">Borrar producto</a>]";
		out.println("<br>" + producto.getId() + " - " + producto.getNombre()+ " - " + producto.getStock() + deleteProducto);
		
	}
	
	ini = "<form action = \"Control\" method = \"post\">" +
		"<input type = \"hidden\" name=\"IDACCION\" value=\"NEWPRODUCTOFACTURA\">" +
		"<input type = \"hidden\" name=\"IDFACTURA\" value=" + factura.getId() + ">" +
		"Producto a añadir: " + "<label for = \"ADDPRODUCTOFACTURA\">" +
		"<select name = \"ADDPRODUCTOFACTURA\">";
    end = "</select>" +
		"<input type =\"submit\" value =\"Añadir producto\">" +
		"</form>";
		
    out.println(ini);
	while(productoEnumeration.hasMoreElements()){
	    Producto producto = (Producto) productoEnumeration.nextElement();
	    out.println("<option value = " + producto.getId() + ">" + producto.getNombre() + "</option>");
	}
	out.println(end);
	
}

/*

while(facturaEnumeration.hasMoreElements()){
    Factura factura = (Factura) facturaEnumeration.nextElement();
    
    del = " [<a href = \"Control?IDACCION=ELIMINAR&DELETENAME=" + producto.getId() +"\">Borrar</a>]";
    mod = "<form action = \"Control\" method = \"post\">" + 
        		"<input type = \"hidden\" name=\"IDACCION\" value=\"UPDATE\">" +
    			"<input type = \"hidden\" name = \"UPDATEID\" value = " + producto.getId() + ">" +
    			"Nombre: " + "<input type = \"text\" name = \"UPDATENAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>";
    out.println(producto.getId() + " " + factura.getNombre() + del + mod + "<br>"); 
    
}



for(Producto producto : productoEnumeration.nextElement()){
	
	out.println(producto.getId() + " " + producto.getNombre());  
	
}



/*
out.println("<form method = \"GET\" action = \"HTMLBank\">" + 
    			"<input type = \"text\" name = \"NEWNAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>");
    			
*/

%>




</body>
</html>