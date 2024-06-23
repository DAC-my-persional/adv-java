package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.entities.BlogPost;

@Service //spring bean holding B.L ,singleton n eager
@Transactional//for automatic tx management
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired //byType
	private BlogPostDao blogPostDao;

	@Override
	public List<BlogPost> getPostsByCategoryName(String catName) {
		//invoke dao's method to get list of blog posts
		return blogPostDao.getBlogPostsByCategory(catName);
	}

}
