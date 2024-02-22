package com.example2.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example2.demo.entities.Songs2;
import com.example2.demo.service.SongsService2;



@Controller
public class SongsController2 {
	@Autowired
	SongsService2 songserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs2 song)
	{
		boolean status = songserv.songExists(song.getName());
	if(status==false)
	{
		songserv.addSongs(song);
	    return "songsuccess";
	}
	else
	{
		return "songfail";
	}
	
}
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model)
	{
		List <Songs2> songslist=songserv.fetchAllSongs();
		model.addAttribute("songslist", songslist);
		return "displaysongs";
	}
	
	@GetMapping("/viewsongs")
	public String viewCustomerSongs(Model model)
	{
		boolean primeCustomerStatus=true;
		if(primeCustomerStatus==true)
		{
			List <Songs2> songslist=songserv.fetchAllSongs();
			model.addAttribute("songslist", songslist);
			return "displaysongs";
		}
		else
		{
			return "makepayment";
		}
	}
}




