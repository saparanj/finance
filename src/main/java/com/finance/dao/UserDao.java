package com.finance.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.finance.entities.AppUser;
import com.finance.service.GenericService;
import com.finance.service.LoginService;

@Repository
@Scope("prototype")
public class UserDao{
	
	private static Logger logger = LogManager.getLogger(UserDao.class);

	public AppUser fetchAppUser(Session session, String userId) {
		logger.debug("Entering fetchAppUser");
		AppUser user = (AppUser)session.get(AppUser.class, userId);
		logger.debug("Exiting fetchAppUser");
		return user;
	}
}
