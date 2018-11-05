package com.ssmall.pojo;

public class Userpojo {
	private Integer id;
	private String username;
	private String password;
	private String account;

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userpojo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
