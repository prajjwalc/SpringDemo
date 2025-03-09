package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<OrderDetails> {

	@Override
	public OrderDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setId(resultSet.getString("id"));
		orderDetails.setCustomerId(resultSet.getString("customer_id"));
		orderDetails.setPaymentId(resultSet.getString("payment_Id"));
		orderDetails.setTotal(resultSet.getInt("total"));
		orderDetails.setStatus(resultSet.getString("status"));
		orderDetails.setCreatedAt(resultSet.getDate("created_at"));
		orderDetails.setModifiedAt(resultSet.getDate("modified_at"));
		orderDetails.setDeliveryDate(resultSet.getDate("delivery_Date"));
		
		return orderDetails;
	}

	
}
