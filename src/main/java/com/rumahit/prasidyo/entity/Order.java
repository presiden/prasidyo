package com.rumahit.prasidyo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "created_date")
	private Date createdDate;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetails> listDetails;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Company company, double totalPrice, Date createdDate, List<OrderDetails> listDetails) {
		this.id = id;
		this.company = company;
		this.totalPrice = totalPrice;
		this.createdDate = createdDate;
		this.listDetails = listDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<OrderDetails> getListDetails() {
		return listDetails;
	}

	public void setListDetails(List<OrderDetails> listDetails) {
		this.listDetails = listDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
