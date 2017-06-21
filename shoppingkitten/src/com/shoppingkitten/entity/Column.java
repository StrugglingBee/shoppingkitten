package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Column implements Serializable{
	public int id;
	public String name;
	public int pid;

	public Column() {
	}

	public Column(int id, String name, int pid) {

		this.id = id;
		this.name = name;
		this.pid = pid;
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
}