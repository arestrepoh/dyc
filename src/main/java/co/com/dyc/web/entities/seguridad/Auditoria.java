/**
 * 
 */
package co.com.dyc.web.entities.seguridad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.dyc.utils.UuidGenerator;

/**
 * @author Kero
 *
 */
@Entity
@Table(name ="audit")
@Component
@Repository
public class Auditoria implements Serializable {

	private static final long serialVersionUID = 3470063021171325497L;

	@Id
	private String uuid;
	@Column(name="fechacreacion")
	private Date fechaCreacion;
	private String usuario;
	private String entidad;
	private String valores;
	
	public Auditoria() {
		this.setUuid(UuidGenerator.getUuid(this.getClass().getName()));
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the entidad
	 */
	public String getEntidad() {
		return entidad;
	}
	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	/**
	 * @return the valores
	 */
	public String getValores() {
		return valores;
	}
	/**
	 * @param valores the valores to set
	 */
	public void setValores(String valores) {
		this.valores = valores;
	}
}
