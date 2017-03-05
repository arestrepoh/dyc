/**
 * 
 */
package co.com.dyc.web.dao;

import java.io.Serializable;

import co.com.dyc.exceptions.DAOException;

/**
 * @author arestrepoh
 *
 */
public interface MasterDao {
	
	/**
	 * Busca la entidad con  la PrimaryKey
	 * @param id
	 * @return
	 */
	public Object findById(Serializable id);
	 
	/**
	 * Inserta o Actualiza la entidad
	 * @param entity
	 * @throws DAOException
	 */
    public void saveEntity(Object entity) throws DAOException;
    
    /**
     * Elimina la Entidad
     * @param entity
     * @throws DAOException
     */
    public void deleteEntity(Object entity) throws DAOException;
     
 
}
