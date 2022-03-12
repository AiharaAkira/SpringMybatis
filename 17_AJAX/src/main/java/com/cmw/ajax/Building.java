package com.cmw.ajax;

import java.util.List;

public class Building {

	private List<Shop> shops;
	
	
	
	public Building(List<Shop> shops) {
		super();
		this.shops = shops;
	}



	public List<Shop> getShops() {
		return shops;
	}



	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}



	public Building() {
		// TODO Auto-generated constructor stub
	}
	
}
