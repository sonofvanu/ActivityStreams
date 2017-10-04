package com.stackroute.activitystream.userservice;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stackroute.activitystream.backend.daoimpl.UserDAOImpl;



@SpringBootApplication(scanBasePackages="com.stackroute.activitystream.userservice")
@CrossOrigin(value="http://localhost:9050/")
@Import(UserDAOImpl.class)
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean(value = "sessionFactory")
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory) {
	    return hibernateEntityManagerFactory.getSessionFactory();
	}
}
