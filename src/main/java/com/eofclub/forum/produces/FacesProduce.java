package com.eofclub.forum.produces;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesProduce {

	@Produces @RequestScoped FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
}
