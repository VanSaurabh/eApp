package com.myapp.registration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.registration.pojo.RegistrationForm;

@Repository
@Transactional
public interface RegistrationFormDao{
	
	public List<? extends Object> isUniqueUserName(String userName);

	public void persistNewUserToDB(RegistrationForm registrationForm);
}
