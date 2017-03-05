/**
 * 
 */
package co.com.dyc.web.entities.general;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Kero
 *
 */
@Entity
@Table(name ="menu")
@Component
@Repository
public class Menu implements Serializable {

	private static final long serialVersionUID = -614973537881433536L;
	public static final String TIPO_TITULO = "T";
	public static final String TIPO_SUBMENU = "S";
	public static final String TIPO_ITEM = "I";
	
	@Id
	private int id;
	private String nombre;
	private String tipo;
	private String rol;
	private String url;
	private String icon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submenu", nullable = false)
	private Menu submenu;

	private String estado;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "submenu")
	private List<Menu> subMenus;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * @return the submenu
	 */
	public Menu getSubmenu() {
		return submenu;
	}
	/**
	 * @param submenu the submenu to set
	 */
	public void setSubmenu(Menu submenu) {
		this.submenu = submenu;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the subMenus
	 */
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	/**
	 * @param subMenus the subMenus to set
	 */
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Menu other = (Menu) obj;
		if (id != other.id)
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Menu [nombre=%s, tipo=%s, rol=%s, submenu=%s, estado=%s]",
				nombre, tipo, rol, submenu, estado );
	}
	
	
}
