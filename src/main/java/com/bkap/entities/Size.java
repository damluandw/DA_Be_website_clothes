package com.bkap.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Size")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SizeId")
	private int id;
	@Column(name = "Size")
	private String size;

	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductSize> products;

	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> orderDetails;

	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Size(int id, String size, List<ProductSize> products, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.size = size;
		this.products = products;
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<ProductSize> getProducts() {
		return products;
	}

	public void setProducts(List<ProductSize> products) {
		this.products = products;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
