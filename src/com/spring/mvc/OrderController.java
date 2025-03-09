package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public String getOrders(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String customerId = session.getAttribute("username").toString();
		model.addAttribute("orderDetails", orderService.getOrders(customerId));
		
		return "orders";
	}
}
