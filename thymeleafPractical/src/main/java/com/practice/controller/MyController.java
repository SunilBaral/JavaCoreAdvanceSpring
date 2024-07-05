package com.practice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("name", "sunil baral");
		model.addAttribute("date",new  Date().toString());
		System.out.println("inside about handler");
		return "about";
	}
	
	//handling  iterate
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		
		//createing a loop
		List<String> names = List.of("Sunil","Rati","sneha","jayashree");
		m.addAttribute("name",names);
		return "iterate";
	}
	
	//include/insert/replace
	@GetMapping("/service")
	public String serviceshandler(Model m)
	{
		return "service";
	}
	
	@GetMapping("/aboutnew")
	public String aboutNew(Model m)
	{
		return "aboutnew";
	}

}
