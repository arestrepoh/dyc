/**
 * 
 */
package co.com.dyc.web.manager.bean.seguridad;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.dyc.utils.ConstantesUtils;
import co.com.dyc.utils.WebUtils;
import co.com.dyc.web.entities.seguridad.Usuario;
import co.com.dyc.web.service.seguridad.UsuarioService;

/**
 * @author Kero
 *
 */
@Named
@ManagedBean(name="login")
@ViewScoped
public class LoginManager implements Serializable {

	private static final long serialVersionUID = -4482141130385374467L;

	@ManagedProperty("#{usuario}")
	private Usuario usuario;
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init(){
	}
	
	public String iniciarSession(){
		String redireccion = null;
		try{
			Usuario usuarioLogueado = usuarioService.iniciarSession(usuario.getId(), usuario.getPassword());
			if(usuarioLogueado  != null){
			//	Almacenar en la session
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ConstantesUtils.VARIABLE_SESSION_USUARIO, usuarioLogueado);
				redireccion = "home.xhtml";
			}else{
				WebUtils.warnMessage(null,"Aviso", "Credenciales Incorrectas!!!!");
			}
		}catch(Exception e){
			WebUtils.fatalMessage(null,"Error", "Se a prensentado un error en la aplicación, por favor contacte al Administrador.");
		}
		return redireccion;
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the usuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
