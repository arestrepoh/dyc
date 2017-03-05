/**
 * 
 */
package co.com.dyc.web.service.general;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.web.dao.general.MenuDao;
import co.com.dyc.web.entities.general.Menu;

/**
 * @author Kero
 *
 */
@Configurable
@Service
public class MenuService implements Serializable {

	private static final long serialVersionUID = -1460575089277380172L;
	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getMenus() throws DAOException{
		List<Menu> menus = menuDao.getMenus();
		return menus;
	}
	
}
