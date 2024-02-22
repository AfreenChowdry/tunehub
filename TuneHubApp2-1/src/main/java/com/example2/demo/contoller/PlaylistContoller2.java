package com.example2.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example2.demo.entities.Playlist2;
import com.example2.demo.entities.Songs2;
import com.example2.demo.service.PlaylistService2;
import com.example2.demo.service.SongsService2;



@Controller
public class PlaylistContoller2 {
	@Autowired
	PlaylistService2 pserv;
	
	@Autowired
	SongsService2 sserv;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model)
	{
		//Fetching the songs using song service
		List<Songs2> songslist=sserv.fetchAllSongs();
		
		//Adding the songs in the model
		model.addAttribute("songslist", songslist);
		
		//sending createplaylist
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist2 playlist)
	{
		//adding playlist
		pserv.addPlayList(playlist);
		
		//update song table
		
		List<Songs2> songsList=playlist.getSongs();
		for(Songs2 song : songsList)
		{
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		
		
		return "playlistSuccess";
	}
	
	@GetMapping("/viewPlaylist")
	public String viewPlaylists(Model model)
	{
		List<Playlist2> plist=pserv.fetchPlaylists();
		model.addAttribute("plist",plist);
	
		//System.out.println(plist);
		
		return "viewPlaylists";
	}
	
	

}



