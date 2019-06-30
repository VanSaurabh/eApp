package com.myapp.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.login.dao.LoginFormDao;
import com.myapp.login.pojo.LoginForm;

@Service
public class LoginService {

	@Autowired
	private LoginFormDao loginFormDao;
	
	public boolean validatelogin(LoginForm form){
		if(null != form.getUserName()){
			String paswrdFromDb = getPasswordFromDb(form.getUserName());
			if(paswrdFromDb.equals(form.getPassword()))
				return true;
			else
				return false;
		}else
			return false;
	}

	private String getPasswordFromDb(String userName) {
		List<? extends Object> passwordList = loginFormDao.getPasswordFromDb(userName);
		if(!passwordList.isEmpty())
			return (String) passwordList.get(0);
		else
			return "";
	}
	
	public LoginFormDao getLoginFormDao() {
		return loginFormDao;
	}

	public void setLoginFormDao(LoginFormDao loginFormDao) {
		this.loginFormDao = loginFormDao;
	}
}
