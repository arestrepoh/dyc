/**
 * 
 */
package co.com.dyc.utils;

import java.util.UUID;

/**
 * @author Kero
 *
 */
public class UuidGenerator {

	public static String getUuid(String entitieName){
		LogUtils.logInfoMessage(UuidGenerator.class, "Uuid para " +entitieName);
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "").substring(0, 32);
		return uuid;
	}
}
