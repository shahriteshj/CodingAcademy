package com.jpm.mtm.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author SMita
 *
 */
@Entity
@Table(name = "PRODUCT_MTM")
public class Product {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private Double productPrice;
	// fetch Type we have made LAZY
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<Order> orders = new HashSet<>();
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
}
/*
 * FetchType.EAGER loading of collections means that they are fetched fully
 * at the time their parent is fetched. 
 * The FetchType.LAZY tells Hibernate to only fetch the related entities 
 * from the database when you use the relationship
 */
