package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
	String insertProduct(Product product); 
	
	public Product getProductById(Long productId);
}
