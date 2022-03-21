package com.cmw.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Menus {
	private List<Menu> zzzz;
	
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}


	public List<Menu> getZzzz() {
		return zzzz;
	}

	@XmlElement
	public void setZzzz(List<Menu> zzzz) {
		this.zzzz = zzzz;
	}


	public Menus(List<Menu> zzzz) {
		super();
		this.zzzz = zzzz;
	}
	
	
	
	
	
	
}
