/**
 * 
 */
package co.com.dyc.web.manager.bean.general;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.utils.ConstantesUtils;
import co.com.dyc.utils.LogUtils;
import co.com.dyc.utils.WebUtils;
import co.com.dyc.utils.WebSession;
import co.com.dyc.web.entities.general.Menu;
import co.com.dyc.web.entities.seguridad.Rol;
import co.com.dyc.web.entities.seguridad.Usuario;
import co.com.dyc.web.service.general.MenuService;

/**
 * @author Kero
 *
 */
@Named
@ManagedBean(name="menuHeader")
@ViewScoped
public class MenuManager {

	private Menu menu;
	@ManagedProperty("#{menuService}")
	private MenuService menuService;
	
	private MenuModel model;
	private List<Menu> lista;
	private Rol rol;
	
	@PostConstruct
	public void init(){
		try{
			if(!WebSession.isSessionActive()){
				return;
			}
			menu = new Menu();
			rol = ((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ConstantesUtils.VARIABLE_SESSION_USUARIO)).getRol();
			this.listarMenu();
			model = new DefaultMenuModel();
			this.establecerPermisos();
		}catch(Exception e){
			WebUtils.fatalMessage(null,"Error!!!", "Error al establecer los permisos" + e.getMessage());
			LogUtils.logErrorMessage(this.getClass(), e, null, "Error al crear el menu. ");
		}
		
	}
	
	public void cerrarSession(){
		WebSession.eliminarSesio();
	}

	private void listarMenu() throws DAOException{
			lista = menuService.getMenus();
	}
	
	private void establecerPermisos(){
		for (Menu m : lista) {
			if(StringUtils.equalsIgnoreCase(m.getTipo(),Menu.TIPO_TITULO) && StringUtils.equalsIgnoreCase(rol.getCodigo(), m.getRol())){
				DefaultSubMenu titleMenu = new DefaultSubMenu(m.getNombre());			
				titleMenu.setId(String.valueOf(m.getId()));
				List<Menu>subMenu = m.getSubMenus();
				if(!subMenu.isEmpty()){
					this.crearItemMenu(subMenu, titleMenu);
				}
				model.addElement(titleMenu);
			}			
		}
	}
	
	private DefaultSubMenu crearItemMenu(List<Menu>items,DefaultSubMenu subMenuBar){
		for (Menu menu : items) {
			if(StringUtils.equalsIgnoreCase(menu.getTipo(),Menu.TIPO_SUBMENU)){
				DefaultSubMenu titleMenu = new DefaultSubMenu(menu.getNombre());			
				titleMenu.setId(String.valueOf(menu.getId()));
				List<Menu>subMenu = menu.getSubMenus();
				if(!subMenu.isEmpty()){
					titleMenu = this.crearItemMenu(subMenu, titleMenu);
				}	
				subMenuBar.addElement(titleMenu);
			}else if(StringUtils.equalsIgnoreCase(menu.getTipo(),Menu.TIPO_ITEM)){
				subMenuBar = crearItem(subMenuBar,menu);
			}
		}
		return subMenuBar;
	}
	
	private DefaultSubMenu  crearItem(DefaultSubMenu subMenuBar,Menu menu){
		DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());
		item.setId(String.valueOf(menu.getId()));
		item.setIcon(menu.getIcon());
		item.setUrl( menu.getUrl());
		subMenuBar.addElement(item);
		return subMenuBar;
	}
	
	/**
	 * @return the lista
	 */
	public List<Menu> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Menu> lista) {
		this.lista = lista;
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * @return the menuService
	 */
	public MenuService getMenuService() {
		return menuService;
	}

	/**
	 * @param menuService the menuService to set
	 */
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	/**
	 * @return the model
	 */
	public MenuModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(MenuModel model) {
		this.model = model;
	}
}
