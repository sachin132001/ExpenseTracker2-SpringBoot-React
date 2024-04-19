package com.example.expense.entity;

public class LoginData {
	String userOrPass;
	String password;
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginData(String userOrPass, String password) {
		super();
		this.userOrPass = userOrPass;
		this.password = password;
	}
	public String getUserOrPass() {
		return userOrPass;
	}
	public void setUserOrPass(String userOrPass) {
		this.userOrPass = userOrPass;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginData [userOrPass=" + userOrPass + ", password=" + password + "]";
	}
	

}
