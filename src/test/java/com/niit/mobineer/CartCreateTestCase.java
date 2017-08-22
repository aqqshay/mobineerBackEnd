package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CartDAO;
import com.niit.mobineer.dao.CartItemDAO;
import com.niit.mobineer.domain.Cart;
import com.niit.mobineer.domain.CartItem;
import com.niit.mobineer.domain.Product;
import com.niit.mobineer.domain.User;

public class CartCreateTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static CartDAO cartDAO;
	@Autowired
	static User user;
	@Autowired
	static Cart cart;
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get productDAO from the context
		cartDAO=(CartDAO)context.getBean("cartDAO");
		
		//get productDAO from the context
		cart=(Cart)context.getBean("cart");
	}
	
	

	@Test
	public void createCartItemTest() {
		user=new User();
		user.setId("akshay");
		
		cart.setUser(user);		

		boolean flag =  cartDAO.updateCart(cart);

		assertEquals("createProductTestCase",true,flag);
	}

}
