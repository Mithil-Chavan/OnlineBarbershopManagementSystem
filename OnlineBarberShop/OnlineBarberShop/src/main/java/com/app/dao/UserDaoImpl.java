package com.app.dao;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Users;

@Repository
@Transactional // MANDATORY
public class UserDaoImpl implements IUserDao {
	// dependency
	@Autowired // auto wiring by type
	private EntityManager mgr;

	@Override
	public Users auntheticateUser(String email1, String pwd) {
		String jpql = "select u from Users u where u.emailId = :em and u.password=:pa";
		return mgr.createQuery(jpql, Users.class).setParameter("em", email1).setParameter("pa", pwd)
				.getSingleResult();
	}

	@Override
	public String registerUser(Users user) {
		
		mgr.persist(user);
		return "User registered successfully : ID "+user.getUserId();
	}

	
}
