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
import co.com.dyc.web.entities.general.Estado;

/**
 * 
 */
@Entity
@Table(name="producto")
@Component
@Repository
public class Producto extends AbstractEntity<Serializable, Producto> implements Serializable {

	private static final long serialVersionUID = -2515547969128647133L;
	@Id
	private String uuid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoproducto", nullable = false)
	private TipoProducto TipoProducto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria", nullable = false)
	private Categoria categoria;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidad", nullable = false)
	private Unidad unidad;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String codigoean;
	private String creadopor;
	private Date fechacreacion;
	private Date fechaactualizacion;
	private String actualizadopor;
	private double cantminima;
	private double cantmaxima;
	private String precio;
	private Estado estado; 

	public Producto() {
	}

	public Producto(String uuid, TipoProducto TipoProducto,
			Categoria categoria, Unidad unidad, String codigo, String nombre,
			String creadopor, Date fechacreacion, double cantminima,
			double cantmaxima, String precio) {
		this.uuid = uuid;
		this.TipoProducto = TipoProducto;
		this.categoria = categoria;
		this.unidad = unidad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creadopor = creadopor;
		this.fechacreacion = fechacreacion;
		this.cantminima = cantminima;
		this.cantmaxima = cantmaxima;
		this.precio = precio;
	}

	public Producto(String uuid, TipoProducto TipoProducto,
			Categoria categoria, Unidad unidad, String codigo, String nombre,
			String descripcion, String codigoean, String creadopor,
			Date fechacreacion, Date fechaactualizacion, String actualizadopor,
			double cantminima, double cantmaxima, String precio) {
		this.uuid = uuid;
		this.TipoProducto = TipoProducto;
		this.categoria = categoria;
		this.unidad = unidad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoean = codigoean;
		this.creadopor = creadopor;
		this.fechacreacion = fechacreacion;
		this.fechaactualizacion = fechaactualizacion;
		this.actualizadopor = actualizadopor;
		this.cantminima = cantminima;
		this.cantmaxima = cantmaxima;
		this.precio = precio;
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

	public TipoProducto getTipoProducto() {
		return this.TipoProducto;
	}

	public void setTipoProducto(TipoProducto TipoProducto) {
		this.TipoProducto = TipoProducto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
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

	public String getCodigoean() {
		return this.codigoean;
	}

	public void setCodigoean(String codigoean) {
		this.codigoean = codigoean;
	}

	public String getCreadopor() {
		return this.creadopor;
	}

	public void setCreadopor(String creadopor) {
		this.creadopor = creadopor;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public String getActualizadopor() {
		return this.actualizadopor;
	}

	public void setActualizadopor(String actualizadopor) {
		this.actualizadopor = actualizadopor;
	}

	public double getCantminima() {
		return this.cantminima;
	}

	public void setCantminima(double cantminima) {
		this.cantminima = cantminima;
	}

	public double getCantmaxima() {
		return this.cantmaxima;
	}

	public void setCantmaxima(double cantmaxima) {
		this.cantmaxima = cantmaxima;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
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
		result = prime * result
				+ ((codigoean == null) ? 0 : codigoean.hashCode());
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
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoean == null) {
			if (other.codigoean != null)
				return false;
		} else if (!codigoean.equals(other.codigoean))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Producto [uuid=%s, TipoProducto=%s, categoria=%s, unidad=%s, codigo=%s, nombre=%s, descripcion=%s, codigoean=%s, creadopor=%s, fechacreacion=%s, fechaactualizacion=%s, actualizadopor=%s, cantminima=%s, cantmaxima=%s, precio=%s, estado=%s]",
						uuid, TipoProducto, categoria, unidad, codigo, nombre,
						descripcion, codigoean, creadopor, fechacreacion,
						fechaactualizacion, actualizadopor, cantminima,
						cantmaxima, precio, estado);
	}

}
