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
@Table(name = "Product_Favorite")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProductFavorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductFavoriteId")
	private int id;
	@Column(name = "Status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	private Product product;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "FavoriteId", referencedColumnName = "FavoriteId")
	private Favorite favorite;

	public ProductFavorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductFavorite(int id, boolean status, Product product, Favorite favorite) {
		super();
		this.id = id;
		this.status = status;
		this.product = product;
		this.favorite = favorite;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

}
