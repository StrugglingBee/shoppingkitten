package com.shoppingkitten.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Product_type implements Serializable{
	private int id ;
	private String text;
	private int pid;
	private Set<Product_type> children=new HashSet<>();
	public Product_type() {
	}
	public Product_type(int id, String text, int pid) {
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Set<Product_type> getChildren() {
		return children;
	}

	public void setChildren(Set<Product_type> children) {
		this.children = children;
	}
}