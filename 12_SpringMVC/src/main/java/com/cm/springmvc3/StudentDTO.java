package com.cm.springmvc3;

public class StudentDTO {

	private String n;
	private double m;
	private double f;
	private double avg;
	private String grade;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}
	
	

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public StudentDTO(String n, double m, double f, double avg, String grade) {
		super();
		this.n = n;
		this.m = m;
		this.f = f;
		this.avg = avg;
		this.grade = grade;
	}

	
	
	
	
}
