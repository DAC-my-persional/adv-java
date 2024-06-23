package com.sunbeam.DAO;

import com.sunbeam.entitiy.Product;

public interface ProductDAO {

	String addProduct(Product product);
	Product displayProductById(Long id);
}
