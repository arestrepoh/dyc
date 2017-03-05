/**
 * 
 */
package co.com.dyc.web.dao.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.utils.LogUtils;
import co.com.dyc.web.dao.AbstractDao;
import co.com.dyc.web.dao.MasterDao;
import co.com.dyc.web.entities.general.Estado;
import co.com.dyc.web.entities.producto.Categoria;

/**
 * @author arestrepoh
 *
 */
@Configurable
@Component
public class CategoriaDao extends AbstractDao<Integer, Categoria> implements MasterDao {

	 @Autowired
	 private MessageSource messageSource;
	 
	@Override
	public Object findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveEntity(Object entity) throws DAOException {
		save((Categoria) entity);
	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		Categoria borrar = (Categoria) getSession().get(Categoria.class, ((Categoria) entity).getCodigo());
		delete(borrar);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Categoria> findAll() throws DAOException {
		StringBuilder sql = new  StringBuilder("SELECT c FROM Categoria c WHERE")
		.append("  c.estado = :estado" );
		Query query = null;
		try{
			query = getSession().createQuery(sql.toString());
			query.setParameter("estado", Estado.ACTIVO);
			ArrayList<Categoria> categorias = (ArrayList<Categoria>) query.list();
			return categorias;
		}catch(Exception e ){
			LogUtils.logErrorMessage(Categoria.class, e, null, e.getMessage());
			throw new DAOException(messageSource.getMessage("err.001", null,Categoria.class.getName(),null ));
		}finally{
			closeSession();
		}
	}
}
