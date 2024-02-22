package com.example2.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example2.demo.entities.Songs2;
import com.example2.demo.entities.Users2;
import com.example2.demo.service.SongsService2;
import com.example2.demo.service.UsersService2;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserContoller2<Users> {
	@Autowired
	UsersService2 userv;
	@Autowired
	SongsService2 songserv;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users2 user)
	{
		boolean userstatus = userv.emailExists(user.getEmail());
		if(userstatus == false)
		{
		userv.addUser(user);
		return "registersuccess";
	    }
		else
		{
		 return "registerfall";	
		}
		
	}
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session )
	{
		
		if(userv.validateUser(email, password) == true)
		{
			session.setAttribute("email", email);
		  //checking whether the user is admin or customer
		   if(userv.getRole(email).equals("admin"))
		   {
			   return "adminhome";
			   
		   }
		   else
		   {
			   return "customerhome";
		   }
		}
		
		else
		{
			return "loginfail";
		}
		
	}
	
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session,Model model)
	{
		String email= (String) session.getAttribute("email");
		Users2 user =userv.getUser(email);
		boolean userStatus =user.isPremium();
		if(userStatus == true)
		{
			List <Songs2> songslist=songserv.fetchAllSongs();
			model.addAttribute("songslist", songslist);
			return "displaysongs";
		}
		else
		{
			return "payment";
		}
		
	}
	
}




