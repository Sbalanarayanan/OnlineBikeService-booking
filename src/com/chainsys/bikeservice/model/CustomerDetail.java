package com.chainsys.bikeservice.model;

import java.time.LocalDate;

public class CustomerDetail {

	private int id;
	private String name;
	private long phone;
	private String address;
	private String companyName;
	private String bikeName;
	private String bikeModel;
	private String bikeNumber;
	private ServiceType customerIssue;
	private LocalDate expectedDate;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public String getBikeNumber() {
		return bikeNumber;
	}

	public void setBikeNumber(String bikeNumber) {
		this.bikeNumber = bikeNumber;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public ServiceType getCustomerIssue() {
		return customerIssue;
	}

	public void setCustomerIssue(ServiceType customerIssue) {
		this.customerIssue = customerIssue;
	}

	@Override
	public String toString() {
		return "CustomerDetail [id=" + id + ", name=" + name + ", phone="
				+ phone + ", address=" + address + ", companyName="
				+ companyName + ", bikeName=" + bikeName + ", bikeModel="
				+ bikeModel + ", bikeNumber=" + bikeNumber + ", customerIssue="
				+ customerIssue + ", expectedDate=" + expectedDate + "]";
	}

}
