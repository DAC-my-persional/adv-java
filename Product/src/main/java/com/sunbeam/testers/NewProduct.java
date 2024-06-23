package com.sunbeam.testers;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.DAO.ProductDAO;
import com.sunbeam.DAO.ProductDaoImpl;
import com.sunbeam.entitiy.Category;
import com.sunbeam.entitiy.Product;
import com.sunbeam.utils.HibernateUtil;

public class NewProduct {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try
		{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			
			ProductDAO productdao = new ProductDaoImpl();
			
			System.out.println("Enter the Category : ");
			
			Category cat = Category.valueOf(sc.next().toUpperCase());
			
			System.out.println("Enter the product name : ");
			String productName = sc.next();
			
			System.out.println("Enter the price : ");
			double price = sc.nextDouble();
			
			System.out.println("Enter the quantity : ");
			int qty = sc.nextInt();
			
			
			Product product = new Product(cat,productName,price,qty);
		
			String message = productdao.addProduct(product);
			
			System.out.println(message);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
