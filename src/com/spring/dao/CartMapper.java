package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CartMapper implements RowMapper<ShoppingCart> {

	@Override
	public ShoppingCart mapRow(ResultSet resultSet, int arg1) throws SQLException {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(resultSet.getString("id"));
		shoppingCart.setCustomerId(resultSet.getString("customer_id"));
		shoppingCart.setProductId(resultSet.getString("product_id"));
		shoppingCart.setQuantity(resultSet.getInt("quantity"));
		
		shoppingCart.setCreatedAt(resultSet.getDate("created_at"));
		shoppingCart.setModifiedAt(resultSet.getDate("modified_at"));
		
		return shoppingCart;
	}

}
