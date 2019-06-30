package com.myapp.login.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.login.dao.LoginFormDao;
import com.util.HibernateUtil;

@Repository
@Transactional
public class LoginFormDaoImpl implements LoginFormDao{

	@Override
	public List<?> getPasswordFromDb(String userName){
		String queryString = "select l.password from LoginForm l where l.userName =:userName";
		Query query = HibernateUtil.getEntityManager().createQuery(queryString);
		query.setParameter("userName", userName);
		return query.getResultList();
	}
}
