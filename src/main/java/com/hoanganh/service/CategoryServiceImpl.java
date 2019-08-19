package com.hoanganh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.dao.CategoryDao;
import com.hoanganh.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * Method get List Category
	 */
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getListCategory();
	}
}
