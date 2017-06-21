package com.shoppingkitten.entity;


import java.io.Serializable;

public class Order implements Serializable{
	public int id;
	public int uid;
	public double money;
	public int aid;

	public Order(int id, int uid, double money, int aid) {
		this.id = id;
		this.uid = uid;
		this.money = money;
		this.aid = aid;
	}

	public Order() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
}