package com.book.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.book.dao.ContactDao;
import com.book.dao.UserDao;
import com.book.entity.Contact;
import com.book.entity.User;

@SessionScoped
@ManagedBean
public class ContactController {

	List<Contact> contacts;
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public String addContact(Contact contact , User user) {
		
		ContactDao dao = new ContactDao();
		
		dao.addContact(contact , user);
		
		return "welcome";
	}
	
	public void getContacts(int id) {
		
		ContactDao dao = new ContactDao();
		
		contacts = dao.getContacts(id);
	}
	
	public String getContact(int id) {
		
		ContactDao dao = new ContactDao();
		
		Contact contact = dao.getContact(id);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String , Object> requestMap = externalContext.getRequestMap();
		requestMap.put("contact", contact);
		
		return "update-contact-form";
	}
	
	public String updateContact(Contact contact) {
		
		ContactDao dao = new ContactDao();
		
		dao.updateContact(contact);
		
		return "show-contact";
	}
	
	public String deleteContact(int id) {
		
		ContactDao dao = new ContactDao();
		
		dao.deleteContact(id);
		
		return "show-contact";
	}
}





















