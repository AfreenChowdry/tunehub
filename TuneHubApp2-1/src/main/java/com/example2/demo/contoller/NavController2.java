package com.example2.demo.contoller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class NavController2 {

	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
		
	}
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
		
	}
	@GetMapping("/map-songs")
	public String songMapping()
	{
		return "addsongs";
		
	}
	@GetMapping("/samplePayment")
	public String samplePayment()
	{
		return "samplePayment";
		
	}
	
	
}


