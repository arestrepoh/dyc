/**
 * 
 */
package co.com.dyc.web.dao.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.utils.LogUtils;
import co.com.dyc.web.dao.AbstractDao;
import co.com.dyc.web.dao.MasterDao;
import co.com.dyc.web.entities.general.Estado;
import co.com.dyc.web.entities.producto.Unidad;

/**
 * @author Kero
 *
 */
@Configurable
@Component
public class UnidadDao extends AbstractDao<Serializable, Unidad> implements MasterDao {

	@Override
	public Object findById(Serializable id) {
		return getByKey(id);
	}

	@Override
	public void saveEntity(Object entity) throws DAOException {
		save((Unidad) entity);
	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		Unidad borrar = (Unidad) getByKey(((Unidad) entity).getCodigo());
		delete(borrar);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Unidad> findAll() throws DAOException {
		StringBuilder sql = new  StringBuilder("SELECT u FROM Unidad u WHERE")
		.append("  u.estado = :estado" );
		Query query = null;
		try{
			query = getSession().createQuery(sql.toString());
			query.setParameter("estado", Estado.ACTIVO);
			ArrayList<Unidad> unidades = (ArrayList<Unidad>) query.list();
			return unidades;
		}catch(Exception e ){
			LogUtils.logErrorMessage(Unidad.class, e, null, e.getMessage());
			throw new DAOException("Error al obtener el listado de : " + Unidad.class.getName());
		}finally{
				closeSession();
		}
	}
}
