package com.myapp.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.registration.dao.RegistrationFormDao;
import com.myapp.registration.pojo.RegistrationForm;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationFormDao registrationFormDao;
	
	public boolean isUniqueUserName(String userName){
		return registrationFormDao.isUniqueUserName(userName).isEmpty();
	}

	public void doRegistrationOfNewUser(RegistrationForm registrationForm) {
		registrationFormDao.persistNewUserToDB(registrationForm);
		
	}
	
	public RegistrationFormDao getRegistrationFormDao() {
		return registrationFormDao;
	}

	public void setRegistrationFormDao(RegistrationFormDao registrationFormDao) {
		this.registrationFormDao = registrationFormDao;
	}
}
