package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.User;

public interface UserDAO {
	
	public List<User> list();											//To get all the users from DB
	
	public boolean save(User user);										//To save the details of the user
	
	public boolean update(User user);									//To update the details of the user
	
	public boolean delete(User user);									//To disable the category from DB
	
	public boolean undelete(User user);									//To enable the category from DB
	
	public boolean validate(String id, String name);					//To validate the user credentials
	
	public User getUserById(String id);									//To get the details of the user from DB via ID
	
	public User getUserByName(String name);								//To get the details of the user from DB via name
	
}
