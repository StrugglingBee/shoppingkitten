package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Article implements Serializable{
	public int id;
	public String text;
	public String images;
	public String title;

	public Article() {
	}

	public Article(int id, String text, String images, String title) {
		this.id = id;
		this.text = text;
		this.images = images;
		this.title = title;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}