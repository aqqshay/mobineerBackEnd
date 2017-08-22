package com.niit.mobineer.dao;

import java.util.List;

import com.niit.mobineer.domain.Cart;
import com.niit.mobineer.domain.CartItem;
import com.niit.mobineer.domain.Product;

public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(CartItem cartItem);

	public CartItem getCartItemByCartItem_Id(Long cartItem_Id);

	public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);
	
	public boolean deleteCartItemByProductId(long pid);
	
	public CartItem searchCartItemByUserIdAndProductId(Cart cart,Product product);

	//public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product);
}