package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getProducts() {
		String query = "select * from product";
		List<Product> products = jdbcTemplate.query(query, new ProductMapper());

		return products;
	}

	public Product getProduct(String productId) {
		String query = "select * from product where id='" + productId + "'";
		Product product = jdbcTemplate.query(query, new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				Product product = new Product();
				while (resultSet.next()) {
					product.setId(resultSet.getString("id"));
					product.setName(resultSet.getString("name"));
					product.setDescription(resultSet.getString("description"));
					product.setPrice(resultSet.getFloat("price"));
					product.setCategory(resultSet.getString("category"));
					product.setImage(resultSet.getString("image"));
					product.setCreatedAt(resultSet.getDate("created_at"));
					product.setModifiedAt(resultSet.getDate("modified_at"));
					product.setDeliveryDays(resultSet.getInt("delivery_days"));
				}
				return product;
			}

		});

		return product;
	}

}
