package com.sunbeam.testers;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.DAO.ProductDAO;
import com.sunbeam.DAO.ProductDaoImpl;
import com.sunbeam.entitiy.Product;
import com.sunbeam.utils.HibernateUtil;

public class DisplayProduct {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			
			ProductDAO productdao = new ProductDaoImpl();
			
			System.out.println("Enter the id : ");
			
			long id = sc.nextLong();
			
			Product product = productdao.displayProductById(id);
			
			System.out.println(product);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
