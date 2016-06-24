package com.eofclub.forum.service;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.eofclub.forum.dao.UserDao;
import com.eofclub.forum.model.User;

@Stateless
public class LoginService {
	
	@Inject
	private UserDao userDao;
	
	public void tryLogin(String email, String password){
		Optional<User> user = this.userDao.checkLogin(email, password);
		if(user.isPresent())
			this.doLogin(user.get());
		else
			this.loginFail();
	}
	
	private void loginFail() {
		
	}
	private void doLogin(User user){
		
	}
	public void doLogout(){
		
	}
	public void isLogged(){
		
	}

}
