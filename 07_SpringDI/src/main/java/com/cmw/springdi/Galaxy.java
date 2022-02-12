package com.cmw.springdi;

public class Galaxy implements Phone {

	public Galaxy() {
		logo();
	}

	@Override
	public void logo() {
		System.out.println("samsung");
	}
	
	
	
}
