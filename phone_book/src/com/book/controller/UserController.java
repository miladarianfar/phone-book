package com.book.controller;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.book.dao.UserDao;
import com.book.entity.User;

@RequestScoped
@ManagedBean
public class UserController {

	User model = new User();

	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}
	
	
	public String addUser(User user) {
		
		UserDao dao = new UserDao();
		
		dao.addUser(user);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String , Object> requestMap = externalContext.getRequestMap();
		requestMap.put("newUser", user);
		
		return "welcome";
	}
	
	public String check(User user) {
		
		String check_user = "";
		FacesContext context = FacesContext.getCurrentInstance();
		
		UserDao dao = new UserDao();
		
		List<User> users = dao.getUserForCheck(user);
		
		for(User u : users) {
			
			if(u.getEmail() == null && u.getPassword() == null) {
				
				FacesMessage facesMessage = new FacesMessage("Unknown login, try again");
				context.addMessage("myForm:login", facesMessage);
				
			} else {
				
				user = u;
				
				context.getExternalContext().getSessionMap().put("newUser", user);
				
				check_user = "welcome";
				
			}
			
		}
		
		return check_user;
	}
	
	
}
