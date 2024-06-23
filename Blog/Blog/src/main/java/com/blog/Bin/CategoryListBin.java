package com.blog.Bin;

import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.CategoriesDAO;
import com.blog.DAO.CategoriesDAOImpl;
import com.blog.entity.Categories;

public class CategoryListBin {
	private int id;
	private List<Categories> categroiesList;

	public CategoryListBin()
	{
		this.categroiesList = new ArrayList<Categories>();
	}
	
	public void setInt(int id)
	{
		this.id = id;
	}
	
	public int getInt()
	{
		return id;
	}
	
	public List<Categories> getCategroiesList() {
		return categroiesList;
	}

	public void setCategroiesList(List<Categories> categroiesList) {
		this.categroiesList = categroiesList;
	}


	public void fetchCategories()
	{
		try
		{
			CategoriesDAO catDao = new CategoriesDAOImpl();
			 categroiesList = catDao.showCategories();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
