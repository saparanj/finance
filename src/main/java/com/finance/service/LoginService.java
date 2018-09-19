package com.finance.service;

import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finance.common.session.SessionUser;
import com.finance.dao.UserDao;
import com.finance.entities.AppUser;
import com.finance.login.LoginController;
import com.finance.processor.UserProcessor;

@Service
@Scope("prototype")
public class LoginService  extends GenericService{

	private static Logger logger = LogManager.getLogger(LoginService.class);

	
	@Autowired
	UserDao userDao;
	
	public LoginService() {
		super();
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public SessionUser validateUser(String userId, String userPassword){
		logger.debug("Entering validateUser");
		SessionUser userInSession = null;
		AppUser appUser = userDao.fetchAppUser(getCurrentHibernateSession(), userId);
		if(appUser!=null && appUser.getUserPassword().equals(userPassword)){
			userInSession = UserProcessor.mapSessioUser(appUser);
		}
		logger.debug("Exiting validateUser");
		return userInSession;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}