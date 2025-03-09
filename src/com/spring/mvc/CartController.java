package com.spring.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.ShoppingCart;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@GetMapping("/cart")
	public String addToCart(@RequestParam(name = "productId", required = false) String productId,
			@RequestParam(name = "action", required = false) String action,
			@RequestParam(name = "cartId", required = false) String cartId, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		
		String customerId = session.getAttribute("username").toString();
		System.out.println("productId-" + productId + ", action-" + action + ", cartId-" + cartId);
		if (productId != null && productId != "") {
			System.out.println("Adding item to cart with productId-" + productId);

			cartService.addProduct(productId, customerId);
		}
		if (cartId != null && cartId != "") {
			System.out.println("Deleting product from cart with carId-" + cartId);
			cartService.removeProduct(cartId, customerId);
		} else {
			System.out.println("action is not found");
		}

		List<ShoppingCart> shoppingCarts = cartService.getCartProducts(customerId);
		model.addAttribute("shoppingCarts", shoppingCarts);

		return "cart";
	}

	@PostMapping("cart")
	public String cartPost(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String customerId = session.getAttribute("username").toString();

		cartService.buyProduct(customerId);

		return "redirect:/orders";
	}
}
