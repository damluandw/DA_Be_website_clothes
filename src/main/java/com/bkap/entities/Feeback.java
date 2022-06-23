package com.bkap.entities;

import java.util.Date;

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
@Table(name = "Feeback")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Feeback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackId")
	private int id;
	@Column(name = "FullName")
	private String fullName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Avatar")
	private String avatar;
//	@Column(name = "Title")
//	private String title;
	@Column(name = "Content")
	private String content;
	@Column(name = "Rate")
	private int rate;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "Status")
	private boolean status;
	@ManyToOne
//	@JsonIgnore
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
	private Customer customer;

	public Feeback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feeback(int id, String fullName, String email, String avatar, String content, int rate, Date createDate,
			boolean status, Product product, Customer customer) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.avatar = avatar;
		this.content = content;
		this.rate = rate;
		this.createDate = createDate;
		this.status = status;
		this.product = product;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
