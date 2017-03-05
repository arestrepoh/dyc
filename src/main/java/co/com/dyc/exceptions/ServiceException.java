/**
 * 
 */
package co.com.dyc.exceptions;

/**
 * @author Kero
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4028757749440720777L;

	public ServiceException() {
		
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message,Throwable e) {
		super(message, e);
	}	
}
