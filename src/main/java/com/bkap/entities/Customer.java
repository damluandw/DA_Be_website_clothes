package com.bkap.entities;

import java.util.Date;
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
@Table(name = "Customer")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private int id;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "Country")
	private String country;
	@Column(name = "City")
	private String city;
	@Column(name = "StreetAddress")
	private String streetAddress;
	@Column(name = "Postcode")
	private String postcode;
	@Column(name = "Avatar")
	private String avatar;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "CodeConfirm")
	private String codeConfirm;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Orders> orders;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Feeback> feebacks;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Favorite> favorites;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String email, String password, String phone, String firstName, String lastName,
			String country, String city, String streetAddress, String postcode, String avatar, Date createDate,
			String codeConfirm, boolean status, List<Orders> orders, List<Feeback> feebacks, List<Favorite> favorites) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.city = city;
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.avatar = avatar;
		this.createDate = createDate;
		this.codeConfirm = codeConfirm;
		this.status = status;
		this.orders = orders;
		this.feebacks = feebacks;
		this.favorites = favorites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvartar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCodeConfirm() {
		return codeConfirm;
	}

	public void setCodeConfirm(String codeConfirm) {
		this.codeConfirm = codeConfirm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Feeback> getFeebacks() {
		return feebacks;
	}

	public void setFeebacks(List<Feeback> feebacks) {
		this.feebacks = feebacks;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

}
