package com.finance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APP_USER")
public class AppUser {
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="USER_PWD")
	private String userPassword;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_TYPE")
	private String userType;

	@Column(name="USER_PAN")
	private String userPan;
	
	@Column(name="USER_CAN")
	private String userCan;
	
	@Column(name="USER_AADHAAR")
	private String userAadhaar;
	
	@Column(name="USER_STATUS")
	private int userStatus = 1; // 1 Active 0 Inactive
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
}