package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvcsearch.entity.FormData;

@Controller
public class ComplexFormController {
	
	@RequestMapping("/register")
	public String submission() {
		return "register";
	}
	
	@RequestMapping(path ="/handler",method=RequestMethod.POST)
	public String formHandler(@ModelAttribute("data") FormData data,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		return "success";
	}

}
