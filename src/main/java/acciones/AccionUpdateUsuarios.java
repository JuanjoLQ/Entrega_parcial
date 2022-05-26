package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Usuario;

public class AccionUpdateUsuarios extends Accion{

	public AccionUpdateUsuarios() {
		
		
		
		
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String updateUser = (String) request.getParameter("UPDATEUSERNAME");
		String updatePass = (String) request.getParameter("UPDATEPASS");
		String updateAdmin = (String) request.getParameter("UPDATEADMIN");
		
		
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		System.out.println("Esto que es -->" + updateAdmin);
		if(usuarios.containsKey(updateUser)) {
			if(updateAdmin.equalsIgnoreCase("true")) {
				usuarios.replace(updateUser, new Usuario(updateUser, updatePass, true));
			}
			else {
				usuarios.replace(updateUser, new Usuario(updateUser, updatePass));
			}
			
			
			request.setAttribute("MSG", "Usuario modificado");
		}
		else {
			request.setAttribute("MSG", "Usuario NO modificado");
		}
		
		return "crudUsuarios.jsp";
	}

}
