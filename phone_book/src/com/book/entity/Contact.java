package com.book.entity;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@ManagedBean
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile")
	private long mobile;
	
	@Column(name = "home_number")
	private long homeNumber;
	
	@Column(name = "work_number")
	private long workNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Contact() {
		
	}

	public Contact(String firstName, String lastName, String email, String password, String address,
			long mobile, long homeNumber, long workNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.homeNumber = homeNumber;
		this.workNumber = workNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(long homeNumber) {
		this.homeNumber = homeNumber;
	}

	public long getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(long workNumber) {
		this.workNumber = workNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lsatName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", mobile=" + mobile + ", homeNumber="
				+ homeNumber + ", workNumber=" + workNumber + "]";
	}
}
