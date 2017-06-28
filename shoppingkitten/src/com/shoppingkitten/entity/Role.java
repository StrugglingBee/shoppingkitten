package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Role implements Serializable{
	private int rid;
	private String name;
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role() {

	}

	public Role(int rid, String name) {

		this.rid = rid;
		this.name = name;
	}
}