package co.com.dyc.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author arestrepoh
 *
 */
public class LogUtils {

	/** Mensaje de error. */
	private static final String MENSAJE_ERROR = "Error Aplicación: ";

	/**
	 * Este metodo maneja el control de errores en toda la aplicacion.
	 * 
	 * @param thisClass
	 *            clase con la cual se va a guardar el error en el logger.
	 * @param exception
	 *            excepcion ocurrida.
	 * @param errorCode
	 *            clave del error para buscar en el archivo de propiedades.
	 * @param errorDescription
	 *            si el error no esta en el arcivo de propiedades, se utiliza
	 *            este mensaje.
	 */
	public static void logErrorMessage(Class<?> thisClass, Throwable exception, String errorCode, String errorDescription) {
		final Logger logger = Logger.getLogger(thisClass);		
		if (exception != null) {
			if (StringUtils.isNotBlank(errorCode)) {
				logger.error(MENSAJE_ERROR + errorCode + errorDescription, exception);
			} else if (StringUtils.isNotBlank(errorDescription)) {
				logger.error(errorDescription, exception);
			} else {
				logger.error(exception.getMessage(), exception);
			}
		} else if (StringUtils.isNotBlank(errorDescription)) {
			logger.error(errorDescription);
		}
	}

	/**
	 * Este método maneja el control de errores en toda la aplicación.
	 * 
	 * @param thisClass
	 *            clase con la cual se va a guardar el error en el logger.
	 * @param infoMessage
	 *            Mensaje.
	 */
	public static void logInfoMessage(Class<?> thisClass, String infoMessage) {
		final Logger logger = Logger.getLogger(thisClass);
		logger.info(infoMessage);
	}

	/**
	 * Este metodo permite manejar los logs a nivel de warnings.
	 * 
	 * @param thisClass
	 *            Clase con la cual se va a guardar el error en el logger.
	 * @param exception
	 *            Excepcion capturada.
	 * @param warningMessage
	 *            Mensaje a registrar
	 * @since 21/09/2015
	 */
	public static void logWarningMessage(Class<?> thisClass, Throwable exception, String warningMessage) {
		final Logger logger = Logger.getLogger(thisClass);
		logger.warn(warningMessage, exception);
	}
}
