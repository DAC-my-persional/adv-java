package com.sunbeam.DAO;

import java.util.List;

import com.sunbeam.enities.Product;


public interface ProductDao {

	String addProduct(Product product,Long productCategory);
	List<Product> getProductList(Long categoryId);
	String purchaseProduct(int qty , Long id);
}
