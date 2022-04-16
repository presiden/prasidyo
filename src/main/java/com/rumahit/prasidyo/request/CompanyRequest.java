package com.rumahit.prasidyo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CompanyRequest {

	@NotBlank
	@Size(max = 10)
	private String code;

	@NotBlank
	@Size(max = 50)
	private String name;

	@Size(max = 500)
	private String address;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
