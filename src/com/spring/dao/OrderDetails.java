package com.spring.dao;

import java.sql.Date;
import java.util.List;

/**
create table Order_Details(id varchar(50) primary key, customer_Id varchar(50), payment_Id varchar(50), total int, 
	status varchar(50), created_At date, modified_At date, delivery_Date date);

insert into Order_Details (id, customer_Id, payment_Id, total, status, created_At, modified_At,delivery_Date)
values ('order-1','order-1', 'payment-1', 1, 'In Progress','2024-12-25','2024-12-25','2024-12-25');

 */
public class OrderDetails {

	String id;
	String customerId;
	String paymentId;
	Integer total;
	String status;
	Date createdAt;
	Date modifiedAt;
	Date deliveryDate;
	List<OrderItem> orderItems;
	
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
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", customerId=" + customerId + ", paymentId=" + paymentId + ", total=" + total
				+ ", status=" + status + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", deliveryDate="
				+ deliveryDate + ", orderItems=" + orderItems + "]";
	}


}
