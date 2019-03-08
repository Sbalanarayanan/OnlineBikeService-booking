package com.chainsys.bikeservice.model;

public class ServiceType {

	private int id;
	private String name;
	private int days;

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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "ServiceType [id=" + id + ", name=" + name + ", days=" + days
				+ "]";
	}

}
