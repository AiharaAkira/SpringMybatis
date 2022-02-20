package com.cmw.springdi;

public class Human2 {

	private String name;
	
	public Human2() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Human2(String name) {
		super();
		this.name = name;
	}
	
	public void info() {
		System.out.println(name);
	}
	
}
