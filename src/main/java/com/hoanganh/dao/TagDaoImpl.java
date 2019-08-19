package com.hoanganh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hoanganh.model.Tag;

@Repository
public class TagDaoImpl implements TagDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method get List Tag
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> getTagList() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Tag.class, "tag");
		criteria.add(Restrictions.ne("id", 1));
		criteria.addOrder(Order.asc("id"));
		List<Tag> tagList = criteria.list();
		return tagList;
	}

}
