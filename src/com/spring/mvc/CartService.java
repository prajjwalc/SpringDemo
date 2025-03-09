package com.spring.mvc;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CartDao;
import com.spring.dao.OrderDao;
import com.spring.dao.OrderDetails;
import com.spring.dao.OrderItem;
import com.spring.dao.Product;
import com.spring.dao.ProductDao;
import com.spring.dao.ShoppingCart;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;

	public List<ShoppingCart> getCartProducts(String customerId) {
		return cartDao.getCartProducts(customerId);
	}

	public boolean addProduct(String productId, String customerId) {
		return cartDao.addProduct(productId, customerId);
	}

	public boolean removeProduct(String cartId, String customerId) {
		return cartDao.removeProduct(cartId, customerId);
	}
	
	public boolean buyProduct(String customerId) {
		List<ShoppingCart> shoppingCarts = cartDao.getCartProducts(customerId);
		if (shoppingCarts.size() > 0) {
			String orderId = "Order-" + Math.random() * 100;
			Date date = new Date(System.currentTimeMillis());
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setCustomerId(customerId);
			orderDetails.setId(orderId);
			orderDetails.setPaymentId("Payment-" + orderId);
			orderDetails.setTotal(shoppingCarts.size());
			orderDetails.setDeliveryDate(date);

			orderDao.addOrder(orderDetails);

			shoppingCarts.forEach(cart -> {
				String productId = cart.getProductId();
				Product product = productDao.getProduct(productId);
				Integer deliveryDays = product.getDeliveryDays();

				String orderItemId = "OrderItem-" + Math.random() * 100;
				OrderItem orderItem = new OrderItem();
				orderItem.setId(orderItemId);
				orderItem.setProductId(productId);
				orderItem.setQuantity(cart.getQuantity());
				orderItem.setOrderId(orderId);
				orderItem.setDeliveryDate(date);

				orderDao.addOrderItem(orderItem);

				cartDao.removeProduct(cart.getId(), customerId);
			});
		}
		
		return true;
	}
}
