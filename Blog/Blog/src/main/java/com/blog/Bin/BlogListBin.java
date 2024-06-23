package com.blog.Bin;

import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.BlogDAO;
import com.blog.DAO.BlogDAOImpl;
import com.blog.entity.Blog;

public class BlogListBin {
	private List<Blog> blogList;
	private int userId;
	private int candidateId;
	private Blog blog;
	private int count;
	public BlogListBin()
	{
		this.blogList = new ArrayList<Blog>();
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public int getCount()
	{
		return count;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}
	
	public void fecthBlogs()
	{
		try
		{
			BlogDAO blogDao = new BlogDAOImpl();
			
			 blogList = blogDao.displayAllBlogs();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBlogs()
	{
		try
		{	
			BlogDAO blogDao = new BlogDAOImpl();
			count = blogDao.addBlog(blog);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
