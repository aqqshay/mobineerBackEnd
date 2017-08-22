package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.ProductDAO;
import com.niit.mobineer.domain.Product;

public class ProductByIdTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get productDAO from the context
		productDAO=(ProductDAO)context.getBean("productDAO");
		
		//get productDAO from the context
		product=(Product)context.getBean("product");
	}
	
	

	@Test
	public void getProductByIdTest() {
		String id= "A3000";
		boolean flag;
		if(productDAO.getProductById(id)==null)
		{
			flag=false;
		}
		else
		{
			flag=true;
		}
		
		assertEquals("getProductByIdTestCase",true,flag);
	}

}
