package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.OrderDetails;
import com.niit.mobineer.domain.User;

public interface OrderDAO {
	
	public boolean createOrder(OrderDetails orderDetails);
	
	public boolean updateOrder(OrderDetails orderDetails);

	public boolean cancelOrder(OrderDetails orderDetails);
	
	public List<OrderDetails> getOrderDetailsByUser(User user);
	
	

}