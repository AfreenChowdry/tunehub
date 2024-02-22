package com.example2.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	 String email;
	 String password;
	 String role;
	 String address;
	 String gender;
	 
	 boolean isPremium;

	public Users2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users2(int id, String username, String email, String password, String role, String address, String gender,
			boolean isPremium) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.gender = gender;
		this.isPremium = isPremium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", address=" + address + ", gender=" + gender + ", isPremium=" + isPremium + "]";
	}
	
	
	

}


