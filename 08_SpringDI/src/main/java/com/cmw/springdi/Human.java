package com.cmw.springdi;

public class Human {
	private String name;
	private int age;
	private double weight;
	private double height;
	
	public Human() {
		// TODO Auto-generated constructor stub
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Human(String name, int age, double weight, double height) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public void info() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(height);
	}
	
	
}
