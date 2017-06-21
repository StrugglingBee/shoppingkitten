package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Address implements Serializable{
	public int id;
	public String name;
	public int pid;
	public String areaid;

	public Address() {
	}

	public Address(int id, String name, int pid, String areaid) {
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.areaid = areaid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
}