package com.stackroute.activitystream.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserCircle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userCircleId;
	private int circleId;
	private String userId;
	private String circleName;
	private boolean circleStatus = true;
	@Temporal(TemporalType.DATE)
	private Date joinedOn;

	public int getUserCircleId() {
		return userCircleId;
	}

	public void setUserCircleId(int userCircleId) {
		this.userCircleId = userCircleId;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public boolean isCircleStatus() {
		return circleStatus;
	}

	public void setCircleStatus(boolean circleStatus) {
		this.circleStatus = circleStatus;
	}

	public Date getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn() {
		this.joinedOn = new Date();
	}

}
