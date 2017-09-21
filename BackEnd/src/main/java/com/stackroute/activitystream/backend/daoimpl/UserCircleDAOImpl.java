package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.backend.dao.UserCircleDAO;
import com.stackroute.activitystream.backend.model.UserCircle;


@Repository(value = "userCircleDAO")
@Transactional
@EnableTransactionManagement
public class UserCircleDAOImpl implements UserCircleDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUserToCircle(UserCircle userCircle) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(userCircle);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean removeUserFromCircle(String userId, int circleId) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(UserCircle.class);
			criteria.add(Restrictions.eq("userId", userId)).add(Restrictions.eq("circleId", circleId));
			List<UserCircle> matchedUserCircle=criteria.list();
			if(matchedUserCircle.size()>=1)
			{
				UserCircle userCircle=matchedUserCircle.get(0);
				sessionFactory.getCurrentSession().delete(userCircle);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<UserCircle> listOfCirclesOfAuser(String userId) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(UserCircle.class);
			criteria.add(Restrictions.eq("userId",userId ));
			List<UserCircle> listOfCircleOfUser=criteria.list();
			if(listOfCircleOfUser.size()>=1)
			{
				return listOfCircleOfUser;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return null;	
		}
		
	}

	@Override
	public List<UserCircle> listOfUsersOfACircle(String circleName) {
		// TODO Auto-generated method stub
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(UserCircle.class);
			criteria.add(Restrictions.eq("circleName", circleName));
			List<UserCircle> listOfUsersOfCircle=criteria.list();
			if(listOfUsersOfCircle.size()>=1)
			{
				return listOfUsersOfCircle;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
