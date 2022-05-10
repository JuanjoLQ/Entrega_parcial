package pojos;

import java.util.Hashtable;

public class Factura {

	private String id;
	private Hashtable<String, Producto> productos = null;

	public Factura() {
		
	}
	
	public Factura(String id, Hashtable<String, Producto> productos) {
		this.productos = productos;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProductos(Hashtable<String, Producto> productos) {
		this.productos = productos;
	}

	public Hashtable<String, Producto> getProductos(){
		return this.productos;
	}
	
	public void addProducto(Producto producto) {
		this.productos.put(producto.getId(), producto);
	}
	
	public void removeProducto(Producto producto) {
		this.productos.remove(producto.getId());
	}
}
