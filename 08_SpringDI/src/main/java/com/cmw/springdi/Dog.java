package com.cmw.springdi;

public class Dog {

	private String name;
	private int age;
	
	public Dog() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public void info() {
		System.out.println(name);
		System.out.println(age);
	}
	
	
}
