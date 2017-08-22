package com.niit.mobineer.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.CartDAO;
import com.niit.mobineer.domain.Cart;
import com.niit.mobineer.domain.Product;


@Transactional
@Repository("cartDAO")
public class CartDaoImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;


	public boolean updateCart(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	public Cart getCartByUser(String userId) 
	{
		return (Cart) sessionFactory.getCurrentSession().createQuery("from Product where id ='"+userId+"'").uniqueResult();
	}

	public boolean deleteAllCartItems(Cart cart) 
	{
		try 
		{
			String selectCartId = "DELETE FROM CartItem WHERE cart=:parameter";
			Query query = sessionFactory.getCurrentSession().createQuery(selectCartId);
			query.setParameter("parameter", cart);
			System.out.println(query.executeUpdate());
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
			return false;
		}

	}

	
	

}
