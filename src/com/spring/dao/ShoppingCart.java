package com.spring.dao;

import java.sql.Date;

/**
create table Shopping_Cart(id varchar(50) primary key, customer_Id varchar(50), product_Id varchar(50), quantity int, 
	created_At date, modified_At date);

insert into Shopping_Cart (id, customer_Id, product_Id, quantity, created_At, modified_At)
values ('Cart-1','Customer-1', 'Product-1', 1, '2024-12-25','2024-12-25');
 */
public class ShoppingCart {

	String id;
	String customerId;
	String productId;
	Integer quantity;
	Date createdAt;
	Date modifiedAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}


}
