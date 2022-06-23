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
@Table(name = "Brand")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BrandId")
	private int id;
	@Column(name = "BrandName")
	private String name;
	@Column(name = "Logo")
	private String logo;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private boolean status;

	@OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Product> products;

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(int id, String name, String logo, String description, boolean status, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.description = description;
		this.status = status;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
