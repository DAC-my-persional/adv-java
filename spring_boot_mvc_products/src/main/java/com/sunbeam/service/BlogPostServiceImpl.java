package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Tag;
import com.sunbeam.entities.User;

@Service // spring bean holding B.L ,singleton n eager
@Transactional // for automatic tx management
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired // byType
	private BlogPostDao blogPostDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CommentService commentService;

	@Autowired
	private TagDao tagDao;

	@Override
	public List<BlogPost> getPostsByCategoryName(String catName) {
		// invoke dao's method to get list of blog posts
		return blogPostDao.findBySelectedCategoryCategoryName(catName);
	}

	@Override
	public List<BlogPost> getAllPosts() {
		// TODO Auto-generated method stub
		return blogPostDao.findAll();
	}

	@Override
	public String deleteBlogPost(Long blogPostId) {
		// validate if id exists
		BlogPost post = blogPostDao.findById(blogPostId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Invalid Blog Post ID!!"));
		// => blog post exists
		// 1. delete all comments(child recs)
		String mesg = commentService.deleteComments(blogPostId);
		// To delete recs in tag_post
		// get all tags associated with a blog post
		List<Tag> tags = tagDao.findTagsByPostId(blogPostId);
		tags.forEach(tag -> tag.getPosts().remove(post));
		blogPostDao.delete(post);
		return "blog post deleted " + mesg;
	}

	@Override
	public String addNewPost(BlogPost post) {
		BlogPost blogPost = blogPostDao.save(post);
		return "Saved new blogpost with id=" + blogPost;
	}

	@Override
	public BlogPost getBlogDetails(Long id) {
		// TODO Auto-generated method stub
		return blogPostDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Blog post ID !!"));
	}
	@Override
	public String updateBlogContents(Long id, String content) {
		BlogPost blogPost = blogPostDao.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Invalid Blog post ID !!"));
		blogPost.setContent(content);
		
		return "Updated blog post cotents...";
	}

}
