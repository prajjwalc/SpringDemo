package com.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.OrderDao;
import com.spring.dao.OrderDetails;
import com.spring.dao.OrderItem;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public List<OrderDetails> getOrders(String customerId) {
		List<OrderDetails> orders = orderDao.getOrders(customerId);
		orders.forEach(order -> {
			order.setOrderItems(getOrderItems(order.getId()));
		});

		return orders;
	
	}
	
	public List<OrderItem> getOrderItems(String orderId) {
		return orderDao.getOrderItems(orderId);
	}
	
	public boolean addOrder(OrderDetails orderDetails) {
		return orderDao.addOrder(orderDetails);
	}
	
	public boolean addOrderItem(OrderItem orderItem) {
		return orderDao.addOrderItem(orderItem);
	}
	
	public boolean removeProduct(String cartId, String customerId) {
		return orderDao.removeProduct(cartId, customerId);
	}
}
