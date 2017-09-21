package com.stackroute.activitystream.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.activitystream.backend.dao.UserDAO;
import com.stackroute.activitystream.backend.model.UserCredentials;
import com.stackroute.activitystream.backend.model.UserRegistration;

@Repository(value = "userDAO")
@Transactional
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	@Autowired 
	SessionFactory sessionFactory;

	@Override
	public UserRegistration findByEmail(String email) {
		// TODO Auto-generated method stub
		UserRegistration userRegistration = new UserRegistration();
		userRegistration = (UserRegistration) sessionFactory.getCurrentSession().get(UserRegistration.class, email);
		return userRegistration;
	}

	@Override
	public boolean saveUser(UserRegistration userRegistration) {
		// TODO Auto-generated method stub
		try {
			UserCredentials userCredentials = new UserCredentials();
			userCredentials.setUserEmail(userRegistration.getUserEmail());
			userCredentials.setUserPassword(userRegistration.getUserPassword());
			sessionFactory.getCurrentSession().save(userRegistration);
			sessionFactory.getCurrentSession().save(userCredentials);
			System.out.println(userCredentials.getUserEmail());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserRegistration userRegistration) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(userRegistration);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUserByEmail(String emailId) {
		// TODO Auto-generated method stub
		try {
			
			sessionFactory.getCurrentSession().delete(findByEmail(emailId));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<UserRegistration> findAllUsers() {
		// TODO Auto-generated method stub
		List<UserRegistration> showuser = sessionFactory.getCurrentSession().createQuery("FROM UserRegistration").list();
		return showuser;
	}
}
