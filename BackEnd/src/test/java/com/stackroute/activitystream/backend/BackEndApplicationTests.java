/*package com.stackroute.activitystream.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BackEndApplicationTests {

	@Autowired
	public UserDAO userDAO;
	@Autowired
	public CircleDAO circleDAO;
	@Autowired
	public UserCircleDAO userCircleDAO;
	@Autowired
	public MessageDAO messageDAO;

	public static Circle circle;
	public static UserRegistration userRegistration;
	public static UserCircle userCircle;
	public static SingleUserMessage singleUserMessage;
	public static CircleMessage circleMessage;

	@BeforeClass
	public static void ObjectCreator() {
		userRegistration = new UserRegistration();
		circle = new Circle();
		userCircle = new UserCircle();
		singleUserMessage=new SingleUserMessage();
		circleMessage=new CircleMessage();
	}

	@Test
	public void updateUser() {
		userRegistration = userDAO.findByEmail("milaga@gmail.com");
		System.out.println(userRegistration.getUserFullName());
		userRegistration.setUserAddress("Bangalore city");
		boolean updatingUser = userDAO.updateUser(userRegistration);
		assertEquals(true, updatingUser);
	}

	@Test
	public void testGetUserByEmail() {

		UserRegistration userByName = userDAO.findByEmail("milaga@gmail.com");
		assertNotNull(userByName);
		System.out.println("User Email ID :" + userByName.getUserFullName());
	}

	@Test
	public void testDeleteUser() {
		assertTrue(userDAO.deleteUserByEmail("milaga@gmail.com"));
	}

	@Test
	public void saveUser() {
		userRegistration.setUserEmail("poda@gmail.com");
		userRegistration.setUserName(" poda");
		userRegistration.setUserAddress("pakki");
		userRegistration.setUserContact(100100100);
		userRegistration.setUserFullName("im poda");
		userRegistration.setUserPassword("pikkali");
		System.out.println(userRegistration.getUserName());
		assertTrue(userDAO.saveUser(userRegistration));
	}

	@Test
	public void listOfUser() {
		List<UserRegistration> userList = userDAO.findAllUsers();
		assertNotNull(userList);
	}

	@Test
	public void createCircle() {
		circle.setCircleName("hoi");
		circle.setCreatedOn();
		assertTrue(circleDAO.createCircle(circle));

	}

	@Test
	public void updateCircle() {
		circle = circleDAO.findCircleById(1);
		circle.setCreatedOn();
		assertTrue(circleDAO.updateCircle(circle));
	}

	@Test
	public void allCircles() {
		List<Circle> listOfCircles = circleDAO.listOfAllCircles();
		assertNotNull(listOfCircles);
	}

	@Test
	public void deleteCircle() {
		assertTrue(circleDAO.deleteCircle(1));
	}

	@Test
	public void addUserTocircle() {
		circle = circleDAO.findCircleById(3);
		userCircle.setCircleId(circle.getCircleId());
		userCircle.setCircleName(circle.getCircleName());
		userCircle.setJoinedOn();
		userCircle.setUserId("milaga@gmail.com");

		assertTrue(userCircleDAO.addUserToCircle(userCircle));

	}

	@Test
	public void removeUserFromCircle() {
		assertTrue(userCircleDAO.removeUserFromCircle("milaga@gmail.com", 3));
	}

	@Test
	public void singleListUsers() {
		assertNotNull(userCircleDAO.listOfCirclesOfAuser("milaga@gmail.com"));
	}

	@Test
	public void singleUserCircleList() {
		assertNotNull(userCircleDAO.listOfUsersOfACircle("hoi"));
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
*/