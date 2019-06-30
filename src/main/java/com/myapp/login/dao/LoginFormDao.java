package com.myapp.login.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LoginFormDao{

	public List<?> getPasswordFromDb(String userName);
}
