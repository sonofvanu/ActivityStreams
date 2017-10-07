package com.stackroute.activitystream.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

//Add Hibernate validations for all mandatory fields
//This comments is generate and for all other domain classes.

@Component
@Entity
public class Circle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int circleId;
	private String circleName;
	
	//if the data type is boolean - should take isActive
	//if the variable name is circleStatus - use char data type and store 'Y' OR 'N'
	private boolean circleStatus=true;
	@Temporal(TemporalType.DATE)
	private Date createdOn;
	
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn() {
		this.createdOn = new Date();
	}
	

}
