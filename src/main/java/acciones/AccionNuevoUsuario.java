package acciones;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Usuario;

public class AccionNuevoUsuario extends Accion{

	public AccionNuevoUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newUsername = (String) request.getParameter("NEWUSERNAME");
		String newPass = (String) request.getParameter("NEWPASS");
		String State = (String) request.getParameter("STATE"); // on/null -- checked/no checked
		
		
		Hashtable<String, Usuario> usuarios = (Hashtable<String, Usuario>) request.getServletContext().getAttribute("USUARIOS");
		
		if(newUsername != null && newPass != null) {
			
			if(usuarios.containsKey(newUsername)) {
				request.getSession().setAttribute("MSG", "Nombre ya existente.");
				
			}
			else {
				
				if(State != null) {
					usuarios.put(newUsername, new Usuario(newUsername, newPass, true));
					request.getSession().setAttribute("MSG", "Usuario Admin Creado");
					
				}else {

					usuarios.put(newUsername, new Usuario(newUsername, newPass));
					request.getSession().setAttribute("MSG", "Usuario Creado");
					
					
				}
				
			}
			
		}
		else {
			request.getSession().setAttribute("MSG", "Usuario NO Creado");
			
		}
		return "crudUsuarios.jsp";
		
	}

}
