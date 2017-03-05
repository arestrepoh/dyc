/**
 * 
 */
package co.com.dyc.web.service.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import co.com.dyc.web.dao.seguridad.UsuarioDao;
import co.com.dyc.web.entities.seguridad.Usuario;

/**
 * @author Kero
 *
 */
@Configurable
@Service
public class UsuarioService {

	@Autowired
	public UsuarioDao usuarioDao;
	
	public Usuario iniciarSession(String id, String password){
		Usuario usuario = usuarioDao.getUsuarioByLogin(id, password);
		return usuario;
	}
}
