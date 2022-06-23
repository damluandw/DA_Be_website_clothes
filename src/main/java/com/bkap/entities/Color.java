package com.bkap.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Color")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ColorId")
	private int id;
	@Column(name = "Color")
	private String color;

	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> orderDetails;

	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductColor> products;

	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Color(int id, String color, List<OrderDetail> orderDetails, List<ProductColor> products) {
		super();
		this.id = id;
		this.color = color;
		this.orderDetails = orderDetails;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<ProductColor> getProducts() {
		return products;
	}

	public void setProducts(List<ProductColor> products) {
		this.products = products;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
