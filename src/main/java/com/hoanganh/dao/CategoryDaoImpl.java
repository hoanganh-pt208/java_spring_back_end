package com.hoanganh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hoanganh.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method get List Category
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getListCategory() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class, "tag");
		criteria.addOrder(Order.asc("id"));
		List<Category> categoryList = criteria.list();
		return categoryList;
	}
}
