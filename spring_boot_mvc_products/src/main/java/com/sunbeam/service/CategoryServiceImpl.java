package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.entities.Category;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
