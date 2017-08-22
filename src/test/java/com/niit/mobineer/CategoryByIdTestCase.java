package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CategoryDAO;
import com.niit.mobineer.domain.Category;

public class CategoryByIdTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	//above objects need to be initialize
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get CategoryDAO from the context
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		//get Category from the context
		category=(Category)context.getBean("category");
		
	}
	
	@Test
	public void getCategoryByIdtest() {
		String id="S10";
		
		boolean flag;
		if(categoryDAO.getCategoryById(id)==null)
		{
			flag=false;
		}
		else {
			flag= true;
		}
	
	assertEquals("getCategoryByIdTestCase",true,flag);
	}
	
}
