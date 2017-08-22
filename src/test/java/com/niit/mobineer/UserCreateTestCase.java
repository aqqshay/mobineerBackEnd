package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.UserDAO;
import com.niit.mobineer.domain.User;

public class UserCreateTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static UserDAO userDAO;
	
	@Autowired static User user;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
		user=(User)context.getBean("user");
	}

	@Test
	public void createUserTest() {
		
		user.setId("akshay");
		user.setPassword("akshay");
		user.setName("Askhay");
		user.setContact("9876543210");
		user.setRole("ROLE_ADMIN");
		user.setMail("ab@c.com");
		user.setEnabled(true);
		
		boolean flag=userDAO.save(user);
		
		assertEquals("createUserTestCase", true, flag);
	}

}
