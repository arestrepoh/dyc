/**
 * 
 */
package co.com.dyc.web.manager.bean.general;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author Kero
 *
 */
@ManagedBean(name = "fileUp")
@SessionScoped
public class FileUploadBean implements Serializable {

	private static final long serialVersionUID = 4003771823636949031L;
	private String destination="E:\\tmp\\";
	
	UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent event){
		// Get uploaded file from the FileUploadEvent
		this.file = event.getFile();
		// Print out the information of the file
		System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize() + " " + file.getContentType());
		
		 FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        // Do what you want with the file        
	        try {
	            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public void copyFile(String fileName, InputStream in) {
        try {
           File f = new File(destination);
           if(!f.exists())
        	   f.mkdir();
           
             // write the inputStream to a FileOutputStream
             OutputStream out = new FileOutputStream(new File(destination + fileName));
           
             int read = 0;
             byte[] bytes = new byte[1024];
           
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
           
             in.close();
             out.flush();
             out.close();
           
             System.out.println("New file created!");
             } catch (IOException e) {
             System.out.println(e.getMessage());
             }
 }
}
	