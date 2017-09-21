package com.stackroute.activitystream.backend.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserCredentials {
	@Id
	private String userEmail;
	private String userPassword;
	private String userRole = "ROLE_USER";
	private boolean userStatus = true;

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public boolean isUserStatus() {
		return userStatus;
	}
	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	
}
