package com.eofclub.forum.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesUtil {

	@Produces @RequestScoped FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
}
