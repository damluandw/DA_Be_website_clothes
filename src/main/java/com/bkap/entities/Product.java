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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Product")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId")
	private int id;
	@Column(name = "ProductName")
	private String name;
	@Column(name = "PriceIn")
	private float priceIn;
	@Column(name = "PriceOut")
	private float priceOut;
	@Column(name = "Discount")
	private float discount;
	@Column(name = "Image")
	private String image;
	@Column(name = "Images")
	private String images;
	@Column(name = "Description")
	private String description;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "UpdateDate")
	private Date updateDate;
	@Column(name = "CountView")
	private int countView;
	@Column(name = "CountBuy")
	private int countBuy;
	@Column(name = "ShowHome")
	private boolean showHome;
	@Column(name = "Status")
	private boolean status;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ProductCategory> categories;
	@ManyToOne
	@JoinColumn(name = "ProviderId", referencedColumnName = "ProviderId")
	private Provider provider;
	@ManyToOne
	@JoinColumn(name = "BrandId", referencedColumnName = "BrandId")
	private Brand brand;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductSize> sizes;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductColor> colors;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductStyle> styles;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductFavorite> favorites;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Feeback> feebacks;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> orderDetails;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, float priceIn, float priceOut, float discount, String image, String images,
			String description, Date createDate, Date updateDate, int countView, int countBuy, boolean showHome,
			boolean status, List<ProductCategory> categories, Provider provider, Brand brand, List<ProductSize> sizes,
			List<ProductColor> colors, List<ProductStyle> styles, List<ProductFavorite> favorites,
			List<Feeback> feebacks, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.name = name;
		this.priceIn = priceIn;
		this.priceOut = priceOut;
		this.discount = discount;
		this.image = image;
		this.images = images;
		this.description = description;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.countView = countView;
		this.countBuy = countBuy;
		this.showHome = showHome;
		this.status = status;
		this.categories = categories;
		this.provider = provider;
		this.brand = brand;
		this.sizes = sizes;
		this.colors = colors;
		this.styles = styles;
		this.favorites = favorites;
		this.feebacks = feebacks;
		this.orderDetails = orderDetails;
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

	public float getPriceIn() {
		return priceIn;
	}

	public void setPriceIn(float priceIn) {
		this.priceIn = priceIn;
	}

	public float getPriceOut() {
		return priceOut;
	}

	public void setPriceOut(float priceOut) {
		this.priceOut = priceOut;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getCountView() {
		return countView;
	}

	public void setCountView(int countView) {
		this.countView = countView;
	}

	public int getCountBuy() {
		return countBuy;
	}

	public void setCountBuy(int countBuy) {
		this.countBuy = countBuy;
	}

	public boolean isShowHome() {
		return showHome;
	}

	public void setShowHome(boolean showHome) {
		this.showHome = showHome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<ProductSize> getSizes() {
		return sizes;
	}

	public void setSizes(List<ProductSize> sizes) {
		this.sizes = sizes;
	}

	public List<ProductColor> getColors() {
		return colors;
	}

	public void setColors(List<ProductColor> colors) {
		this.colors = colors;
	}

	public List<ProductStyle> getStyles() {
		return styles;
	}

	public void setStyles(List<ProductStyle> styles) {
		this.styles = styles;
	}

	public List<ProductFavorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<ProductFavorite> favorites) {
		this.favorites = favorites;
	}

	public List<Feeback> getFeebacks() {
		return feebacks;
	}

	public void setFeebacks(List<Feeback> feebacks) {
		this.feebacks = feebacks;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
