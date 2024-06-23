package com.sunbeam.enities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "product")
public class Product extends BaseEntitity {
	
	@Column (unique = true , length = 50)
	private String productName;
	
	private double price;
	
	private int quantity;
	
	// many to one 
	// Product *---->1 Category 
	
	@ManyToOne
	@JoinColumn(name ="category_id", nullable = false)
	private Category productCategory;
	
	public Product()
	{
		
	}

	public Product(String productName, double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Category getCategory() {
		return productCategory;
	}

	public void setCategory(Category category) {
		this.productCategory = category;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", quantity=" + quantity + ", category="
				+ productCategory + "]";
	}
	
}
