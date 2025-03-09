package com.spring.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ShoppingCart> getCartProducts(String customerId) {
		String query = "select * from Shopping_Cart where customer_id='" + customerId + "'";
		List<ShoppingCart> cartProducts = jdbcTemplate.query(query, new CartMapper());

		return cartProducts;
	}

	public boolean addProduct(String productId, String customerId) {
		String cartId = "Cart-" + Math.random() * 100;
		Date date = new Date(System.currentTimeMillis());
		String query = "insert into Shopping_Cart (id, customer_Id, product_Id, quantity, created_At, modified_At)\r\n"
				+ "values ('" + cartId + "','" + customerId + "', '" + productId + "', 1, '" + date + "','" + date
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
