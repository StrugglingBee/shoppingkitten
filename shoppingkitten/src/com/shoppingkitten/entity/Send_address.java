package com.shoppingkitten.entity;


import java.io.Serializable;
import java.lang.String;

public class Send_address implements Serializable{
	public int id;
	public int uid;
	public String area;
	public String consignee_phone;
	public String code;
	public String consignee;
	public String street;
	public String address;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getConsignee_phone() {
		return consignee_phone;
	}

	public void setConsignee_phone(String consignee_phone) {
		this.consignee_phone = consignee_phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Send_address() {

	}

	public Send_address(int id, int uid, String area, String consignee_phone, String code, String consignee, String street, String address) {

		this.id = id;
		this.uid = uid;
		this.area = area;
		this.consignee_phone = consignee_phone;
		this.code = code;
		this.consignee = consignee;
		this.street = street;
		this.address = address;
	}
}