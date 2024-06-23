package com.sunbeam.Beans;

import com.sunbeam.DAO.ProductDao;
import com.sunbeam.DAO.ProductDaoImpl;
import com.sunbeam.enities.Product;

public class AddProduct {

	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	
	// dependenct dao layer 
	
	private ProductDao productDao;
	
	public AddProduct()
	{
		productDao = new ProductDaoImpl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String addNewProduct()
	{
		Product product = new Product(name,price,quantity);
		
		return productDao.addProduct(product,categoryId);
	}
}
