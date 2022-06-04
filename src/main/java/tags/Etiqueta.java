package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class Etiqueta extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String nombre;
	
	public int doStartTag() throws JspException {
        try{
            if (nombre != null) {
            	
                pageContext.getOut().print("Te encuentras en: " + nombre);
            
            }
        } catch (IOException e) {
            throw new JspException ("Error: IOException" + e.getMessage());
        }
        return  SKIP_BODY;
    }
	
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	

}
