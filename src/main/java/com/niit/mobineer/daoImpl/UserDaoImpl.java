package com.niit.mobineer.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.UserDAO;
import com.niit.mobineer.domain.User;


@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String id, String password) {
		User user=new User();
		Query query = sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ? and enabled=?");
		query.setString(0, id);
		query.setString(1, password);
		query.setBoolean(2, true);
		if (query.uniqueResult() == null) {
			// means no row exist i.e., invalid credentials
			return false;
		} else if(user.isEnabled()==true){
			// means row exist i.e., valid credentials
			return true;
		}
		else 
		{
			return false;
		}
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User where enabled = true").list();
	}

	public User getUserById(String id) {

		return (User) sessionFactory.getCurrentSession().createQuery("from User where id ='" + id + "'").uniqueResult();
	}

	public User getUserByName(String name) {

		return (User) sessionFactory.getCurrentSession().createQuery("from User where name ='" + name + "'").uniqueResult();
	}

	public boolean delete(User user) {
		
		try {
			user.setEnabled(false);
			sessionFactory.getCurrentSession().update(user);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean undelete(User user) {
		
		try {
			user.setEnabled(true);
			sessionFactory.getCurrentSession().update(user);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}