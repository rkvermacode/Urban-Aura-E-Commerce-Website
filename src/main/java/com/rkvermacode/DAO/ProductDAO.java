package com.rkvermacode.DAO;

import java.util.List;

import com.rkvermacode.Entity.ProductDetails;

public interface ProductDAO {

	public boolean addProduct(ProductDetails productDetails);
	
	public List<ProductDetails> getAllProducts();
	
	public ProductDetails getProductById(int id);
	
	public boolean editProduct(ProductDetails product);
	
	public boolean deleteProduct(int id);
	
	public List<ProductDetails> getWomenProducts();
	
	public List<ProductDetails> getRecentProducts();
	
	public List<ProductDetails> getMenProducts();
	
	public List<ProductDetails> getChildrenProduct();
	
	public List<ProductDetails> getAllRecentProduct();
	
	public List<ProductDetails> getAllMenProduct();
	
	public List<ProductDetails> getAllWomenProduct();
	
	public List<ProductDetails> getAllChildrenProduct();
	
	public List<ProductDetails> searchProducts(String characters);
}
