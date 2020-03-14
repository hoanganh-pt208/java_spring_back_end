package com.hoanganh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hoanganh.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method get List User
	 */
	@SuppressWarnings("unchecked")
	public List<User> getListUser() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class, "user");
		criteria.addOrder(Order.asc("id"));
		List<User> userList = criteria.list();
		return userList;
	}
	
	/**
	 * Method get User By User Name
	 */
	public User getUserByUserName(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class, "user");
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}
}
