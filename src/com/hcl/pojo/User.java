package com.hcl.pojo;

/**
 * all copy rights reserved to user pravalika
 */

public class User {
	private String userName;
	private String emailId;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", emailId=" + emailId + ", password=" + password + "]";
	}

	public User(String userName, String emailId, String password) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
