package com.stackroute.activitystream.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.backend.dao.CircleDAO;
import com.stackroute.activitystream.backend.dao.MessageDAO;
import com.stackroute.activitystream.backend.dao.UserCircleDAO;
import com.stackroute.activitystream.backend.dao.UserDAO;
import com.stackroute.activitystream.backend.model.Circle;
import com.stackroute.activitystream.backend.model.CircleMessage;
import com.stackroute.activitystream.backend.model.SingleUserMessage;
import com.stackroute.activitystream.backend.model.UserCircle;
import com.stackroute.activitystream.backend.model.UserRegistration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageTestCase {

	@Autowired
	public UserDAO userDAO;
	@Autowired
	public CircleDAO circleDAO;
	@Autowired
	public MessageDAO messageDAO;

	public static Circle circle;
	public static UserRegistration userRegistration;
	public static UserCircle userCircle;
	public static SingleUserMessage singleUserMessage;
	public static CircleMessage circleMessage;

	@BeforeClass
	public static void ObjectCreator() {
		singleUserMessage=new SingleUserMessage();
		circleMessage=new CircleMessage();
	}

	
	@Test
	public void sendUsermessage()
	{
		singleUserMessage.setMessageActual("hello how are you");
		singleUserMessage.setMessageSentOn();
		singleUserMessage.setMessageSentAt();
		userRegistration=userDAO.findByEmail("milaga@gmail.com");
		singleUserMessage.setSenderId(userRegistration.getUserEmail());
		userRegistration=userDAO.findByEmail("poda@gmail.com");
		singleUserMessage.setReceiverId(userRegistration.getUserEmail());
		assertTrue(messageDAO.sendMessageToAUser(singleUserMessage));
	}
	
	@Test
	public void sendCircleMessage()
	{
		circle=circleDAO.findCircleById(2);
		circleMessage.setCircleId(circle.getCircleId());
		circleMessage.setMessageActual("hello pakkis");
		circleMessage.setMessageSentOn();
		circleMessage.setMessageSentAt();
		userRegistration=userDAO.findByEmail("poda@gmail.com");
		circleMessage.setSenderId(userRegistration.getUserEmail());
		messageDAO.sendMessageToACircle(circleMessage);
	}

}
