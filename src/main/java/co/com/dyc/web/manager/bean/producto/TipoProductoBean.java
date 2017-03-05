/**
 * 
 */
package co.com.dyc.web.manager.bean.producto;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import co.com.dyc.utils.LogUtils;
import co.com.dyc.web.entities.producto.TipoProducto;
import co.com.dyc.web.manager.bean.IManagerBean;
import co.com.dyc.web.manager.bean.IManagerBeanTableEdit;
import co.com.dyc.web.service.producto.TipoProductoService;

/**
 * @author arestrepoh
 *
 */
@Named
@ManagedBean(name="tipoProductoMB")
@ViewScoped
public class TipoProductoBean implements IManagerBean,Serializable{

	private static final long serialVersionUID = -5485649513725430553L;
	
	private TipoProducto tipoProducto;
	
	@ManagedProperty("#{tipoProductoService}")
	private TipoProductoService tipoProductoService;
	
	public void guardar(){
		try{
			tipoProductoService.save(tipoProducto);	
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Successful",  "Tipo Producto Guardado" ) );
		}catch(Exception e){
			LogUtils.logErrorMessage(this.getClass(), e, "0", "Error al guardar");
		}
		
	}
	
	public TipoProductoService getTipoProductoService() {
		return tipoProductoService;
	}
	public void setTipoProductoService(TipoProductoService tipoProductoService) {
		this.tipoProductoService = tipoProductoService;
	}
	/**
	 * @return the tipoProducto
	 */
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	@Override
	public void init() {
			tipoProducto = new TipoProducto();
	}
	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	
}
