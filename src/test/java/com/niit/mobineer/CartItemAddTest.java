package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CartItemDAO;
import com.niit.mobineer.dao.ProductDAO;
import com.niit.mobineer.domain.CartItem;
import com.niit.mobineer.domain.Category;
import com.niit.mobineer.domain.Product;
import com.niit.mobineer.domain.User;

public class CartItemAddTest {
	
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static CartItemDAO cartItemDAO;
	@Autowired
	static CartItem cartItem;
	@Autowired
	static User user;
	@BeforeClass
	public static void initialize()
	{
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
