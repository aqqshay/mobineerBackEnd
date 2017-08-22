package com.niit.mobineer;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobineer.dao.CategoryDAO;
import com.niit.mobineer.domain.Category;

public class CategoryUpdateTestCase {
	
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
	public void updateCategorytest() {
		
		String id="404";
		boolean enabled=true;
		category = categoryDAO.getCategoryById(id);
		
		category.setEnabled(enabled);
		boolean flag= categoryDAO.update(category);
		
		assertEquals("updateCategoryTestCase", true, flag);
	}

}
