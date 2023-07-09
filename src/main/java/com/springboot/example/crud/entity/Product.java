package com.springboot.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private double price;
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public Integer getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}
	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	public void setQuantity(Integer quantity) {
		// TODO Auto-generated method stub
		this.quantity = quantity;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	public void setPrice(Double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

}
