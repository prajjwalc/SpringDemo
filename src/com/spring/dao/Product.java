package com.spring.dao;

import java.sql.Date;

/**
 
create table Product(id varchar(50) primary key, name varchar(50), description varchar(50), price float, 
	category varchar(50), image varchar(50), created_At date, modified_At date, delivery_Days int);



 */
public class Product {

	String id;
	String name;
	String description;
	Float price;
	String category;
	String image;
	Date createdAt;
	Date modifiedAt;
	Integer deliveryDays;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Integer getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", image=" + image + ", createdAt=" + createdAt + ", modifiedAt="
				+ modifiedAt + ", deliveryDays=" + deliveryDays + "]";
	}
	
	
}
