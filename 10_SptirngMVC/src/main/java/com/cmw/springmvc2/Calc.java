package com.cmw.springmvc2;

import javax.servlet.http.HttpServletRequest;

public class Calc {

	public static void calc(Bean b, HttpServletRequest request) {
		
		System.out.println("상품가격:" + (b.getPrice()));
		System.out.println("상품갯수:" + (b.getCnt()));
		System.out.println("총상품가격:" + (b.getPrice() * b.getCnt()));
		
		request.setAttribute("r", b.getPrice() * b.getCnt());
		
		
	}

}
