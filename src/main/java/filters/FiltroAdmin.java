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
		Boolean isAdmin = (Boolean) httpRequest.getSession().getAttribute("ISADMIN");
		if(isAdmin == null){
            isAdmin = false;
            System.out.println("No existe usuario");
            chain.doFilter(request, response);
        }
		String idAccion = (String) httpRequest.getSession().getAttribute("IDACCION");
		//Obtenemos la accion
		System.out.println(isAdmin);
		if((idAccion == null) || (idAccion.equals("USUARIOS"))){
			if(isAdmin == false){
	            System.out.println("No es admin");
	            request.getRequestDispatcher("WEB-INF/jsp/crudProductos.jsp").forward(request, response);
	        }
			else{
	            System.out.println("Es admin");
	            chain.doFilter(request, response);
	        }
		// pass the request along the filter chain
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
