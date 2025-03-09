package com.spring.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<OrderDetails> getOrders(String customerId) {
		String query = "select * from Order_Details where customer_id='" + customerId + "'";
		List<OrderDetails> orders = jdbcTemplate.query(query, new OrderMapper());
		System.out.println("customerId:"+customerId +" | "+orders);
		return orders;
	}

	public List<OrderItem> getOrderItems(String orderId) {
		String query = "select * from Order_item where order_id='" + orderId + "'";
		List<OrderItem> orderItems = jdbcTemplate.query(query, new OrderItemMapper());

		return orderItems;
	}

	public boolean addOrder(OrderDetails orderDetails) {
		Date date = new Date(System.currentTimeMillis());
		String query = "insert into Order_Details (id, customer_Id, payment_Id, total, status, created_At, modified_At, delivery_Date)\r\n"
				+ "values ('" + orderDetails.getId() + "','" + orderDetails.getCustomerId() + "', '"
				+ orderDetails.getPaymentId() + "', " + orderDetails.getTotal() + ",'" + orderDetails.getStatus()
				+ "', '" + date + "','" + date + "','" + orderDetails.getDeliveryDate() + "')";
		jdbcTemplate.update(query);

		return true;
	}

	public boolean addOrderItem(OrderItem orderItem) {
		Date date = new Date(System.currentTimeMillis());
		String query = "insert into Order_Item (id, order_Id, product_Id, quantity, created_At, modified_At,delivery_Date)\r\n"
				+ "values ('" + orderItem.getId() + "','" + orderItem.getOrderId() + "', '" + orderItem.getProductId()
				+ "', " + orderItem.getQuantity() + ",'" + date + "','" + date + "','" + orderItem.getDeliveryDate()
				+ "')";
		jdbcTemplate.update(query);

		return true;
	}

	public boolean removeProduct(String cartId, String customerId) {
		String query = "delete from Shopping_Cart where customer_id='" + customerId + "' and id='" + cartId + "'";
		jdbcTemplate.update(query);

		return true;
	}

}
