package com.spring.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.Product;
import com.spring.dao.ProductDao;

@Controller
public class WelcomeController {

	@Autowired
	ProductDao productDao;  
	
	@GetMapping(path= {"/home","/","/products"})
	public String welcomeDefault(Model model) {
		System.out.println("welcomeDefault get mapping called . . . ");
		List<Product> products = productDao.getProducts();

		model.addAttribute("products", products);

		return "home";
	}

	@GetMapping("/welcome")
	public ModelAndView welcome(@RequestParam("param1") String param1) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("welcome get mapping called . . . " + param1);
		modelAndView.addObject("param1", param1);
		modelAndView.addObject("welcome123", new Welcome("My message 123"));
		modelAndView.addObject("welcome1", new Welcome("1->Default message..."));
		modelAndView.setViewName("welcome");

		return modelAndView;
	}

	@PostMapping("/welcome")
	public String welcomeTwo(@ModelAttribute("welcome123") @Valid Welcome welcome, BindingResult result) {
		System.out.println("welcome post mapping called . . . " + welcome);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();

			modelAndView.addObject("param1", "");
			modelAndView.addObject("welcome", welcome);

			return "welcome";
		} else {

			return "redirect:/welcome?param1=redirected";
		}
	}
	
	@GetMapping(path= {"/aboutUs"})
	public String aboutUs(Model model) {
		return "index";
	}
}
