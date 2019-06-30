package com.myapp.registration.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.login.pojo.LoginForm;
import com.myapp.registration.dao.RegistrationFormDao;
import com.myapp.registration.pojo.RegistrationForm;
import com.util.HibernateUtil;

@Repository
@Transactional
public class RegistrationFormDaoImpl implements RegistrationFormDao{

	public List<?> isUniqueUserName(String userName){
		String queryString = "select rd.userName from RegistrationForm rd where rd.userName =:userName";
		Query query = HibernateUtil.getEntityManager().createQuery(queryString);
		query.setParameter("userName", userName);
		return query.getResultList();
	}

	@Override
	public void persistNewUserToDB(RegistrationForm registrationForm) {
		RegistrationForm regForm = new RegistrationForm();
		regForm.setFirstName(registrationForm.getFirstName());
		regForm.setLastName(registrationForm.getLastName());
		regForm.setEmail(registrationForm.getEmail());
		regForm.setDateOfBirth(registrationForm.getDateOfBirth());
		regForm.setPhoneNumber(registrationForm.getPhoneNumber());
		regForm.setAddress(registrationForm.getAddress());
		regForm.setUserName(registrationForm.getUserName());
		regForm.setPassword(registrationForm.getPassword());
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(regForm);
		em.getTransaction().commit();
		doPopulateLoginDetailsTable(regForm);
	}

	private void doPopulateLoginDetailsTable(RegistrationForm regForm) {
		LoginForm loginForm = new LoginForm();
		loginForm.setPassword(regForm.getPassword());
		loginForm.setUserName(regForm.getUserName());
		loginForm.setRegistrationForm(regForm);
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(loginForm);
		em.getTransaction().commit();
		
	}
}
