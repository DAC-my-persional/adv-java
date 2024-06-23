package com.blog.Bin;

import com.blog.DAO.BlogDAO;
import com.blog.DAO.BlogDAOImpl;

public class DeleteBlogBin {
	private int id;
	private  int count;
	
	
	
	public DeleteBlogBin() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void deleteCandidate()
	{
		try
		{
			BlogDAO blogDAO = new BlogDAOImpl();
			count = blogDAO.deleteBlog(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
