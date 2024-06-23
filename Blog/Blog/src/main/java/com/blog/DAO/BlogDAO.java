package com.blog.DAO;

import java.sql.SQLException;
import java.util.List;

import com.blog.entity.Blog;
import com.blog.entity.User;

public interface BlogDAO extends AutoCloseable{
	
	 int addBlog(Blog b) throws SQLException;
	 List<Blog>displayAllBlogs() throws SQLException;
	 void updateBlog(int id,String contents) throws SQLException;
	 void searchBlog(String blog) throws SQLException;
	 void deleteMyBlog(User u) throws SQLException;
	 List<Blog> displayMyBlogs(User u) throws SQLException;
	 int deleteBlog(int id) throws Exception;
	 
}
