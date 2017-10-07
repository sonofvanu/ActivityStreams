package com.stackroute.activitystream.backend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.activitystream.backend.model.CircleMessage;
import com.stackroute.activitystream.backend.model.SingleUserMessage;


public interface MessageDAO {
	
	public boolean sendMessageToAUser(SingleUserMessage singleUserMessage);
	
	public boolean sendMessageToACircle(CircleMessage circleMessage);
	
	public boolean removeMessageToAUser(int messageId);
	
	public boolean removeMessageFromACircle(int messageId);
	
	public List<SingleUserMessage> allMessageToAUser(String senderId,String receiverId);
	
	public List<SingleUserMessage> allMessagesSentByAUser(String senderId);
	
	public List<CircleMessage> allMessageToACircle(String circleName,String senderId);
	
	public List<CircleMessage> allMessageOfACircle(String circleName);

}
