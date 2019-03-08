package com.chainsys.bikeservice.model;

public class AdminLogin {

	private long phone;
	private String password;

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLogin [phone=" + phone + ", password=" + password + "]";
	}

}
