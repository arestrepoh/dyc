/**
 * 
 */
package co.com.dyc.web.manager.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

/**
 * @author Kero
 *
 */
public abstract class AbstractBean  {

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected",  event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
