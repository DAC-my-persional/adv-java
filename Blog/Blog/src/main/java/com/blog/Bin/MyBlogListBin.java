package com.blog.Bin;

import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.BlogDAO;
import com.blog.DAO.BlogDAOImpl;
import com.blog.entity.Blog;
import com.blog.entity.User;

public class MyBlogListBin {

private List<Blog> blogList;
	private User user;
	public MyBlogListBin()
	{
		this.blogList = new ArrayList<Blog>();
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void myBlogList()
	{
		try
		{
			BlogDAO blogDao = new BlogDAOImpl();
			this.blogList = blogDao.displayMyBlogs(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
