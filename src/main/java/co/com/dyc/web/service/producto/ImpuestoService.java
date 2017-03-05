package co.com.dyc.web.service.producto;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;
import co.com.dyc.utils.ValidationField;
import co.com.dyc.web.dao.producto.ImpuestoDao;
import co.com.dyc.web.entities.producto.Impuesto;
import co.com.dyc.web.service.IMasterService;

/**
 * @author Kero
 *
 */
@Configurable
@Service
public class ImpuestoService extends ValidationField implements IMasterService, Serializable {

	private static final long serialVersionUID = -5143906417628095161L;

	@Autowired
	private ImpuestoDao impuestoDao;
	
	@Override
	public boolean save(Object entity) throws DAOException, ServiceException {
		try{
			validate(entity);
			impuestoDao.saveEntity(entity);
			return true;
		}catch(DAOException | ServiceException e){
			throw e;
		}
	}

	@Override
	public boolean delete(Object entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Impuesto> getAll() throws DAOException{
		try{
			return impuestoDao.findAll();
		}catch(DAOException e){
			throw e;
		}
	}
}
