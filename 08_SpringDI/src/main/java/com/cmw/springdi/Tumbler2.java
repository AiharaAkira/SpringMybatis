package com.cmw.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Tumbler2 {
	@Qualifier("catMaster")
	@Autowired
	private Human owner;
	
	public Tumbler2() {
	}

	public Human getOwner() {
		return owner;
	}

	public void setOwner(Human owner) {
		this.owner = owner;
	}

	public Tumbler2(Human owner) {
		super();
		this.owner = owner;
	}
	
	public void info() {
		owner.info();
	}
	
	
	
	
}
