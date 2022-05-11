package acciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Factura;

public class AccionBorrarFacturas extends Accion{

	public AccionBorrarFacturas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idFactura = (String) request.getParameter("IDFACTURA");
		
		Hashtable<String, Factura> facturas= (Hashtable<String, Factura>) request.getServletContext().getAttribute("FACTURAS");
		//No se debe de cambiar esta parte
		if(facturas.containsKey(idFactura)) {
			
			facturas.remove(idFactura);
			
			request.getServletContext().setAttribute("FACTURAS", facturas);
			request.getSession().setAttribute("MSG", "Factura eliminada.");
			
		}
		else {
			request.getSession().setAttribute("MSG", "Factura NO eliminada.");
		}
		return "crudFacturas.jsp";
	}

}
