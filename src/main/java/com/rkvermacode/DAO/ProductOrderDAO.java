package com.rkvermacode.DAO;

import java.util.List;

import com.rkvermacode.Entity.Product_Order;

public interface ProductOrderDAO {
	
	public boolean saveOrder(List<Product_Order> pList);
	
	public List<Product_Order> getProduct(String email);
	
	public List<Product_Order> getAllOrders();
}
