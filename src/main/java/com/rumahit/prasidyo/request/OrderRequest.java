package com.rumahit.prasidyo.request;

import java.util.List;

public class OrderRequest {
	private Long companyId;
	private double totalPrice;
	private List<OrderDetailsRequest> listDetails;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDetailsRequest> getListDetails() {
		return listDetails;
	}

	public void setListDetails(List<OrderDetailsRequest> listDetails) {
		this.listDetails = listDetails;
	}

}
