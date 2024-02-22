package com.example2.demo.service;

import java.util.List;


import com.example2.demo.entities.Songs2;

public interface SongsService2 {
	public String addSongs(Songs2 song);

	public boolean songExists(String name);
	
	public List<Songs2> fetchAllSongs();

	public void updateSong(Songs2 song);

}
