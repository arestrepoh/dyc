package co.com.dyc.web.entities.producto;


import java.io.Serializable;
import java.util.Date;

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
@Table(name="precio")
@Component
@Repository
public class Precio  extends AbstractEntity<Serializable, Precio>implements Serializable {

	private static final long serialVersionUID = -4214573968873014581L;
	@Id
	private String uuid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto", nullable = false)
	private Producto producto;
	private Date fechaInicio;
	private Date fechaFin;
	private double valor;
	private String creadoPor;
	private Date creationdate;
	private String actualizadopor;
	private Date updateDate;
	private String estado;

	public Precio() {
	}

	public Precio(String uuid, Producto producto, Date fechaInicio,
			double valor, String creadoPor, Date creationdate, String estado) {
		this.uuid = uuid;
		this.producto = producto;
		this.fechaInicio = fechaInicio;
		this.valor = valor;
		this.creadoPor = creadoPor;
		this.creationdate = creationdate;
		this.estado = estado;
	}

	public Precio(String uuid, Producto producto, Date fechaInicio,
			Date fechaFin, double valor, String creadoPor, Date creationdate,
			String actualizadopor, Date updateDate, String estado) {
		this.uuid = uuid;
		this.producto = producto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.valor = valor;
		this.creadoPor = creadoPor;
		this.creationdate = creationdate;
		this.actualizadopor = actualizadopor;
		this.updateDate = updateDate;
		this.estado = estado;
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

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCreadoPor() {
		return this.creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getActualizadopor() {
		return this.actualizadopor;
	}

	public void setActualizadopor(String actualizadopor) {
		this.actualizadopor = actualizadopor;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Precio other = (Precio) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
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
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Precio [uuid=%s, producto=%s, fechaInicio=%s, fechaFin=%s, valor=%s, creadoPor=%s, creationdate=%s, actualizadopor=%s, updateDate=%s, estado=%s]",
						uuid, producto, fechaInicio, fechaFin, valor,
						creadoPor, creationdate, actualizadopor, updateDate,
						estado);
	}
	
}
