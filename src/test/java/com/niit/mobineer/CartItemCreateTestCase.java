package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CartDAO;
import com.niit.mobineer.dao.CartItemDAO;
import com.niit.mobineer.dao.ProductDAO;
import com.niit.mobineer.domain.Cart;
import com.niit.mobineer.domain.CartItem;
import com.niit.mobineer.domain.Category;
import com.niit.mobineer.domain.Product;

public class CartItemCreateTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static CartItemDAO cartItemDAO;
	@Autowired
	static CartItem cartItem;
	@Autowired
	static Product product;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static CartDAO cartDAO;
	@Autowired
	static Cart cart;
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get productDAO from the context
		cartItemDAO=(CartItemDAO)context.getBean("cartItemDAO");
		
		//get productDAO from the context
		cartItem=(CartItem)context.getBean("cartItem");
	}
	
	

	@Test
	public void createCartItemTest() {
		product=new Product();
		cart=new Cart();
		product.setId("201");
		cart.setCart_Id(23);
		
		int total_price=50;
		

		
		cartItem.setSell_quantity(5);
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setTotal_price(total_price);
		

		boolean flag =  cartItemDAO.save(cartItem);

		assertEquals("createProductTestCase",true,flag);
	}

}
