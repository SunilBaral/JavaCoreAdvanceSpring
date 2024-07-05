package springmvcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import springmvcc.model.User;
import springmvcc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user,  Model model) 
	{
		if(user.getUserName().isBlank())
		{
			return "redirect:/contact";
		}
		this.userService.createUser(user);
		return "success";
	}
}







/*
 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
 * String handleForm(
 * 
 * @RequestParam("email") String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("userPassword") String userPassword,Model model) { //
 * System.out.println("user email " +userEmail); //
 * System.out.println("user name "+userName); //
 * System.out.println("user password " +userPassword);
 * 
 * 
 * 
 * 
 * User user=new User(); user.setEmail(userEmail); user.setUserName(userName);
 * user.setUserPassword(userPassword);
 * 
 * System.out.println(user);
 * 
 * model.addAttribute("user",user);
 * 
 * // model.addAttribute("email",userEmail); //
 * model.addAttribute("userName",userName); //
 * model.addAttribute("userPassword",userPassword); return "success"; }
 */