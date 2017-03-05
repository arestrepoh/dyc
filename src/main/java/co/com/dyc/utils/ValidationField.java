/**
 * 
 */
package co.com.dyc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;

import co.com.dyc.exceptions.ServiceException;

/**
 * Valida los campos obligatorios de una Entidad
 * 
 * @author Kero
 * 
 */
public abstract class ValidationField {

	public ValidationField() {

	}

	/**
	 * Valida si una propiedad es requerida
	 * 
	 * @param object
	 * @throws ServiceException 
	 */
	public synchronized void validate(Object object) throws ServiceException {
		final String className = object.getClass().getName();
		final StringBuilder fieldsRequerid = new StringBuilder();
		int cantField = 0;
		try {
			Field properties[] = Class.forName(className).getDeclaredFields();
			for (Field field : properties) {
				Required multipleInvocation = field.getAnnotation(Required.class);
				if (multipleInvocation != null && multipleInvocation.value()) {
					field.setAccessible(true);
					if (!validateRequiredByType(field.get(object), field.getGenericType())) {
						cantField++;
						if (StringUtils.isNotBlank(fieldsRequerid.toString()))
							fieldsRequerid.append(", ");
						fieldsRequerid.append(StringUtils.isNotBlank(multipleInvocation.title()) ? multipleInvocation.title() : field.getName());
					}
					field.setAccessible(false);
				}
			}
		} catch (final Exception e) {
			throw new ServiceException("Se presento un error al validar la entidad",e);
		}
			if (StringUtils.isNotBlank(fieldsRequerid.toString())) {
				String message = "Los campos %s son de obligatorio diligenciamiento.";
				if (cantField > 1) {
					message = String.format(message, fieldsRequerid.toString());
				} else {
					message = "El campo %s es de obligatorio diligenciamiento.";
					message = String.format(message, fieldsRequerid.toString());
				}
				throw new ServiceException(message);
			}

	}

	private boolean validateRequiredByType(Object value, Type type) {
		boolean result = false;
		try {
			if (type.equals(String.class)) {
				result = StringUtils.isNotBlank((String) value);
			} else if (type.equals(Integer.class)) {
				Integer i = (Integer) value;
				result = i != null;
			}else if(type.equals(Double.class) || type.equals(double.class)){
				Double d = (Double) value;
				result = d != null;
			}
		} catch (IllegalArgumentException e) {
			throw e;
		}
		return result;
	}
}
