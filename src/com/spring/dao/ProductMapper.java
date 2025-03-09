package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Product product = new Product();
		product.setId(resultSet.getString("id"));
		product.setName(resultSet.getString("name"));
		product.setDescription(resultSet.getString("description"));
		product.setPrice(resultSet.getFloat("price"));
		product.setCategory(resultSet.getString("category"));
		product.setImage(resultSet.getString("image"));
		product.setCreatedAt(resultSet.getDate("created_at"));
		product.setModifiedAt(resultSet.getDate("modified_at"));
		product.setDeliveryDays(resultSet.getInt("delivery_days"));

		return product;
	}

}
