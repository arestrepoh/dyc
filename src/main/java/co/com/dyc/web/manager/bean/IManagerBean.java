/**
 * 
 */
package co.com.dyc.web.manager.bean;



/**
 * @author Kero
 *
 */
public interface IManagerBean  {

	/**
	 * Metodo para la carga iniciar de la pantalla 
	 */
	public void init();
	/**
	 * Cargar los datos
	 */
	public void load();
	
	/**
	 * Adicionar un nuevo registro
	 */
	public String add();
	
	/**
	 * Guardar los cambios realizados.
	 * @return
	 */
	public String save();
	
	/**
	 * Editar registro
	 * @return
	 */
	public String edit();
	
	/**
	 * Borrar registro
	 * @return
	 */
	public String delete();
	
	
}
