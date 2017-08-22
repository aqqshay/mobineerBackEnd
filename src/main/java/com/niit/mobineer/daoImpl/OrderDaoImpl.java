package com.niit.mobineer.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobineer.dao.OrderDAO;
import com.niit.mobineer.domain.OrderDetails;
import com.niit.mobineer.domain.User;

@Transactional(dontRollbackOn = Exception.class)
@Repository("orderDAO")
public class OrderDaoImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createOrder(OrderDetails orderDetails) {
		
		try
		{
			// add order to the database
			sessionFactory.getCurrentSession().save(orderDetails);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateOrder(OrderDetails orderDetails) {
		try
		{
			// update order to the database
			sessionFactory.getCurrentSession().update(orderDetails);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cancelOrder(OrderDetails orderDetails) 
	{
		try 
		{
			// Delete order from database
			sessionFactory.getCurrentSession().delete(orderDetails);
			return true;
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<OrderDetails> getOrderDetailsByUser(User user) 
	{
		String selectUserId = "FROM OrderDetails where user=:parameter";
		Query<OrderDetails> query = sessionFactory.getCurrentSession().createQuery(selectUserId);
		query.setParameter("parameter", user);
		try 
		{
			return query.getResultList();
		}
		catch (Exception e) 
		{
			return null;
		}
	}


	
	
}