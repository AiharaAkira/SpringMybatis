package com.cmw.springdi;

import java.util.ArrayList;
import java.util.HashMap;

public class Coffee {
	
	private ArrayList<String> jaeryo;
	private HashMap<String, Double> info;

	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getJaeryo() {
		return jaeryo;
	}

	public void setJaeryo(ArrayList<String> jaeryo) {
		this.jaeryo = jaeryo;
	}

	public HashMap<String, Double> getInfo() {
		return info;
	}

	public void setInfo(HashMap<String, Double> info) {
		this.info = info;
	}

	public Coffee(ArrayList<String> jaeryo, HashMap<String, Double> info) {
		super();
		this.jaeryo = jaeryo;
		this.info = info;
	}
	
	public void printInfo() {
		for (String s : jaeryo) {
			System.out.println(s);
		}
		
		System.out.println("------------");
		
		System.out.println(info.get("탄"));
		System.out.println(info.get("단"));
		System.out.println(info.get("지"));
	}
	
}


