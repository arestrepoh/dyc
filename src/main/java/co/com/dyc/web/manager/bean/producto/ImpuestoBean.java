package co.com.dyc.web.manager.bean.producto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.WebUtils;
import co.com.dyc.web.entities.general.Estado;
import co.com.dyc.web.entities.producto.Impuesto;
import co.com.dyc.web.manager.bean.IManagerBean;
import co.com.dyc.web.service.producto.ImpuestoService;

/**
 * @author Kero
 *
 */
@ManagedBean(name = "impMB")
@ViewScoped
public class ImpuestoBean implements IManagerBean, Serializable {

	private static final long serialVersionUID = 6187710787618739301L;
	
	private Impuesto impuesto;
	private ArrayList<Impuesto> impuestos;
	
	private String descrip;
	
	@ManagedProperty("#{impuestoService}")
	private ImpuestoService impuestoService;

	public ImpuestoBean() {
	}
	
	@PostConstruct
	public void init() {
		impuestos = new ArrayList<>();
		nuevo();
		this.load();
	}

	@Override
	public void load() {
		try {
			impuestos = impuestoService.getAll();
		} catch (DAOException e) {
			WebUtils.fatalMessage(null, "Cargar Categorias",
					"Se presento un error al cargar los datos.");
		}
	}

	@Override
	public String add() {
		nuevo();
		resetDataGrid();
		return null;
	}

	@Override
	public String save() {
		try {
			getDescrip();
			if (impuestoService.save(impuesto)) {
				WebUtils.infoMessage(null, "impuestos",
						"Datos guardados correctamente.");
				this.load();
				resetDataGrid();
				nuevo();
			}
		} catch (DAOException | ServiceException e) {
			WebUtils.errorMessage(null, "Guardar", e.getMessage());
		}
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
	
	public void onRowSelect(SelectEvent event) {
		resetDataGrid();
//		setNuevoReg(false);
	}

	/**
	 * @return the impuesto
	 */
	public Impuesto getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the impuestos
	 */
	public ArrayList<Impuesto> getImpuestos() {
		return impuestos;
	}

	/**
	 * @param impuestos the impuestos to set
	 */
	public void setImpuestos(ArrayList<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	/**
	 * @return the impuestoService
	 */
	public ImpuestoService getImpuestoService() {
		return impuestoService;
	}

	/**
	 * @param impuestoService the impuestoService to set
	 */
	public void setImpuestoService(ImpuestoService impuestoService) {
		this.impuestoService = impuestoService;
	}

	private void nuevo(){
		impuesto = new Impuesto();
		impuesto.setEstado(Estado.ACTIVO);
	}
	
	private void resetDataGrid(){
		WebUtils.resetForm("frmImp:dataGrid");
	}

	/**
	 * @return the descrip
	 */
	public String getDescrip() {
		return descrip;
	}

	/**
	 * @param descrip the descrip to set
	 */
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
}
