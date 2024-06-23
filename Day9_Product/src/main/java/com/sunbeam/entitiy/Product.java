package com.sunbeam.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	
	@Column(name = "product_name",length = 30)
	private String produtName;
	
	
	private double price;
	
	@Column(name = "available_quantity")
	private int availableQuantity;
	
	public Product()
	{
		
	}

	public Product(Category category, String produtName, double price, int availableQuantity) {
		super();
		this.category = category;
		this.produtName = produtName;
		this.price = price;
		this.availableQuantity = availableQuantity;
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

	public String getProdutName() {
		return produtName;
	}

	public void setProdutName(String produtName) {
		this.produtName = produtName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", produtName=" + produtName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
	
	
	
	
}
