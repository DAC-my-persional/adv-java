package com.blog.DAO;

import java.sql.SQLException;
import java.util.List;

import com.blog.entity.Categories;

public interface CategoriesDAO extends AutoCloseable {
	List<Categories> showCategories() throws SQLException;
	void addCategories(Categories c) throws SQLException;
}
