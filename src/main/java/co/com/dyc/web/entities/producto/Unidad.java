package co.com.dyc.web.entities.producto;

// Generated 27/02/2017 07:34:32 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.dyc.utils.Required;

/**
 * 
 */
@Entity
@Table(name="unidad")
@Component
@Repository
public class Unidad implements Serializable {

	private static final long serialVersionUID = -3114574395866202548L;
	@Id
	@Required(title="Código")
	private String codigo;
	@Required(title="Nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Required(title="Estado")
	private String estado;
	
	public Unidad() {
	}

	public Unidad(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estadoCode
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estadoCode the estadoCode to set
	 */
	public void setEstado(String estadoCode) {
		this.estado = estadoCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidad other = (Unidad) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Unidad [codigo=%s, nombre=%s, descripcion=%s, estado=%s]",
				codigo, nombre, descripcion, estado);
	}


}
