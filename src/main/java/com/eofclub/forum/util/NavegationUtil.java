package com.eofclub.forum.util;

import javax.ejb.Stateless;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Stateless
public class NavegationUtil {

	@Inject
	FacesContext context;
	
	public void redirectTo(String page){
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, page+"?faces-redirect=true");
		context.renderResponse();
	}
	
}
