package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter({"/Control", "/control"})
public class FiltroAdmin extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String idAccion = (String) httpRequest.getSession().getAttribute("IDACCION");
		String peticionAccion = (String) httpRequest.getParameter("IDACCION");
		System.out.println("ESTAS EN FILTRO -->" + idAccion + " Peticion --> " + peticionAccion);
		if("USUARIOS".equalsIgnoreCase(idAccion) || "USUARIOS".equalsIgnoreCase(peticionAccion)){
            Boolean isAdmin = (Boolean) httpRequest.getSession().getAttribute("ISADMIN");
            System.out.println("ADMIN -->" + isAdmin);
            if(isAdmin){
                chain.doFilter(request, response);
            }
            else{
                //httpResponse.sendRedirect("WEB-INF/jsp/crudProductos.jsp");
                request.getRequestDispatcher("WEB-INF/jsp/crudProductos.jsp").forward(httpRequest, httpResponse);
                return;
            }
        }
        else{
            chain.doFilter(request, response);
        }
		/*
		Boolean isAdmin = (Boolean) httpRequest.getSession().getAttribute("ISADMIN");
		if(isAdmin == null){
			System.out.println(isAdmin);
            isAdmin = false;
            System.out.println("No existe usuario");
            chain.doFilter(request, response);
        }
        else{
			String idAccion = (String) httpRequest.getSession().getAttribute("IDACCION");
			//Obtenemos la accion
			System.out.println(isAdmin);
			if((idAccion == null) || (idAccion.equals("USUARIOS"))){
				if(isAdmin == false){
		            System.out.println("No es admin");
		            httpResponse.sendRedirect("WEB-INF/jsp/crudProductos.jsp");
		            //request.getRequestDispatcher("WEB-INF/jsp/crudProductos.jsp").forward(httpRequest, httpResponse);
		        }
				else{
		            System.out.println("Es admin");
		            chain.doFilter(request, response);
		        }
			// pass the request along the filter chain
			}
			else{
                chain.doFilter(request, response);
            }
		}
		*/
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
