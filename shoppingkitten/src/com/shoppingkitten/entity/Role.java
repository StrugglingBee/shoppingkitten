package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Role implements Serializable{
	public int rid;
	public String name;

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