package listener;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import acciones.Accion;
import acciones.AccionBorrar;
import acciones.AccionBorrarFacturas;
import acciones.AccionBorrarUsuarios;
import acciones.AccionFacturas;
import acciones.AccionLogin;
import acciones.AccionNuevo;
import acciones.AccionNuevoFacturas;
import acciones.AccionNuevoUsuario;
import acciones.AccionProductos;
import acciones.AccionUpdate;
import acciones.AccionUpdateFacturas;
import acciones.AccionUpdateUsuarios;
import acciones.AccionUsuarios;
import pojos.Producto;
import pojos.Usuario;
import pojos.Factura;

/**
 * Application Lifecycle Listener implementation class ListenerInicio
 *
 */
@WebListener
public class ListenerInicio implements ServletContextListener {
	
	private Hashtable<String, Usuario> usuarios = null;
	private Hashtable<String, Producto> productos = null;
	private Hashtable<String, ArrayList<Factura>> facturas = null;
	private Hashtable<String, Accion> acciones = null;
	
    /**
     * Default constructor. 
     */
    public ListenerInicio() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	this.usuarios = new Hashtable<String, Usuario>();
    	this.acciones = new Hashtable<String, Accion>();
    	this.productos = new Hashtable<String, Producto>();
    	this.facturas = new Hashtable<String, ArrayList<Factura>>();
    	
    	this.usuarios.put("admin", new Usuario("admin", "admin", true));
    	this.usuarios.put("Juanjo", new Usuario("Juanjo", "1234"));
    	
    	this.acciones.put("LOGIN", new AccionLogin());
    	this.acciones.put("USUARIOS", new AccionUsuarios());
    	this.acciones.put("PRODUCTOS", new AccionProductos());
    	this.acciones.put("FACTURAS", new AccionFacturas());
    	this.acciones.put("NEW", new AccionNuevo());
    	this.acciones.put("NEWUSER", new AccionNuevoUsuario());
    	this.acciones.put("NEWFACTURA", new AccionNuevoFacturas());
    	this.acciones.put("ELIMINAR", new AccionBorrar());
    	this.acciones.put("ELIMINARUSER", new AccionBorrarUsuarios());
    	this.acciones.put("ELIMINARFACTURA", new AccionBorrarFacturas());
    	this.acciones.put("UPDATE", new AccionUpdate());
    	this.acciones.put("UPDATEUSER", new AccionUpdateUsuarios());
    	this.acciones.put("UPDATEFACTURA", new AccionUpdateFacturas());
    	
    	this.productos.put("1", new Producto("1", "Manzana"));
    	this.productos.put("2", new Producto("2", "Mandarina"));
    	this.productos.put("3", new Producto("3", "Pera"));
    	this.productos.put("4", new Producto("4", "Platano"));
    	this.productos.put("5", new Producto("5", "Kiwi"));
    	this.productos.put("6", new Producto("6", "Mango"));
    	
    	ArrayList<Producto> productos = new ArrayList<Producto>();
    	productos.add(new Producto("1", "Manzana"));
    	productos.add(new Producto("4", "Platano"));
    	productos.add(new Producto("5", "Kiwi"));
    	
    	Factura factura = new Factura("admin_1", productos);
    	
    	ArrayList<Producto> productos2 = new ArrayList<Producto>();
    	productos2.add(new Producto("2", "Mandarina"));
    	productos2.add(new Producto("6", "Mango"));
    	productos2.add(new Producto("4", "Platano"));
    	
    	Factura factura2 = new Factura("Juanjo_1", productos2);
    	ArrayList<Factura> facturasUsuario = new ArrayList<Factura>();
    	facturasUsuario.add(factura);
    	ArrayList<Factura> facturasUsuario2 = new ArrayList<Factura>();
    	facturasUsuario2.add(factura2);
    	facturas.put("admin", facturasUsuario);
    	facturas.put("Juanjo", facturasUsuario2);
    	
    	sce.getServletContext().setAttribute("PRODUCTOS", this.productos);
    	sce.getServletContext().setAttribute("USUARIOS", this.usuarios);
    	sce.getServletContext().setAttribute("FACTURAS", this.facturas);
    	sce.getServletContext().setAttribute("ACCIONES", this.acciones);
    	
         System.out.println("Estas en el listener");
    }
	
}
