package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Manager implements Serializable{
	public int mid;
	public String account;
	public String pwd;
	public String phone;
	public String id_code;

	public Manager(int mid, String account, String pwd, String phone, String id_code) {
		this.mid = mid;
		this.account = account;
		this.pwd = pwd;
		this.phone = phone;
		this.id_code = id_code;
	}

	public Manager() {
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId_code() {
		return id_code;
	}

	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
}