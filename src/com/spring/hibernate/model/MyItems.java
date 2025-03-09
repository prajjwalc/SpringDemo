package com.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myitems")
public class MyItems {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String itemName;
	@Column(name="price")
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "MyItems [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
	
	
}
