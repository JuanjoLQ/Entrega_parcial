package acciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Factura;
import pojos.Producto;
import pojos.Usuario;

public class AccionNuevoFacturas extends Accion{

	private ArrayList<Producto> productos = new ArrayList<Producto>();

	public AccionNuevoFacturas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String []newFactura = (String[]) request.getParameter("CREATEFACTURA").split(" ");
		String newStock = (String) request.getParameter("STOCK");
		
		Hashtable<String, ArrayList<Factura>> facturasGlobales = (Hashtable<String, ArrayList<Factura>>) request.getServletContext().getAttribute("FACTURAS");
		
		ArrayList<Factura> facturasUsuario = (ArrayList<Factura>) request.getSession().getAttribute("FACTURASUSUARIO");
		
		if(newFactura != null && newStock != null) {
			Usuario user = (Usuario) request.getSession().getAttribute("USUARIO");
			String nombre = user.getUsername();
			
			productos.add(new Producto(newFactura[0], newFactura[1]));
			
			Factura facturaNueva = new Factura(nombre + "_" + (facturasUsuario.size() + 1), productos);
			
			facturasUsuario.add(facturaNueva);
			
			facturasGlobales.replace(nombre, facturasUsuario);
			
			request.getSession().setAttribute("FACTURASUSUARIO", facturasUsuario);
			request.getServletContext().setAttribute("FACTURAS", facturasGlobales);
			
			request.getSession().setAttribute("MSG", "Factura Creada");
			
		}
		else {
			request.getSession().setAttribute("MSG", "Factura NO Creada");
		}
		return "crudFacturas.jsp";
	}

}
