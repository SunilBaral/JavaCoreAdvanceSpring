package springmvcc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("hello this is home url..");
		model.addAttribute("name", "Sunil Baral");
		List<String> friends = new ArrayList<String>();
		friends.add("Sneha");
		friends.add("Rati");
		friends.add("jayashree");

		model.addAttribute("f", friends);
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "sunil Baral");
		modelAndView.setViewName("help");
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time", now);
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(17);
		list.add(18);
		
		modelAndView.addObject("num",list);
		return modelAndView;
	}

}
