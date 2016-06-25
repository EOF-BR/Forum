package com.eofclub.forum.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.eofclub.forum.service.LoginService;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private LoginService loginService;
	private String email;
	private String password;
		
	public void checa(){
		loginService.tryLogin(this.email, this.password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
