package com.spring.dao;

import java.sql.Date;

/**
create table Order_Item(id varchar(50) primary key, order_Id varchar(50), product_Id varchar(50), quantity int, 
	created_At date, modified_At date, delivery_Date date);

insert into Order_Item (id, order_Id, product_Id, quantity, created_At, modified_At,delivery_Date)
values ('orderItem-1','order-1', 'Product-1', 1, '2024-12-25','2024-12-25','2024-12-25');

 */
public class OrderItem {

	String id;
	String orderId;
	String productId;
	Integer quantity;
	Date createdAt;
	Date modifiedAt;
	Date deliveryDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId 
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", deliveryDate=" + deliveryDate + "]";
	}

	
}
