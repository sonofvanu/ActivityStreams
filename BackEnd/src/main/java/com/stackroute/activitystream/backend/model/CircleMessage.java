package com.stackroute.activitystream.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class CircleMessage {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int messageId;
	private int circleId;
	private String messageActual;
	private String senderId;
	private boolean messageVisibility=true;
	private Date messageSentOn;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public String getMessageActual() {
		return messageActual;
	}
	public void setMessageActual(String messageActual) {
		this.messageActual = messageActual;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public boolean isMessageVisibility() {
		return messageVisibility;
	}
	public void setMessageVisibility(boolean messageVisibility) {
		this.messageVisibility = messageVisibility;
	}
	public Date getMessageSentOn() {
		return messageSentOn;
	}
	public void setMessageSentOn(Date messageSentOn) {
		this.messageSentOn = messageSentOn;
	}
	

}
