package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.Cart;
import com.niit.mobineer.domain.CartItem;
import com.niit.mobineer.domain.Product;

public interface CartItemDAO {

	public List<CartItem> cartItemGetByCart(Cart cart);
	
	public boolean save(CartItem cartItem);
	public boolean update(CartItem cartItem) ;
	public boolean delete(CartItem cartItem) ;
	public CartItem getCartItemById(Long cartItem_Id);
	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product) ;
	public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product) ;
}
