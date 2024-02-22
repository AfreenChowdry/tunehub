package com.example2.demo.service;

import com.example2.demo.entities.Users2;

public interface UsersService2 {
public String addUser(Users2 user);
	
	public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String getRole(String email);

	public Users2 getUser(String email);

	public void updateUser(Users2 user);


}
