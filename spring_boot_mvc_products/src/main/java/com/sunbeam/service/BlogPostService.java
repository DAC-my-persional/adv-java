package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.BlogPost;

public interface BlogPostService {
//add a method to list posts by category
	List<BlogPost> getPostsByCategoryName(String catName);
	//add get all blog posts
	List<BlogPost> getAllPosts();
	//delete blog post by id
	String deleteBlogPost(Long blogPostId);
	String addNewPost(BlogPost post);
	BlogPost getBlogDetails(Long id);
	String updateBlogContents(Long id, String content);
}
