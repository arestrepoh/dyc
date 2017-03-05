/**
 * 
 */
package co.com.dyc.exceptions;

/**
 * @author arestrepoh
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 7884047827096582939L;
	
	public static int ERROR_SAVEORUPDATE = 1;
	public static int ERROR_DELETE = 2;
	public static int ERROR_SENTENCY_SQL = 3;
	public DAOException(String message) {
		super(message);
	}
}
