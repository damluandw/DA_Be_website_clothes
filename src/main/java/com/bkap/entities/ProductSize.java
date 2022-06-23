package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Product_Size")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProductSize {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductSizeId")
	private int id;
	@Column(name = "Status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
	private Size size;

	public ProductSize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSize(int id, boolean status, Product product, Size size) {
		super();
		this.id = id;
		this.status = status;
		this.product = product;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
