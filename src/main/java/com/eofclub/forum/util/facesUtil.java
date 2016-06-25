package com.eofclub.forum.util;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Stateless
public class facesUtil {
	
	@Inject
	FacesContext faces;	
	
	public void errorMensage(String message){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		faces.addMessage(null, facesMessage);
	}
	
	public void sucessMessage(String message){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		faces.addMessage(null, facesMessage);
	}
	
	public Optional<Object> getSession(String sessionName){
		Optional<Object> attribute = Optional.of(this.getExternalContext().getSessionMap().get(sessionName));
		return attribute; 
	}
	public void addSession(String key,Object value){
		this.getExternalContext().getSessionMap().put(key, value);
	}
	
	private ExternalContext getExternalContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
}
