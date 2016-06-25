package com.eofclub.forum.service;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.eofclub.forum.dao.UserDao;
import com.eofclub.forum.model.User;
import com.eofclub.forum.util.FacesUtil;
import com.eofclub.forum.util.SessionUtil;

@Stateless
public class LoginService {
	
	@Inject private UserDao userDao;
	@Inject private FacesUtil facesUtil;
	@Inject private SessionUtil sessionUtil;
	
	private final String LoginSessionName = "user.logged";
	
	public void tryLogin(String email, String password){
		Optional<User> user = this.userDao.checkLogin(email, password);
		if(user.isPresent())
			this.doLogin(user.get());
		else
			this.loginFail();
	}
	private void loginFail() {
		facesUtil.errorMensage("login Fail");
	}
	private void doLogin(User user){
		sessionUtil.addSession(LoginSessionName, user);
	}
	public void doLogout(){
		sessionUtil.removeAttributeSession(LoginSessionName);
	}
	public boolean isLogged(){
		if(sessionUtil.getSession(LoginSessionName).isPresent())
			return true;
		else
			return false;
	}

}
