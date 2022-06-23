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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "OrderDetail")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderDetailId")
	private int id;
	@Column(name = "Quatity")
	private String quatity;
	@Column(name = "Price")
	private String price;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "Status")
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
	private Orders order;

//	@OneToMany(mappedBy = "orderDetail", fetch = FetchType.EAGER)
//	@JsonIgnore
//	private List<Product> products;

	@ManyToOne
	@JoinColumn(name = "SizeId", referencedColumnName = "SizeId")
	private Size size;
	@ManyToOne
	@JoinColumn(name = "ColorId", referencedColumnName = "ColorId")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	private Product product;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int id, String quatity, String price, Date createDate, boolean status, Orders order, Size size,
			Color color, Product product) {
		super();
		this.id = id;
		this.quatity = quatity;
		this.price = price;
		this.createDate = createDate;
		this.status = status;
		this.order = order;
		this.size = size;
		this.color = color;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuatity() {
		return quatity;
	}

	public void setQuatity(String quatity) {
		this.quatity = quatity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
