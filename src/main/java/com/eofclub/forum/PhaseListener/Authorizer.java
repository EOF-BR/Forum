package com.eofclub.forum.PhaseListener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Authorizer implements PhaseListener{

	private static final long serialVersionUID = -4637128526497495069L;


	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String page = context.getViewRoot().getViewId();
		this.isAuthorizedToSeeThisPage(page);
	}

	
	private void isAuthorizedToSeeThisPage(String page) {
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
