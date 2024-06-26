package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.BlogPost;

public interface BlogPostDao extends JpaRepository<BlogPost, Long> {
//add a method to return list of blog posts by specified category name
	List<BlogPost> 
	findBySelectedCategoryCategoryName(String catName);
}
