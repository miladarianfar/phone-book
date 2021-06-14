package com.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.book.entity.Contact;
import com.book.entity.User;

public class ContactDao {

	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Contact.class)
								.buildSessionFactory();
	Session session = factory.getCurrentSession();

	public void addContact(Contact contact , User user) {
		
		session.beginTransaction();
		
		contact.setUser(user);
		
		session.save(contact);
		
		session.getTransaction().commit();
		
	}
	
	public List<Contact> getContacts(int id){
		
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		
		List<Contact> contacts = user.getContacts();
		
		return contacts;
	}
	
	public Contact getContact(int id) {
		
		session.beginTransaction();
		
		Contact contact = session.get(Contact.class, id);
		
		session.getTransaction().commit();
		
		return contact;
	}
	
	public void updateContact(Contact contact) {
		
		session.beginTransaction();
		
		Query query = session.createQuery("update Contact c set " +
							"firstName = :firstName, " +
							"lastName = :lastName, " +
							"email = :email, " +
							"address = :address, " +
							"mobile = :mobile, " +
							"homeNumber = :homeNumber, " +
							"workNumber = :workNumber " +
							"where id = :id");
		
		query.setParameter("firstName", contact.getFirstName());
		query.setParameter("lastName", contact.getLastName());
		query.setParameter("email", contact.getEmail());
		query.setParameter("address", contact.getAddress());
		query.setParameter("mobile", contact.getMobile());
		query.setParameter("homeNumber", contact.getHomeNumber());
		query.setParameter("workNumber", contact.getWorkNumber());
		query.setParameter("id", contact.getId());
		query.executeUpdate();
		
		session.getTransaction().commit();
	}
	
	public void deleteContact(int id) {
		
		session.beginTransaction();
		
		Contact contact = session.get(Contact.class, id);
		
		session.delete(contact);
		
		session.getTransaction().commit();
	}
}













