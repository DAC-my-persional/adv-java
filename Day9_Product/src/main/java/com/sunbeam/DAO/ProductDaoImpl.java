package com.sunbeam.DAO;
import java.io.Serializable;

import org.hibernate.*;

import com.sunbeam.entitiy.Product;
import com.sunbeam.utils.HibernateUtil;

public class ProductDaoImpl implements ProductDAO {
	
	// add product 
	public String addProduct(Product product)
	{
		String  message = "Product not added !!";
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
		Transaction tr =  session.beginTransaction();
		
		try
		{
			
			Serializable userId = session.save(product);
			
			tr.commit();
			
			message = "Product Added succesfully !!";
		}catch (RuntimeException e) {
			if(tr != null)
				tr.rollback();
			
			throw e;
		}
		
		return message;
	}
	
	
	public Product displayProductById(Long id)
	{
		Product product = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tr = session.beginTransaction();
		
		try
		{
			
			 product = session.get(Product.class, id);
			 tr.commit();
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			if(tr != null)
				tr.rollback();
		}
		
		return product;
		
	}
}
