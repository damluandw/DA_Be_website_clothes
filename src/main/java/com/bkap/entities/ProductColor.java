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
@Table(name = "Product_Color")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProductColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductColorId")
	private int id;
	@Column(name = "Status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
	private Color color;

	public ProductColor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductColor(int id, boolean status, Product product, Color color) {
		super();
		this.id = id;
		this.status = status;
		this.product = product;
		this.color = color;

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
