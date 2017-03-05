package co.com.dyc.web.service.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.ValidationField;
import co.com.dyc.web.dao.producto.UnidadDao;
import co.com.dyc.web.entities.producto.Unidad;
import co.com.dyc.web.service.IMasterService;

/**
 * capa de negocio de la Unidad de Medida
 * @author Andres Restrepo
 *
 */
@Configurable
@Service
public class UnidadService extends ValidationField implements IMasterService, Serializable {

	private static final long serialVersionUID = 915400433525572161L;
	@Autowired
	private UnidadDao unidadDao;
	
	public UnidadService() {
	}
	
	@Override
	public boolean save(Object entity) throws DAOException,ServiceException {
		try{
			validate(entity);
			unidadDao.saveEntity(entity);
			return true;
		}catch(DAOException | ServiceException e){
			throw e;
		}
	}

	@Override
	public boolean delete(Object entity) throws DAOException {
		try{
			 unidadDao.deleteEntity(entity);
			 return true;
		}catch(DAOException e){
			throw e;
		}
	}

	public ArrayList<Unidad> getAll() throws DAOException{
		try{
			return unidadDao.findAll();
		}catch(DAOException e){
			throw e;
		}
	}
}
