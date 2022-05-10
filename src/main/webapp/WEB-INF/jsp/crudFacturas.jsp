<%@page import="java.util.Hashtable"%>
<%@page import="pojos.Producto"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facturas</title>
</head>
<body>
	Estas en el CRUD de facturas.<br><br>

<%
Boolean isAdmin = (Boolean) request.getSession().getAttribute("ISADMIN");
String botonUsuarios, botonProductos;
if(isAdmin){
	botonUsuarios = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"USUARIOS\">" +
			"<input type = \"submit\" value = \"Ir a Usuarios\">" +
			"</form>";
	out.println(botonUsuarios + "<br>");
	
	botonProductos = "<form action = \"Control\" method = \"post\">" + 
    		"<input type = \"hidden\" name=\"IDACCION\" value=\"PRODUCTOS\">" +
			"<input type = \"submit\" value = \"Ir a Productos\">" +
			"</form>";
	out.println(botonProductos + "<br>");
	
}

Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
Enumeration productoEnumeration = productos.elements();
%>

<br><h1>Crear factura</h1><br>

</form>
	<input type = "hidden" name="IDACCION" value="UPDATEFACTURA">
	Añadir producto al pedido: <label for="CREATEFACTURA">
    <select name="CREATEFACTURA">
	<%
		while(productoEnumeration.hasMoreElements()){
		    Producto producto = (Producto) productoEnumeration.nextElement();
		    out.println(
		    		"<option value = " + producto.getId() + " " + producto.getNombre() + ">" + producto.getNombre() + "</option>"
            );
		}
	%>
	</select>
	Cantidad: <input type="text" name="STOCK">
	<input type ="submit" value ="Añadir a factura">
</form><br><br>

<%

String msg = (String) request.getSession().getAttribute("MSG");

if((msg != null)){
	out.println(msg + "<br><br>");
}

/*

//Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
String mod = "";
String del = "";

if(isAdmin){
	
	usr - arrayFacturasPropias
	Hashtable<String, ArrayList<Factura>> facturasGlobales = (Hashtable<String, ArrayList<Factura>>) request.getServletContext().getAttribute("FACTURAS");
	
	//Hacemos lista con los keys de facturas globales
	Enumeration facturaEnumeration = facturasGlobales.elements();
	
	//Obtenemos las facturas de cada uno
	while(facturaEnumeration.hasMoreElements()){
		
		ArrayList<Factura> facturasIndividuales = (ArrayList<Factura>) facturaEnumeration.nextElement();
		
		for(int i = 0 ; i < facturasIndividuales.size; i++){
			facturasIndividuales[i].getIdCliente
			
			Factura factura : facturasIndividuales
            /*
            *	factura.getIdProducto + factura.getNombreProducto 
            *
            *	Nombre factura + bucle con todos los productos
            *
            */
            
            
            
            
			out.println(producto.getId() + " " + producto.getNombre());  
		}
		
		
		out.println(username);
		
		//Mostrar facturas del usuario individual
		(for each que recorra arrayfacturasUsuario)
	
	}
	
		
	
	
}
else{
	
    Hashtable<String, Factura> facturasUsuario = (Hashtable<String, Factura>) request.getSession().getAttribute("FACTURASUSUARIO");
	Enumeration facturaUsuarioEnumeration = facturasUsuario.elements();
}



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

*/
/*

out.println("<form method = \"GET\" action = \"HTMLBank\">" + 
    			"<input type = \"text\" name = \"NEWNAME\">" +
    			"<input type = \"submit\" value = \"Modificar\">" +
    			"</form>");
    			
*/

%>




</body>
</html>