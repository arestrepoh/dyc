package co.com.dyc.web.entities.producto;

import java.io.Serializable;

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
@Table(name="impuesto")
@Component
@Repository
public class Impuesto implements Serializable {

	private static final long serialVersionUID = -2594962875440048500L;
	@Id
	@Required(title="Código")
	private String codigo;
	@Required(title="Nombre")
	private String nombre;
	private String descripcion;
	@Required(title="Valor")
	private Double valor;
	@Required(title="Estado")
	private String estado;

	public Impuesto() {
	}

	public Impuesto(String codigo, String nombre, double valor, String estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.estado = estado;
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

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impuesto other = (Impuesto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Impuesto [codigo=%s, nombre=%s, descripcion=%s, valor=%s, estado=%s]",
						codigo, nombre, descripcion, valor, estado);
	}


}
