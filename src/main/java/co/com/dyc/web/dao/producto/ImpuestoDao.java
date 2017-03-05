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
import co.com.dyc.web.entities.producto.Impuesto;
import co.com.dyc.web.entities.producto.Unidad;

/**
 * @author Kero
 *
 */
@Configurable
@Component
public class ImpuestoDao extends AbstractDao<Serializable, Impuesto> implements MasterDao {


	@Override
	public Object findById(Serializable id) {
		return getByKey(id);
	}

	@Override
	public void saveEntity(Object entity) throws DAOException {
		save((Impuesto) entity);

	}

	@Override
	public void deleteEntity(Object entity) throws DAOException {
		Impuesto borrar = (Impuesto) getByKey(((Impuesto) entity).getCodigo());
		delete(borrar);

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Impuesto> findAll() throws DAOException {
		StringBuilder sql = new  StringBuilder("SELECT i FROM Impuesto i WHERE")
		.append("  i.estado = :estado" );
		Query query = null;
		try{
			query = getSession().createQuery(sql.toString());
			query.setParameter("estado", Estado.ACTIVO);
			ArrayList<Impuesto> impuestos = (ArrayList<Impuesto>) query.list();
			return impuestos;
		}catch(Exception e ){
			LogUtils.logErrorMessage(Unidad.class, e, null, e.getMessage());
			throw new DAOException("Error al obtener el listado de : " + Impuesto.class.getName());
		}finally{
				closeSession();
		}
	}
}
