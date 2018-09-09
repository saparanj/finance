package com.finance.dao;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.finance.entities.AppUser;
import com.finance.service.GenericService;

@Repository
@Scope("prototype")
public class UserDao{
	
	public AppUser fetchAppUser(Session session, String userId) {
		AppUser user = (AppUser)session.get(AppUser.class, userId);
		return user;
	}
}
