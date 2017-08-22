package com.niit.mobineer.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.CartItemDAO;
import com.niit.mobineer.domain.*;;


@Transactional
@Repository("cartItemDAO")
public class CartItemDaoImpl implements CartItemDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(CartItem cartItem) 
	{
		try
		{
			// add cart item to the database
			sessionFactory.getCurrentSession().save(cartItem);
			// sessionFactory.getCurrentSession().evict(cartItem);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	public List<CartItem> cartItemGetByCart(Cart cart)
	{
		String selectCartId = "FROM CartItem where cart=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId);
		query.setParameter("parameter", cart);
		try 
		{
			return query.getResultList();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public boolean update(CartItem cartItem) 
	{
		try 
		{
			
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	public boolean delete(CartItem cartItem) 
	{
		try 
		{
			// Delete the cartItem from database
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public CartItem getCartItemById(Long cartItem_Id)
	{
		String selectCartId = "FROM CartItem where cartItem_Id=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter", cartItem_Id);
		try 
		{
			return query.getSingleResult();
		}
		catch (Exception ex) 
		{
			return null;
		}
	}

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product) 
	{
		String selectCartId = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try 
		{
			return query.getSingleResult();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product) 
	{
		String selectCartId = "FROM CartItem where cart=:parameter1 and product=:parameter2";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter1", cart);
		query.setParameter("parameter2", product);
		try 
		{
			 query.getSingleResult();
			 return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	
	

}
