package co.com.dyc.web.manager.bean.producto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.WebUtils;
import co.com.dyc.web.entities.general.Estado;
import co.com.dyc.web.entities.producto.Categoria;
import co.com.dyc.web.manager.bean.IManagerBean;
import co.com.dyc.web.service.producto.CategoriaService;

/**
 * @author Kero
 * 
 */
@Named
@ManagedBean(name = "categoriaMB")
@ViewScoped
public class CategoriaBean implements IManagerBean,
		Serializable {

	private static final long serialVersionUID = -714962674920365059L;
	private Categoria categoria;
	private ArrayList<Categoria> categorias;
	
	@ManagedProperty("#{categoriaService}")
	private CategoriaService categoriaService;

	@PostConstruct
	public void init() {
		categoria = new Categoria();
		load();
	}

	@Override
	public void load() {
		try {
			categorias = categoriaService.getAll();
		} catch (DAOException e) {
			WebUtils.fatalMessage(null,"Cargar Categorias",
					"Se presento un error al cargar los datos.");
		}
	}

	@Override
	public String add() {
//		resetDataGrid();
		this.categoria = new Categoria();
		this.categoria.setEstado(Estado.ACTIVO);
		
		return null;
	}
	
	@Override
	public String save() {
		try {
			if (categoriaService.save(categoria)) {
				WebUtils.infoMessage(null,"Categoria Productos",
						"Datos guardados correctamente.");
				this.load();
			}
		} catch (DAOException | ServiceException e) {
			WebUtils.errorMessage(null,"Guardar",
					"Error al guardar el registro. Intente mas tarde");
		}
		RequestContext.getCurrentInstance().execute("PF('catDialog').hide()");
		return null;
	}

	@Override
	public String edit() {
		resetDataGrid();
		return null;
	}

	@Override
	public String delete() {
		try {
			if(categoria == null || StringUtils.isBlank(categoria.getCodigo()))
				return null;
			if(categoriaService.delete(categoria)){
				WebUtils.infoMessage(null,"Categoria Productos", "Registro eliminado correctamente.");
				this.load();
			}
		} catch (DAOException e) {
			WebUtils.errorMessage(null,"Eliminar",
					"Error al guardar el registro. Intente mas tarde");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the categorias
	 */
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the categoriaService
	 */
	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	/**
	 * @param categoriaService
	 *            the categoriaService to set
	 */
	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	private void resetDataGrid(){
		WebUtils.resetForm(":formCat:catDetail");
	}
}
