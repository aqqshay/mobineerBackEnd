package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.OrderedItems;

public interface OrderedItemsDAO {
	
	public boolean addOrderItem(OrderedItems orderItem);
	
	public List<OrderedItems> getItemsByOrderID(long orderID);
	

}
