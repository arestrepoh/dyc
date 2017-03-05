package co.com.dyc.web.entities.producto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.dyc.web.entities.AbstractEntity;


/**
 * 
 */
@Entity
@Table(name="impuestoprod")
@Component
@Repository
public class ImpuestoProd extends AbstractEntity<Serializable, ImpuestoProd> implements Serializable {

	private static final long serialVersionUID = 36204930650544780L;
	@Id
	private String uuid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "impuesto", nullable = false)
	private Impuesto impuesto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto", nullable = false)
	private Producto producto;

	public ImpuestoProd() {
	}

	public ImpuestoProd(String uuid, Impuesto impuesto, Producto producto) {
		this.uuid = uuid;
		this.impuesto = impuesto;
		this.producto = producto;
	}

	public String getUuid() {
		if(StringUtils.isBlank(this.uuid)){
			this.uuid = super.getUuid();
		}
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Impuesto getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((impuesto == null) ? 0 : impuesto.hashCode());
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		ImpuestoProd other = (ImpuestoProd) obj;
		if (impuesto == null) {
			if (other.impuesto != null)
				return false;
		} else if (!impuesto.equals(other.impuesto))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Impuestoprod [uuid=%s, impuesto=%s, producto=%s]", uuid,
				impuesto, producto);
	}
	
	

}
