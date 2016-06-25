package com.eofclub.forum.util;

import java.util.Map;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Stateless
public class SessionUtil {
	
	private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	
	private Map<String, Object> getSessionMap(){
		return this.externalContext.getSessionMap();
	}

	public Optional<Object> getSession(String sessionName){
		if(this.AttributeSessionExists(sessionName))
			return Optional.of(this.getSessionMap().get(sessionName));
		return null; 
	}
	public void addSession(String key,Object value){
		this.getSessionMap().put(key, value);
		System.out.println(this.getSessionMap().get(key));
	}
	public void removeAttributeSession(String key){
		this.getSessionMap().remove(key);
	}

	private boolean AttributeSessionExists(String sessionName){
		return this.getSessionMap().containsKey(sessionName);
	}

}