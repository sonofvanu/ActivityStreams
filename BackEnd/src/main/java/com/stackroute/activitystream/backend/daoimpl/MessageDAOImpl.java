package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.backend.dao.MessageDAO;
import com.stackroute.activitystream.backend.model.CircleMessage;
import com.stackroute.activitystream.backend.model.SingleUserMessage;

@Repository(value = "messageDAO")
@Transactional
@EnableTransactionManagement
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean sendMessageToAUser(SingleUserMessage singleUserMessage) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(singleUserMessage);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean sendMessageToACircle(CircleMessage circleMessage) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(circleMessage);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean removeMessageToAUser(int messageId) {
		// TODO Auto-generated method stub
		try
		{
			SingleUserMessage singleUserMessage=sessionFactory.getCurrentSession().get(SingleUserMessage.class,messageId);
			sessionFactory.getCurrentSession().delete(singleUserMessage);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	

	@Override
	public boolean removeMessageFromACircle(int messageId) {
		// TODO Auto-generated method stub
		try
		{
			CircleMessage circleMessage=sessionFactory.getCurrentSession().get(CircleMessage.class,messageId);
			sessionFactory.getCurrentSession().delete(circleMessage);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<SingleUserMessage> allMessageToAUser(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SingleUserMessage.class);
			criteria.add(Restrictions.eq("senderId", senderId));
			criteria.add(Restrictions.eq("receiverId", receiverId));
			List<SingleUserMessage> allMessageToUser=criteria.list();
			return allMessageToUser;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<SingleUserMessage> allMessagesSentByAUser(String senderId) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SingleUserMessage.class);
			criteria.add(Restrictions.eq("senderId", senderId));
			List<SingleUserMessage> allMessagesSentByUser=criteria.list();
			return allMessagesSentByUser;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<CircleMessage> allMessageToACircle(String circleName, String senderId) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SingleUserMessage.class);
			criteria.add(Restrictions.eq("circleName", circleName));
			criteria.add(Restrictions.eq("senderId", senderId));
			List<CircleMessage> allMessageToACircle=criteria.list();
			return allMessageToACircle;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public List<CircleMessage> allMessageOfACircle(String circleName) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SingleUserMessage.class);
			criteria.add(Restrictions.eq("circleName", circleName));
			List<CircleMessage> allMessageOfCircle=criteria.list();
			return allMessageOfCircle;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
