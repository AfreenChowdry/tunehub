package com.example2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example2.demo.entities.Songs2;
import com.example2.demo.repository.SongsRepository2;


@Service
public class SongsServiceImplimentation2 implements SongsService2 {
	@Autowired
	SongsRepository2 srepo;

	@Override
	public String addSongs(Songs2 song) {
		
	srepo.save(song);
		
		return "Song is added";
	}

	@Override
	public boolean songExists(String name) {
		Songs2 song = srepo.findByName(name);
		if(song==null)
		{
		return false;
	    }
		else
		{
			return true;
		}
	}

	@Override
	public List<Songs2> fetchAllSongs() {
		List<Songs2> songslist =srepo.findAll();
		return songslist;
	}

	@Override
	public void updateSong(Songs2 song) {
		srepo.save(song);
		
	}



	

}



