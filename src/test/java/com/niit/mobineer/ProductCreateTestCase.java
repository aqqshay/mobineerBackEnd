package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CategoryDAO;
import com.niit.mobineer.dao.ProductDAO;
import com.niit.mobineer.domain.Category;
import com.niit.mobineer.domain.Product;

public class ProductCreateTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	@Autowired
	static Category category;
	@Autowired
	static CategoryDAO categoryDAO;
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
	public void createProductTest() {
		category=new Category();
		category.setId("455");
		
		product.setId("200");
		product.setName("Woodland Jeans");
		product.setDescription("Premium Woodland Jeans");
		product.setPrice(3999);
		product.setEnabled(true);
		product.setCategory(category);
		

		boolean flag =  productDAO.save(product);

		assertEquals("createProductTestCase",true,flag);
	}

}
