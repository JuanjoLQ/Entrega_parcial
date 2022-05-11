package pojos;

import java.util.ArrayList;

public class Factura {

	private String id = "";
	private ArrayList<Producto> productos = null;

	public Factura() {
		
	}
	
	public Factura(String id, ArrayList<Producto> productos) {
		this.id = id;
		this.productos = productos;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Producto> getProductos(){
		return this.productos;
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
	}
}
