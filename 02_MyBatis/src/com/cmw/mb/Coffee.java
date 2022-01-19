package com.cmw.mb;

public class Coffee {
	private String c_name;
	private int c_price;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_price() {
		return c_price;
	}

	public void setC_price(int c_price) {
		this.c_price = c_price;
	}

	public Coffee(String c_name, int c_price) {
		super();
		this.c_name = c_name;
		this.c_price = c_price;
	}
	
	
}
