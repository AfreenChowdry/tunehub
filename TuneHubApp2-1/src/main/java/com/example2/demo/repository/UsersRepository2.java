package com.example2.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.demo.entities.Users2;



public interface UsersRepository2 extends JpaRepository<Users2,Integer> {

public Users2 findByEmail(String email)	;


	

}
