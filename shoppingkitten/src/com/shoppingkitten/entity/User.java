package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class User implements Serializable{
	public String pwd;
	public String email;
	public String phone;
	public String create_time;
	public int login_count;
	public int login_error;
	public String create_ip;
	public int mid;
	public int member_integral;
	public int id;
	public String account;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getLogin_count() {
		return login_count;
	}

	public void setLogin_count(int login_count) {
		this.login_count = login_count;
	}

	public int getLogin_error() {
		return login_error;
	}

	public void setLogin_error(int login_error) {
		this.login_error = login_error;
	}

	public String getCreate_ip() {
		return create_ip;
	}

	public void setCreate_ip(String create_ip) {
		this.create_ip = create_ip;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getMember_integral() {
		return member_integral;
	}

	public void setMember_integral(int member_integral) {
		this.member_integral = member_integral;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public User() {

	}

	public User(String pwd, String email, String phone, String create_time, int login_count, int login_error, String create_ip, int mid, int member_integral, int id, String account) {

		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.create_time = create_time;
		this.login_count = login_count;
		this.login_error = login_error;
		this.create_ip = create_ip;
		this.mid = mid;
		this.member_integral = member_integral;
		this.id = id;
		this.account = account;
	}
}