package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Producto;

public class AccionBorrarProductos extends Accion{

	public AccionBorrarProductos() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteName = (String) request.getParameter("DELETENAME");
		
		Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		if(productos.containsKey(deleteName)) {
			productos.remove(deleteName);
			request.setAttribute("MSG", "Producto eliminado");
		}
		else {
			request.setAttribute("MSG", "Producto NO eliminado");
		}
		
		return "crudProductos.jsp";
	}

}
