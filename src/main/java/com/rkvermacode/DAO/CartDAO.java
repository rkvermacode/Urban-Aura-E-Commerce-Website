package com.rkvermacode.DAO;

import java.util.List;

import com.rkvermacode.Entity.Cart;

public interface CartDAO {
	
	public boolean addCart(Cart cart);
	
	public List<Cart> getProductByUser(int userId);
	
	public boolean deleteProduct(int pid, int uid, int cid);
}
