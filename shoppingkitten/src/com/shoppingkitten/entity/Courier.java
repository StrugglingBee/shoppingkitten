package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Courier implements Serializable{
	public int id;
	public int name;
	public String create_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Courier() {

	}

	public Courier(int id, int name, String create_time) {

		this.id = id;
		this.name = name;
		this.create_time = create_time;
	}
}