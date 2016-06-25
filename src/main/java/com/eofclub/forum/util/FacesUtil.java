package com.eofclub.forum.util;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Stateless
public class FacesUtil {
	
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
	
}
