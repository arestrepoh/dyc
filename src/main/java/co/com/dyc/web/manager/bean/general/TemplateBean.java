/**
 * 
 */
package co.com.dyc.web.manager.bean.general;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;

import co.com.dyc.utils.LogUtils;
import co.com.dyc.utils.WebSession;

/**
 * @author Kero
 *
 */
@Named
@ManagedBean(name="templateMB")
@ViewScoped
public class TemplateBean implements Serializable {
	
	private static final long serialVersionUID = -4902034734988746274L;

	public String verificarSession(){
		String redireccion = "";
		try{			
			if(!WebSession.isSessionActive()){
				String ctxPath = 
					      ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getContextPath();
				redireccion = "/index.xhtml"; 
				WebSession.redireccionar(ctxPath + redireccion);
			}
		}catch(Exception e){
			LogUtils.logErrorMessage(this.getClass(),e, null, e.getMessage());
		}
		return redireccion;
	}
}
