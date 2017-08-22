package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.Category;

public interface CategoryDAO {
	
	public List<Category> list();

	public boolean save(Category category);				//To save the category in the DB

	public boolean update(Category category);				//To update values in the DB

	public boolean delete(Category category);				//To disable the category from DB
	
	public boolean undelete(Category category);				//To enable the category from DB
	
	public Category getCategoryById(String id);			//To delete the category by ID
	
	public Category getCategoryByName(String name); 		//To delete the category by Category

}
