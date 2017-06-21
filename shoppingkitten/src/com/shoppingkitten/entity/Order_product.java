package com.shoppingkitten.entity;


import java.io.Serializable;

public class Order_product implements Serializable{
	public int id;
	public int oid;
	public int pid;
	public int p_num;
	public float p_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public float getP_price() {
		return p_price;
	}

	public void setP_price(float p_price) {
		this.p_price = p_price;
	}

	public Order_product() {

	}

	public Order_product(int id, int oid, int pid, int p_num, float p_price) {

		this.id = id;
		this.oid = oid;
		this.pid = pid;
		this.p_num = p_num;
		this.p_price = p_price;
	}
}