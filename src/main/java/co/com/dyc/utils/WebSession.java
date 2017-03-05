/**
 * 
 */
package co.com.dyc.utils;

import java.io.IOException;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import co.com.dyc.web.entities.seguridad.Usuario;

/**
 * @author Kero
 *
 */
@SessionScoped
public class WebSession {

	public static boolean isSessionActive(){
		Usuario usuarioSession = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ConstantesUtils.VARIABLE_SESSION_USUARIO);
		return usuarioSession != null;
	}
	
	public static Usuario getUsuario(){
		return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ConstantesUtils.VARIABLE_SESSION_USUARIO);
	}
	
	public static void eliminarSesio(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public static String getUri(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request.getRequestURI();
	}
	
	public static void redireccionar(String page) throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(page);
	}

	public static String contextPath(){
		return ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getContextPath();
	}
}
