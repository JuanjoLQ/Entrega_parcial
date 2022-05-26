package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Factura;
import pojos.Producto;

public class AccionNuevoProductoFacturas extends Accion{

	public AccionNuevoProductoFacturas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String addProductoFactura= (String) request.getParameter("ADDPRODUCTOFACTURA");
		String idFactura = (String) request.getParameter("IDFACTURA");
		
		Hashtable<String, Factura> facturas = (Hashtable<String, Factura>) request.getServletContext().getAttribute("FACTURAS");
		Hashtable<String, Producto> productos = (Hashtable<String, Producto>) request.getServletContext().getAttribute("PRODUCTOS");
		
		
		Factura factura = facturas.get(idFactura);
		
		if(factura.getProductos().containsKey(addProductoFactura)){
			//añadir stock
			factura.getProductos().get(addProductoFactura).addStock();
		}
		else{
			//añadir producto
			factura.addProducto(productos.get(addProductoFactura));
			factura.getProductos().get(addProductoFactura).setStock(1);
		}
		
		request.getServletContext().setAttribute("FACTURAS", facturas);
		request.setAttribute("MSG", "Producto insertado correctamente.");
		
		return "crudFacturas.jsp";
	}

}
