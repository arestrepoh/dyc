/**
 * 
 */
package co.com.dyc.web.service.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.ValidationField;
import co.com.dyc.web.dao.producto.CategoriaDao;
import co.com.dyc.web.entities.producto.Categoria;
import co.com.dyc.web.service.IMasterService;

/**
 * @author Kero
 *
 */
@Configurable
@Service
public class CategoriaService extends ValidationField implements Serializable,IMasterService {

	private static final long serialVersionUID = 5976233708043342466L;
	@Autowired
	private CategoriaDao categoriaDao;
	
	public CategoriaService() {
	}
	
	@Override
	public boolean save(Object entity) throws DAOException, ServiceException {
		try{
			validate(entity);
			categoriaDao.saveEntity(entity);
			return true;
		}catch(DAOException e){
			throw e;
		}
	}
	
	public ArrayList<Categoria> getAll() throws DAOException{
		try{
			return categoriaDao.findAll();
		}catch(DAOException e){
			throw e;
		}
	}

	/**
	 * @return the categoriaDao
	 */
	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	/**
	 * @param categoriaDao the categoriaDao to set
	 */
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	public boolean delete(Object entity) throws DAOException {
		try{
			categoriaDao.deleteEntity(entity);
			return true;
		}catch(DAOException e){
			throw e;
		}
	}


}
