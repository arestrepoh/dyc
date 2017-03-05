package co.com.dyc.web.manager.bean;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 * Interface para los Manager Bean que tienen tabla editable.
 * @author Kero
 *
 */
public interface IManagerBeanTableEdit {

	
	public void onRowEdit(RowEditEvent event);
	
	public void onRowCancel(RowEditEvent event);
	
	public void onCellEdit(CellEditEvent event);
	
	
}
