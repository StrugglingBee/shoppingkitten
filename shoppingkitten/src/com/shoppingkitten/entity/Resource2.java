package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Resource2 implements Serializable{
	public int resource_id;
	public String text;
	public String url;
	public int parent_id;

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public Resource2() {

	}

	public Resource2(int resource_id, String text, String url, int parent_id) {

		this.resource_id = resource_id;
		this.text = text;
		this.url = url;
		this.parent_id = parent_id;
	}
}