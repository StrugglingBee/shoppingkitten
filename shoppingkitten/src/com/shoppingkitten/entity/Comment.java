package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Comment implements Serializable{
	public int id;
	public int pid;
	public String text;
	public int uid;
	public String create_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Comment(int id, int pid, String text, int uid, String create_time) {

		this.id = id;
		this.pid = pid;
		this.text = text;
		this.uid = uid;
		this.create_time = create_time;
	}

	public Comment() {

	}
}