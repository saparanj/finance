package com.finance.processor;

import org.springframework.stereotype.Component;

import com.finance.common.session.SessionUser;
import com.finance.entities.AppUser;

@Component
public class UserProcessor {
	public static SessionUser mapSessioUser(AppUser appUser) {
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUserId(appUser.getUserId());
		sessionUser.setUserName(appUser.getUserName());
		sessionUser.setUserCan(appUser.getUserCan());
		sessionUser.setUserAadhaar(appUser.getUserAadhaar());
		sessionUser.setUserPan(appUser.getUserPan());
		
		return sessionUser;
	}
}
