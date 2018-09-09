package com.finance.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotNull(message=" is required")
	@Size(min=6, max=10, message=" should be at least 6 characters and at the most 10 characters")
	private String userId;
	
	@NotNull(message=" is required")
	@Size(min=6, max=20, message=" should be at least 6 characters and at the most 20 characters")
	private String userpassword;
	
	private String errorMessage;

	public LoginForm() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LoginForm [userId=" + userId + ", userpassword=" + userpassword + ", errorMessage=" + errorMessage
				+ "]";
	}


	
	
}
