package com.sunbeam.entities;

import javax.persistence.*;

/* 
 * 
Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
product name(unique)  , price , available quantity
 * */
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // FOR MYSQL IDENTITY IS USED
	private Long id; /// we want serializable 
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Category category;
	
	@Column (length = 25, unique=true)
	private String product_name;
	
	private double price;
	
	private int available_quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Category category, String product_name, double price, int available_quantity) {
		super();
		this.category = category;
		this.product_name = product_name;
		this.price = price;
		this.available_quantity = available_quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", product_name=" + product_name + ", price=" + price
				+ ", available_quantity=" + available_quantity + "]";
	}
	
	
	
	
	
}
