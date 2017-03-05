package co.com.dyc.web.entities;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.apache.commons.lang.StringUtils;

import co.com.dyc.utils.UuidGenerator;

public class AbstractEntity <PK extends Serializable, T>{

	private final Class<T> persistentClass;
	private String uuid;
	
	@SuppressWarnings("unchecked")
	public AbstractEntity() {
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public String getUuid(){
		if(StringUtils.isBlank(this.uuid))
			this.uuid = UuidGenerator.getUuid(persistentClass.getSimpleName());
		return uuid;
	}
	
	public  void setUuid(String uuid){
		this.uuid = uuid;
	}
}
