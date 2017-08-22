package com.niit.mobineer.dao;

import com.niit.mobineer.domain.Cart;

public interface CartDAO 
{
	public boolean updateCart(Cart cart);
	public Cart getCartBycart_Id(long cart_Id);
	public boolean deleteAllCartItems(Cart cart);
}