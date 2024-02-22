package com.example2.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.demo.entities.Songs2;

public interface SongsRepository2 extends JpaRepository<Songs2, Integer> {

	public Songs2 findByName(String name);

	

}
