package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

//, category (BAKERY|SHOES|CLOTHES|STATIONAY) 
//,product name(unique) 
//, price , available quantity

public class RegisterProduct {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in);
				)
		{
			ProductDao dao = new ProductDaoImpl(); 
			System.out.println("Enter Product details - category, String product_name,double price, int available_quantity");
			
			Product newProduct = new Product(Category.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextDouble(),sc.nextInt());
			
			System.out.println(dao.insertProduct(newProduct));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
