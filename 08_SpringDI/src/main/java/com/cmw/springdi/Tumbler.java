package com.cmw.springdi;

import org.springframework.beans.factory.annotation.Autowired;

public class Tumbler {
	//자동으로 만들고 연결해주는...(DI)
	@Autowired 
	private Human2 owner;
	
	public Tumbler() {
		// TODO Auto-generated constructor stub
	}

	public Human2 getOwner() {
		return owner;
	}

	public void setOwner(Human2 owner) {
		this.owner = owner;
	}

	public Tumbler(Human2 owner) {
		super();
		this.owner = owner;
	}
	
	public void info() {
		owner.info();
	}
	
}
