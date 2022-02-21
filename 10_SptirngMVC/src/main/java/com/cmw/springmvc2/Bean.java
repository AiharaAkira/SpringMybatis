package com.cmw.springmvc2;

public class Bean {
	private int price;
	private int cnt;
	
	public Bean() {
		// TODO Auto-generated constructor stub
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Bean(int price, int cnt) {
		super();
		this.price = price;
		this.cnt = cnt;
	}
	
	
}
