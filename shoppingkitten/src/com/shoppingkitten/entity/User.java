package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class User implements Serializable{
	private int id;
	private int tid;
	private String account;
	private String pwd;
	private String pwd2;
	private String email;
	private String phone;
	private String create_time;
	private int login_count;
	private int login_error;
	private String create_ip;
	private int member_integral;
	private int lock_time;
	private String status;
	//用户总数
	private int counts;

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getPwd() {
		return pwd;
	}

	public int getLock_time() {
		return lock_time;
	}

	public void setLock_time(int lock_time) {
		this.lock_time = lock_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public User(int id, int tid, String account, String pwd, String email, String phone, String create_time, int login_count, int login_error, String create_ip, int member_integral, int lock_time, String status) {
		this.id = id;
		this.tid = tid;
		this.account = account;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.create_time = create_time;
		this.login_count = login_count;
		this.login_error = login_error;
		this.create_ip = create_ip;
		this.member_integral = member_integral;
		this.lock_time = lock_time;
		this.status = status;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", tid=" + tid +
				", account='" + account + '\'' +
				", pwd='" + pwd + '\'' +
				", pwd2='" + pwd2 + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", create_time='" + create_time + '\'' +
				", login_count=" + login_count +
				", login_error=" + login_error +
				", create_ip='" + create_ip + '\'' +
				", member_integral=" + member_integral +
				", lock_time=" + lock_time +
				", status='" + status + '\'' +
				'}';
	}
}