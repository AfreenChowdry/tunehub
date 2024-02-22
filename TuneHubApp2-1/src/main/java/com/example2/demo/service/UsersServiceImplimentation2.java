package com.example2.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example2.demo.entities.Users2;
import com.example2.demo.repository.UsersRepository2;

@Service
public class UsersServiceImplimentation2 implements UsersService2{
	@Autowired
	UsersRepository2 repo;
	@Override
	public String addUser(Users2 user) 
	{
		repo.save(user);
		return "user is created and saved";

     }
	@Override
	public boolean emailExists(String email)
	{
		if(repo.findByEmail(email) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		
		Users2 user = repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		
		return (repo.findByEmail(email).getRole());
		
	}
	@Override
	public Users2 getUser(String email) {
	
		return repo.findByEmail(email);
	}
	@Override
	public void updateUser(Users2 user) {
		repo.save(user);
		
	}
}



