package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Privilege implements Serializable{
	private int pid;
	private String p_name;
	private String p_remark;

	public String getP_remark() {
		return p_remark;
	}

	public void setP_remark(String p_remark) {
		this.p_remark = p_remark;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Privilege() {

	}

	public Privilege(int pid, String p_name) {

		this.pid = pid;
		this.p_name = p_name;
	}
}