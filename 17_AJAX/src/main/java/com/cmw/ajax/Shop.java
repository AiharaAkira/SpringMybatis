package com.cmw.ajax;

import java.math.BigDecimal;

public class Shop {

	private BigDecimal b_floor; 
	private String b_shopName; 
	
	
	
	public Shop(BigDecimal b_floor, String b_shopName) {
		super();
		this.b_floor = b_floor;
		this.b_shopName = b_shopName;
	}



	public BigDecimal getB_floor() {
		return b_floor;
	}



	public void setB_floor(BigDecimal b_floor) {
		this.b_floor = b_floor;
	}



	public String getB_shopName() {
		return b_shopName;
	}



	public void setB_shopName(String b_shopName) {
		this.b_shopName = b_shopName;
	}



	public Shop() {
		// TODO Auto-generated constructor stub
	}
	
}
