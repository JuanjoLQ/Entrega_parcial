<%@page import="java.util.Hashtable"%>
<%@page import="pojos.Usuario"%>
<%@page import="java.util.Enumeration"%>
<%@ taglib uri="mistags" prefix="dad" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<dad:lugar nombre="Usuarios"/>


<br><form action="Control" method="post">

	<input type = "hidden" name="IDACCION" value="NEWUSER">
	Nombre del usuario: <input type="text" name="NEWUSERNAME">
	Contraseña del usuario: <input type="text" name="NEWPASS">
	¿Admin?<input type="checkbox" name="STATE">
	<input type ="submit" value ="Crear">
</form><br><br>



<%

Boolean isAdmin = (Boolean) request.getSession().getAttribute("ISADMIN");
String botonProductos, botonFacturas;
if(isAdmin){
	botonProductos = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"PRODUCTOS\">" +
			"<input type = \"submit\" value = \"Ir a Productos\">" +
			"</form>";
	out.println(botonProductos + "<br>");
	
}

botonFacturas = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"FACTURAS\">" +
			"<input type = \"submit\" value = \"Ir a Facturas\">" +
			"</form>";
	out.println(botonFacturas + "<br>");

String msg = (String) request.getSession().getAttribute("MSG");

if((msg != null)){
	out.println(msg + "<br><br>");
}

//Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
String mod = "";
String del = "";
Hashtable <String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
Enumeration usuarioEnumeration = usuarios.elements();


while(usuarioEnumeration.hasMoreElements()){
    Usuario usuario = (Usuario) usuarioEnumeration.nextElement();
    
    del = " [<a href = \"Control?IDACCION=ELIMINARUSER&DELETEUSER=" + usuario.getUsername() +"\">Borrar</a>]";
    mod = "<form action = \"Control\" method = \"post\">" + 
        		"<input type = \"hidden\" name=\"IDACCION\" value=\"UPDATEUSER\">" +
    			"<input type = \"hidden\" name = \"UPDATEUSERNAME\" value = " + usuario.getUsername() + ">" +
    			//"Username: " + "<input type = \"text\" required name = \"UPDATEUSERNAME\">" +
    			"Contraseña: " + "<input type = \"text\" required name = \"UPDATEPASS\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>";
    out.println(usuario.getUsername() + " " + usuario.getPass() + " " + usuario.getAdmin() + " " + del + mod + "<br>"); 
    
}


/*
for(Producto producto : productoEnumeration.nextElement()){
	
	out.println(producto.getId() + " " + producto.getNombre());  
	
}

out.println("<form method = \"GET\" action = \"HTMLBank\">" + 
    			"<input type = \"text\" name = \"NEWNAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>");
*/

%>

</body>
</html>