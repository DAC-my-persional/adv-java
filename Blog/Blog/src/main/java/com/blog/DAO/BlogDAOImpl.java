package com.blog.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.entity.Blog;
import com.blog.entity.User;

public class BlogDAOImpl extends DAO implements BlogDAO {

	public BlogDAOImpl() throws Exception {
		
	}

	public int addBlog(Blog b) throws SQLException
	{
		String query = "insert into blogs (title,contents,user_id,category_id) values (?,?,?,?)"; 
		PreparedStatement statement = connection.prepareStatement(query);
//		statement.setInt(1, b.getId());
		statement.setString(1, b.getTitle());
		statement.setString(2, b.getContents());
		statement.setInt(3,b.getUserId());
		statement.setInt(4, b.getCategoryId());
		
		int count = statement.executeUpdate();
		return count;
	}
	
	
	public List<Blog>displayAllBlogs() throws SQLException 
	{
		String query = "Select * from blogs";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Blog > blogsList = new ArrayList<>();
		
		while(result.next())
		{
			Blog blog = new Blog();
			blog.setId(result.getInt(1));
			blog.setTitle(result.getString(2));
			blog.setContents(result.getString(3));
			blog.setUserId(result.getInt(5));
			blog.setCategoryId(result.getInt(6));
		
			blogsList.add(blog);
		}
		return blogsList;
	}
	
	
	public void updateBlog(int id,String contents) throws SQLException
	{
		String query = "update blogs set contents = ?  where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, contents);
			statement.setInt(2, id);
			statement.executeUpdate();	
	}
	
	
	public void searchBlog(String blog) throws SQLException
	{
		String query = "select * from blogs";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet set = statement.executeQuery();
		
		while(set.next())
		{
			Blog bl = new Blog();
			bl.setContents(set.getString(3));
			String []arr = bl.getContents().split(" ");
			for(String word:arr)
			{
				if(word.equalsIgnoreCase(blog))
				{
					System.out.println("Blog id : "+set.getInt(1));
					System.out.println("Contents : "+bl.getContents());
				}
			}
		}
	}
	
	public void deleteMyBlog(User u) throws SQLException{
		String sql = "delete from blogs where user_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,u.getId());
		System.out.println(u.getId());
		int rowsAffected = statement.executeUpdate();
		if(rowsAffected > 0)
		{
			System.out.println(u.getId()+"Blog id deleted successfully !!");
		}
		else
			System.out.println("Blog is not present !!!");
	}
	
	
	public List<Blog> displayMyBlogs(User u) throws SQLException {
		String sql = "select * from blogs where user_id = ? ";
		
		List<Blog> myBlogList = new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, u.getId());
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Blog blog = new Blog();
			blog.setId(rs.getInt(1));
			blog.setContents(rs.getString(2));
			blog.setTitle(rs.getString(3));
			blog.setUserId(rs.getInt(5));
			blog.setCategoryId(rs.getInt(6));
			myBlogList.add(blog);
		}
		return myBlogList;
		
	}
	
	public int deleteBlog(int id) throws Exception {
		String sql = "DELETE FROM blogs WHERE id=?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}
	
}
