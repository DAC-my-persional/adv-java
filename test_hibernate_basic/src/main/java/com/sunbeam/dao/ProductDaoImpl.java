package com.sunbeam.dao;

import org.hibernate.*;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao{
	
	public String insertProduct(Product product) {
		String msg = "Product is not added !!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
		Serializable productId = session.save(product);
		tx.commit(); 
		msg="Product is added successfully, with ID" + productId;
	}catch (RuntimeException e) {
		if(tx != null)
			tx.rollback();
		throw e;
	}
		return msg;
	}
	
	public Product getProductById(Long productId) {
		Product product=null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			product=session.get(Product.class, productId);
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}
}
