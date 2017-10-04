package com.stackroute.activitystream.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
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
	@Temporal(TemporalType.DATE)
	private Date messageSentOn;
	@Temporal(TemporalType.TIME)
	private Date messageSentAt;
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
	public void setMessageSentOn() {
		this.messageSentOn = new Date();
	}
	public Date getMessageSentAt() {
		return messageSentAt;
	}
	public void setMessageSentAt() {
		this.messageSentAt = new Date();
	}
	

}
