package co.com.dyc.web.manager.bean.producto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.WebUtils;
import co.com.dyc.web.entities.general.Estado;
import co.com.dyc.web.entities.producto.Unidad;
import co.com.dyc.web.manager.bean.IManagerBean;
import co.com.dyc.web.service.producto.UnidadService;

/**
 * Controlador de la pantalla de Unidades de Medida
 * @author Kero
 * 
 */
@Named
@ManagedBean(name = "unidadMB")
@SessionScoped
public class UnidadBean implements IManagerBean, Serializable {

	private static final long serialVersionUID = 848152821048522838L;

	private Unidad unidad;
	private ArrayList<Unidad> unidades;
	private boolean nuevoReg;

	@ManagedProperty("#{unidadService}")
	private UnidadService unidadService;

	public UnidadBean() {
	}

	@PostConstruct
	public void init() {
		nuevaUnidad();
		this.load();
	}

	@Override
	public void load() {
		try {
			unidades = unidadService.getAll();
		} catch (DAOException e) {
			WebUtils.fatalMessage(null, "Cargar Categorias",
					"Se presento un error al cargar los datos.");
		}
	}

	public void onRowSelect(SelectEvent event) {
		resetDataGrid();
		setNuevoReg(false);
	}

	@Override
	public String add() {
		nuevaUnidad();
		resetDataGrid();
		return null;
	}

	@Override
	public String save() {
		try {
			if (unidadService.save(unidad)) {
				WebUtils.infoMessage(null, "Categoria Productos",
						"Datos guardados correctamente.");
				this.load();
				resetDataGrid();
				nuevaUnidad();
			}
		} catch (DAOException | ServiceException e) {
			WebUtils.errorMessage(null, "Guardar", e.getMessage());
		}
		return null;
	}

	@Override
	public String edit() {
		return null;
	}

	@Override
	public String delete() {
		try {
			if(unidadService.delete(unidad)){
				WebUtils.infoMessage(null,"Categoria Productos", "Registro eliminado correctamente.");
				this.load();
				resetDataGrid();
				this.nuevaUnidad();
			}
		} catch (DAOException e) {
			WebUtils.errorMessage(null,"Eliminar",
					"Error al guardar el registro. Intente mas tarde");
		}
		return null;
	}

	/**
	 * @return the unidad
	 */
	public Unidad getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad
	 *            the unidad to set
	 */
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the unidades
	 */
	public ArrayList<Unidad> getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades
	 *            the unidades to set
	 */
	public void setUnidades(ArrayList<Unidad> unidades) {
		this.unidades = unidades;
	}

	/**
	 * @return the unidadService
	 */
	public UnidadService getUnidadService() {
		return unidadService;
	}

	/**
	 * @param unidadService
	 *            the unidadService to set
	 */
	public void setUnidadService(UnidadService unidadService) {
		this.unidadService = unidadService;
	}

	/**
	 * @return the nuevoReg
	 */
	public boolean isNuevoReg() {
		return nuevoReg;
	}

	/**
	 * @param nuevoReg
	 *            the nuevoReg to set
	 */
	public void setNuevoReg(boolean nuevoReg) {
		this.nuevoReg = nuevoReg;
	}


	private void nuevaUnidad() {
		unidad = new Unidad();
		unidad.setEstado(Estado.ACTIVO);
		setNuevoReg(true);
	}
	
	private void resetDataGrid(){
		WebUtils.resetForm("frmUnidad:dataGrid");
	}
}
