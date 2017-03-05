/**
 * 
 */
package co.com.dyc.web.dao.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.web.dao.AbstractDao;
import co.com.dyc.web.dao.MasterDao;
import co.com.dyc.web.entities.producto.TipoProducto;

/**
 * @author arestrepoh
 *
 */
@Configurable
@Component
public class TipoProductoDao extends AbstractDao<Integer, TipoProducto> implements MasterDao {

	@Override
	public Object findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveEntity(Object entity) throws DAOException {
		save((TipoProducto) entity);
	}

	public ArrayList<TipoProducto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
