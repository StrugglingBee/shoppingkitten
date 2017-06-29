package com.shoppingkitten.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Resource2 implements Serializable{
	private int resource_id;
	private String text;
	private String url;
	private int parent_id;
	private boolean checked;
	private Set<Resource2> children=new HashSet<Resource2>();
	private int biaoji;

	public int getBiaoji() {
		return biaoji;
	}

	public void setBiaoji(int biaoji) {
		this.biaoji = biaoji;
	}

	public Set<Resource2> getChildren() {
		return children;
	}

	public void setChildren(Set<Resource2> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

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