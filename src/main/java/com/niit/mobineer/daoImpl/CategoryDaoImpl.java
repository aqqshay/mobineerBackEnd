package com.niit.mobineer.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.CategoryDAO;
import com.niit.mobineer.domain.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}
	public List<Category> list() {
				return  sessionFactory.getCurrentSession().createQuery("from Category where enabled = true").list();
	}

	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Category category) {

		try {
			category.setEnabled(false);
			sessionFactory.getCurrentSession().update(category);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean undelete(Category category) {

		try {
			category.setEnabled(true);
			sessionFactory.getCurrentSession().update(category);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public Category getCategoryById(String id) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id ='"+id+"'").uniqueResult();
	}
	public Category getCategoryByName(String name) {

		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where name ='"+name+"'").uniqueResult();
	}

}
