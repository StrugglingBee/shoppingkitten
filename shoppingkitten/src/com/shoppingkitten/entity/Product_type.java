package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Product_type implements Serializable{
	public int id;
	public String type_name;
	public int Pid;

	public Product_type() {
	}

	public Product_type(int id, String type_name, int pid) {

		this.id = id;
		this.type_name = type_name;
		Pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}
}