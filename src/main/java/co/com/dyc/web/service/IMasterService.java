package co.com.dyc.web.service;

import java.io.Serializable;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.exceptions.ServiceException;

/**
 * @author Kero
 *
 */
public interface IMasterService extends Serializable {

	public boolean save(Object entity) throws DAOException, ServiceException ;
	
	public boolean delete(Object entity) throws DAOException ; 
}
