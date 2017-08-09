package com.paweljarosz.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final String INDEX = "index";
	
	@RequestMapping("/")
	public String root(){
		return INDEX;
	}
	
	@RequestMapping("/index")
	public String index(){
		return INDEX;
	}
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
}
