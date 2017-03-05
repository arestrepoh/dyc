package co.com.dyc.utils;

import co.com.dyc.web.entities.producto.TipoProducto;

public class UuidGeneratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(UuidGenerator.getUuid(TipoProducto.class.getSimpleName()));
		System.out.println(UuidGenerator.getUuid(TipoProducto.class.getSimpleName()));
	}

}
