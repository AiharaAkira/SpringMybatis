package com.cmw.springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP - Controller - Servlet
// doGet
// doPost
// IP주소/프로젝트명/컨트롤러명?...

// Spring - Controller - 일반 class @Controller 
// 일반메서드 - 요청에 따라 매핑 @RequestMapping(value="")로 매핑
// IP주소/top-level 끝자리 / 내맘

@Controller  //Spring이 컨트롤러로 인식
public class HC {

	@RequestMapping(value="/")  
	public String goIndex() {
		
		//forward로 항상 엔딩을 쳤었는데 이걸 짧게 잘 정리 해놓음.
		//메서드 반환 String
		
		return "index"; //index.jsp로 포워딩
	}
	
	@RequestMapping(value="index.go")  
	public String gg() {
		
		System.out.println("index.go 로 요청받음");
		
		return "index"; 
	}
	
	@RequestMapping(value="index.do")  
	public String zzzz() {
		
		System.out.println("index.do 로 요청받음");
		
		return "index"; 
	}
	
	//top-level/t get요청하면 콘솔에 ttt를 출력
	
	@RequestMapping(value="t")  
	public String ttt() {
		
		System.out.println("t 로 요청받음");
		
		return "index"; 
	}
	
	@RequestMapping(value="a.a")  
	public String aaa() {
		
		System.out.println("a.a 로 요청받음");
		
		return "index"; 
	}
	
	@RequestMapping(value="b", method= RequestMethod.GET)  
	public String bbbbbb() {
		
		System.out.println("bbb 로 요청받음");
		
		return "index"; 
	}
	
}
