package com.cmw.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;


//xml 에 빈등록
@Service
public class M {
	public void calc(Bean b, HttpServletRequest request) {

		int x = b.getX();
		int y = b.getY();
		
		request.setAttribute("r", (x+y));
		
	}
}
