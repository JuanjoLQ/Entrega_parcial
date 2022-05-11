package acciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Factura;
import pojos.Producto;

public class AccionBorrarProductosFacturas extends Accion{

	public AccionBorrarProductosFacturas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		String idFactura = (String) request.getParameter("IDFACTURA");
		String deleteName = (String) request.getParameter("DELETENAME");
		
		Hashtable<String, Factura> facturas= (Hashtable<String, Factura>) request.getServletContext().getAttribute("FACTURAS");
		
		if(facturas.containsKey(idFactura)) {
			
			Factura factura = facturas.get(idFactura);
			
			factura.removeProducto(deleteName);

			request.getServletContext().setAttribute("FACTURAS", facturas);
			request.getSession().setAttribute("MSG", "Producto eliminado.");
			
		}
		else {
			request.getSession().setAttribute("MSG", "Producto NO eliminado.");
		}
		
		/*
		for(Factura factura : facturas){
			if(factura.getId().equals(idFactura)){
				ArrayList<Producto> productos = factura.getProductos();
				for(Producto producto : productos){
					if(producto.getId().equals(deleteName)) {
						productos.remove(producto);
						//productos.remove(productos.indexOf(deleteName));
						request.getServletContext().setAttribute("FACTURAS", facturas);
						request.getSession().setAttribute("MSG", "Producto eliminado");
						return "crudFacturas.jsp";
					}
				}
			}
		}
		*/
		return "crudFacturas.jsp";
	}

}
