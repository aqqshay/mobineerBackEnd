package com.niit.mobineer.dao;

import com.niit.mobineer.domain.Cart;

public interface CartDAO {

	public boolean updateCart(Cart cart);
	public boolean deleteAllCartItems(Cart cart);
	public Cart getCartByUser(String userId);
}
