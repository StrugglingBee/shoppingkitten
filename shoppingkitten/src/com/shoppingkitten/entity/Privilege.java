package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Privilege implements Serializable{
	public int pid;
	public String p_name;

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