/**
 * 
 */
package co.com.dyc.web.dao.general;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.web.dao.AbstractDao;
import co.com.dyc.web.dao.MasterDao;
import co.com.dyc.web.entities.general.Menu;

/**
 * @author Kero
 *
 */
public class MenuDao extends AbstractDao<Serializable, Menu> implements MasterDao {

	@Override
	public Object findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEntity(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getMenus() throws DAOException{
		try{
			StringBuilder sql = new  StringBuilder("SELECT m FROM Menu m WHERE")
			.append(" m.tipo = 'T'");
			Query query = getSession().createQuery(sql.toString());
			List<Menu> menus = query.list();
			return menus;
		}catch(Exception e){
			throw new DAOException(e.getMessage());
		}finally{
				closeSession();
		}
	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}
}
