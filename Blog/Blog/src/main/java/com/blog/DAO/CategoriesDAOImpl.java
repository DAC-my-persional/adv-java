package com.blog.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.entity.Categories;

public class CategoriesDAOImpl extends DAO implements CategoriesDAO {

	public CategoriesDAOImpl() throws Exception {
		
	}

	public List<Categories> showCategories() throws SQLException 
	{
		String query = "Select * from categories";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Categories > categoryList = new ArrayList<>();
		
		while(result.next())
		{
			Categories category= new Categories();
			category.setId(result.getInt(1));
			category.setTitle(result.getString(2));
			category.setDescription(result.getString(3));
			categoryList.add(category);
		}
		return categoryList;
	}
	
	public void addCategories(Categories c) throws SQLException
	{
		String query = "insert into categories (title,description) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
//		statement.setInt(1, c.getId());
		statement.setString(1, c.getTitle());
		statement.setString(2, c.getDescription());
		statement.executeUpdate();
	}
	
}
