package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.Product;

public interface ProductDAO {

	public List<Product> list();

	public boolean save(Product product);				//To save the product in the DB

	public boolean update(Product product);				//To update values in the DB

	public boolean delete(Product product);				//To disable the product by ID
	
	public boolean undelete(Product product);			//To enable the product by ID
	
	public Product getProductById(Long id);			//To delete the product by ID
	
	public Product getProductByName(String name); 		//To delete the product by Product
}
