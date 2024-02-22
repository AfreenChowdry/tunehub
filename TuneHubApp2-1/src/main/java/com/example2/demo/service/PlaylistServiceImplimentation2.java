package com.example2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example2.demo.entities.Playlist2;
import com.example2.demo.repository.PlaylistRepository2;

@Service
public class PlaylistServiceImplimentation2 implements PlaylistService2{
	@Autowired
	   PlaylistRepository2 prepo;

		@Override
		public void addPlayList(Playlist2 playlist) {
			prepo.save(playlist);
			
		}

		@Override
		public List<Playlist2> fetchPlaylists() {
			
			return prepo.findAll();
		}


}
