package com.finance.common.session;

import javax.persistence.Column;
import javax.persistence.Id;

public class SessionUser {
	private String userId;
	
	private String userName;
	
	private String userType;

	private String userPan;
	
	private String userCan;
	
	private String userAadhaar;
	
	public SessionUser() {
		
	}
	
	public SessionUser(String userId, String userName, String userType, String userPan, String userCan, String userAadhaar) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.userPan = userPan;
		this.userCan = userCan;
		this.userAadhaar = userAadhaar;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPan() {
		return userPan;
	}

	public void setUserPan(String userPan) {
		this.userPan = userPan;
	}

	public String getUserCan() {
		return userCan;
	}

	public void setUserCan(String userCan) {
		this.userCan = userCan;
	}

	public String getUserAadhaar() {
		return userAadhaar;
	}

	public void setUserAadhaar(String userAadhaar) {
		this.userAadhaar = userAadhaar;
	}
	

}
