package com.bkap.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Favorite")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FavoriteId")
	private int id;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "Status")
	private boolean status;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
	private Customer customer;
	@OneToMany(mappedBy = "favorite", fetch = FetchType.LAZY)	
	private List<ProductFavorite> products;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int id, Date createDate, boolean status, Customer customer, List<ProductFavorite> products) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.status = status;
		this.customer = customer;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProductFavorite> getProducts() {
		return products;
	}

	public void setProducts(List<ProductFavorite> products) {
		this.products = products;
	}

}
