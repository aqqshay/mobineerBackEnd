package com.niit.mobineer.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.ProductDAO;
import com.niit.mobineer.domain.Category;
import com.niit.mobineer.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}
	public List<Product> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Product where enabled = true").list();
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Product product) {

		try {
				product.setEnabled(false);
				sessionFactory.getCurrentSession().update(product);
				return true;
				
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean undelete(Product product) {

		try {
				product.setEnabled(true);
				sessionFactory.getCurrentSession().update(product);
				return true;
				
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public Product getProductById(Long id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product where id ='"+id+"'").uniqueResult();
	}
	public Product getProductByName(String name) {

		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where name ='"+name+"'").uniqueResult();
	}

}
