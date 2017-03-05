package co.com.dyc.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class WebUtils {


	/**
	 * Genera un mensage en pantalla de tipo {@linkFacesMessage}.SEVERITY_INFO
	 * @param idMessageComponent Id del componente tipo growl o message donde se mostrara el mensaje
	 * @param title Titulo a mostrar
	 * @param message Mensaje que se debe mostrar
	 */
	public static void infoMessage(String idMessageComponent, String title,String message){
		showMessage(idMessageComponent, FacesMessage.SEVERITY_INFO, title, message);
	}
	
	/**
	 * Genera un mensage en pantalla de tipo {@linkFacesMessage}.SEVERITY_WARN
	 * @param idMessageComponent Id del componente tipo growl o message donde se mostrara el mensaje
	 * @param title Titulo a mostrar
	 * @param message Mensaje que se debe mostrar
	 */
	public static void warnMessage(String idMessageComponent, String title,String message){
		showMessage(idMessageComponent, FacesMessage.SEVERITY_WARN, title, message);
	}
	
	/**
	 * Genera un mensage en pantalla de tipo {@linkFacesMessage}.SEVERITY_ERROR
	 * @param idMessageComponent Id del componente tipo growl o message donde se mostrara el mensaje
	 * @param title Titulo a mostrar
	 * @param message Mensaje que se debe mostrar
	 */
	public static void errorMessage(String idMessageComponent, String title,String message){
		showMessage(idMessageComponent, FacesMessage.SEVERITY_ERROR, title, message);
	}
	
	/**
	 * Genera un mensage en pantalla de tipo {@linkFacesMessage}.SEVERITY_FATAL
	 * @param idMessageComponent Id del componente tipo growl o message donde se mostrara el mensaje
	 * @param title Titulo a mostrar
	 * @param message Mensaje que se debe mostrar
	 */
	public static void fatalMessage(String idMessageComponent, String title,String message){
		showMessage(idMessageComponent, FacesMessage.SEVERITY_FATAL, title, message);
	}

	/**
	 * Limpia los datos de un formulario.
	 * @param formReset
	 */
	public static void resetForm(String formReset){
		RequestContext.getCurrentInstance().reset(formReset);
	}
	
	private static void showMessage(String idMessageComponent,Severity severity, String title,String message){
		FacesContext.getCurrentInstance().addMessage(idMessageComponent, new FacesMessage(severity, title,  message ) );
	}
}
