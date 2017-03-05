package co.com.dyc.web.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.utils.LogUtils;
import co.com.dyc.utils.WebSession;
import co.com.dyc.web.entities.seguridad.Auditoria;

/**
 * @author arestrepoh
 *
 */
@Component
@Repository
public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;
	private boolean isActiva;
	private Session  session;
	private Transaction txManager; 
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    /**
     * Optiene la {@link Session} actual en la Base de Datos.
     * @return
     */
    protected Session getSession(){
    	if(session == null || !session.isOpen())
    		session = sessionFactory.openSession();
        return session;
    }
    
    
    protected void iniciarTx(){
    	isActiva = session.getTransaction().isActive();
    	if(!isActiva){
    		txManager = session.beginTransaction();
    		isActiva = txManager.isActive();
    	}
    	
    }
 
    /**
     * Obitiene la Entidad en base a la Clave Priamria.
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    protected T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
    
    protected ArrayList<T> findAll() throws DAOException{
		return null;
    }
 
    /**
     * Inserta o Actualiza la entidad en la BD. 
     * @param entity
     * @throws DAOException
     */
    protected void save(T entity) throws DAOException {
    	
    	try {
    		Session session = getSession();
    		this.iniciarTx();
    		session.saveOrUpdate(entity);
    		this.commit();
    	}catch(Exception e){
    		LogUtils.logErrorMessage(this.getClass(), e, "", e.getMessage());
    		this.rollback();
    		throw new DAOException(e.getMessage());
    	}finally{
    		this.closeSession();
    	}
    }

    /**
     * Borra la entidad en la BD
     * @param entity
     * @throws DAOException
     */
    protected void delete(T entity) throws DAOException {
    	try{
    		Session session = getSession();
    		session.clear();
    		this.iniciarTx();
    		session.delete(entity);
    		session.flush();
    		this.commit();
    	}catch(Exception e){
    		LogUtils.logErrorMessage(this.getClass(), e, "", e.getMessage());
    		this.rollback();
    		throw new DAOException(e.getMessage());
    	}finally{
    		this.closeSession();
    	}
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    private void commit(){
    	if(isActiva){
    		txManager.commit();
    	}
    }
    
    private void rollback(){
    	if(isActiva){
    		txManager.rollback();
    	}
    }
    
    protected void closeSession(){    	
    	if(session != null && session.isOpen())
    		session.close();
    }
    
    
    protected void saveAudit(T entity){
    	Auditoria audit = new Auditoria();
		audit.setUsuario(WebSession.getUsuario().getId());
		audit.setFechaCreacion(new Date());
		audit.setEntidad(persistentClass.getSimpleName());
		audit.setValores(entity.toString());
		try {
			this.save(entity);
		} catch (DAOException e) {
			LogUtils.logErrorMessage(entity.getClass(), e, "AUDIT", e.getMessage());
		}
    }
}
