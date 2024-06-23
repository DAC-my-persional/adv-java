
package com.sunbeam.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.enities.Category;
import com.sunbeam.enities.Product;
import com.sunbeam.utils.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product,Long categoryId) {
		
		String message = "Product not added !!";
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tr = session.beginTransaction();
		
		try
		{
			
			Category category = session.get(Category.class, categoryId);
			
			if(category != null)	
			{
				category.addProduct(product);
				
				message = "Product Added Successfully !!";
			}
			
			tr.commit();
			
		}catch (RuntimeException e) {
			
			if(tr != null)
				tr.rollback();
			
			throw e;
		}
		
		
		return message;
	}

	@Override
	public List<Product> getProductList(Long categoryId) {
		List<Product> productList = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tr = session.beginTransaction();
		
		try
		{
			
			String jpql = "select p from Product p where p.productCategory = :cat";
			
			productList = session.createQuery(jpql,Product.class).setParameter("cat",categoryId).getResultList();
			
			tr.commit();
		}catch (RuntimeException e) {
			
			if(tr != null)
				tr.rollback();
			
			throw e;
		}
		
		return productList;
	}

	@Override
	public String purchaseProduct(int qty, Long id) {
		String message = "Product not added !!";
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tr = session.beginTransaction();
		
		try
		{
			Product product = session.get(Product.class, id);
			
			if(product != null)
			{
				product.setQuantity(product.getQuantity()-qty);
				
				tr.commit();
				
				message = "product purchased successfully !!";
			}
			
		}catch (RuntimeException e) {
			if(tr != null)
				tr.rollback();
			
			throw e;
		}
		
		return message;
	}
	
	

	
}
