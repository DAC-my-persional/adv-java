package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.BlogPost;

@Repository //to tell SC - following class is a spring bean(singleton n eager)
// containing DAL 
public class BlogPostDaoImpl implements BlogPostDao {
	//depcy 
	@Autowired //autowire=byType
	private SessionFactory factory;

	@Override
	public List<BlogPost> getBlogPostsByCategory(String categoryName) {
		String jpql="select p from BlogPost p where p.selectedCategory.categoryName =:cat";
		return factory.getCurrentSession() //Session
				.createQuery(jpql,BlogPost.class)
				.setParameter("cat", categoryName)
				.getResultList();
	}

}
