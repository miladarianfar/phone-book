package com.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.book.entity.User;

public class UserDao {

	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	String message;
	
	public void addUser(User user) {
		
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User u where u.email = '" + user.getEmail() + "'").getResultList();
		
		for(User u : users) {
			if(u.getEmail() == null) {
				session.save(user);
			}else {
				break;
			}
		}
		
		session.getTransaction().commit();
	}
	
	public User getUser(String email , String password) {
		
		User user = new User();
		
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User u where u.email = '" + email + "' and u.password = '" + password + "'").getResultList();
		
		session.getTransaction().commit();
		
		for(User u : users) {
			user = u;
		}
		
		return user;
	}
	
	public List<User> getUserForCheck(User user){
		
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User u where u.email = '" + user.getEmail() + "' and u.password = '" + user.getPassword() + "'").getResultList();
		
		session.getTransaction().commit();
		
		return users;
	}
	
	public User getUserById(int id) {
		
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		session.getTransaction().commit();
		
		return user;
	}
	
	
	
	
	
	
	
	
}
