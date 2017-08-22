package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.UserDAO;
import com.niit.mobineer.domain.User;

public class UserDeleteTestCase {
	
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
	public void deleteUserTest() {
		String id="akshay";
		
		user = userDAO.getUserById(id);
		
		boolean flag=userDAO.delete(user);
		
		assertEquals("deleteUserValidateTestCase", true, flag);
	}

}
