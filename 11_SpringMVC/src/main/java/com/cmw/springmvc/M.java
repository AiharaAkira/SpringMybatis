package com.cmw.springmvc;

import javax.servlet.http.HttpServletRequest;

public class M {

	public void calc(Bean b, HttpServletRequest request) {

		int x = b.getX();
		int y = b.getY();
		
		request.setAttribute("r", (x+y));
		
	}
}
