package co.com.dyc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TipoProductoTest {

	public static void main(String[] args) throws Exception {
		 
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/ejemploinyeccionspring/config.xml"));
 
//        Vehiculo vehiculo = (Vehiculo) factory.getBean("vehiculo");
 
//        vehiculo.comprobarMotor();
 
    }
	
}
