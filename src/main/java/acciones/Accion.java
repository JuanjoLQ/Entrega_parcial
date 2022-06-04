package acciones;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.servlet.context.ServletUtil;

import java.io.IOException;
import javax.servlet.ServletException;

public abstract class Accion {

	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
