package com.stackroute.activitystream.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SingleUserMessage {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int messageId;
	private String messageActual;
	private String senderId,receiverId;
	private boolean messageVisibility=true;
	private Date messageSentOn;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
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
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
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
