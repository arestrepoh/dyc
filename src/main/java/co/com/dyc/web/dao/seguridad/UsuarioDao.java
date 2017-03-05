/**
 * 
 */
package co.com.dyc.web.dao.seguridad;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.web.dao.AbstractDao;
import co.com.dyc.web.dao.MasterDao;
import co.com.dyc.web.entities.seguridad.Usuario;

/**
 * @author Kero
 *
 */
@Configurable
@Component
public class UsuarioDao extends AbstractDao<Integer, Usuario> implements MasterDao {

	@Override
	public Object findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEntity(Object entity) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Obtiene el usuario por el Id y el Password
	 * @param id
	 * @param password
	 * @return
	 */
	public Usuario  getUsuarioByLogin(String id, String password){
		Criteria criteria = null;
		Usuario usuario = null;
		try{
			//TODO cambiar la consulta por Query
			criteria = this.createEntityCriteria();
			usuario =  (Usuario) criteria.add(Restrictions.eq("id", id))
					.add(Restrictions.eq("password", password)).uniqueResult();	
		}catch(Exception e){
			throw e;
		}finally{		
			if(criteria != null)
				criteria = null;
		}
		return usuario;
	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
