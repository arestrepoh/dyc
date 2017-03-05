package co.com.dyc.web.service.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.exceptions.DAOException;
import co.com.dyc.web.dao.producto.TipoProductoDao;
import co.com.dyc.web.service.IMasterService;

@Configurable
@Service
public class TipoProductoService implements IMasterService {

	private static final long serialVersionUID = 520874494276883658L;
	@Autowired
	private TipoProductoDao tipoProductoDAO;
	
	public TipoProductoService() {
	}
	
	public boolean save(Object entity) throws DAOException {
		try{
			tipoProductoDAO.saveEntity(entity);
			return true;
		}catch(DAOException e){
			throw e;
		}
	}

	public void eliminar(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public TipoProductoDao getTipoProductoDAO() {
		return tipoProductoDAO;
	}

	@Override
	public boolean delete(Object entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
}
