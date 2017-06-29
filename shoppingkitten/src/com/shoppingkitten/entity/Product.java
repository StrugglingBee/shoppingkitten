package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Product implements Serializable{
	private int id;
	private String name;
	private float sale_price;
	private int stock;
	private int sale_total;
	private int tid;
	private float price;
	private String face_image;
	private String descripe;
	private String create_time;

	public Product(int id, String name, float sale_price, int stock, int sale_total, int tid, float price, String face_image, String descripe, String create_time) {
		this.id = id;
		this.name = name;
		this.sale_price = sale_price;
		this.stock = stock;
		this.sale_total = sale_total;
		this.tid = tid;
		this.price = price;
		this.face_image = face_image;
		this.descripe = descripe;
		this.create_time = create_time;
	}

	public Product() {
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

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSale_total() {
		return sale_total;
	}

	public void setSale_total(int sale_total) {
		this.sale_total = sale_total;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFace_image() {
		return face_image;
	}

	public void setFace_image(String face_image) {
		this.face_image = face_image;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}