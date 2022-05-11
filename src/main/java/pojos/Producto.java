package pojos;

public class Producto {
	
	private String id = "";
	private String nombre = "";
	private int stock = 1;
	
	public Producto(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void addStock(){
		this.stock++;
	}
	
	public void subStock(){
		this.stock--;
	}

}
