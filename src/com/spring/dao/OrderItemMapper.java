package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderItemMapper implements RowMapper<OrderItem> {

	@Override
	public OrderItem mapRow(ResultSet resultSet, int arg1) throws SQLException {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(resultSet.getString("id"));
		orderItem.setOrderId(resultSet.getString("order_id"));
		orderItem.setProductId(resultSet.getString("product_Id"));
		orderItem.setQuantity(resultSet.getInt("quantity"));
		orderItem.setCreatedAt(resultSet.getDate("created_at"));
		orderItem.setModifiedAt(resultSet.getDate("modified_at"));
		orderItem.setDeliveryDate(resultSet.getDate("delivery_Date"));
		
		return orderItem;
	}

}
