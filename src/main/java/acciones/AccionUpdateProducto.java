package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Producto;

public class AccionUpdateProducto extends Accion{

	public AccionUpdateProducto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String updateId = (String) request.getParameter("UPDATEID");
		String updateName = (String) request.getParameter("UPDATENAME");
		
		
		Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		if(productos.containsKey(updateId)) {
			productos.replace(updateId, new Producto(updateId, updateName));
			request.setAttribute("MSG", "Producto modificado");
		}
		else {
			request.setAttribute("MSG", "Producto NO modificado");
		}
		
		return "crudProductos.jsp";
	}

}
