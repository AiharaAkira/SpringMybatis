package com.cmw.springmvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "input";
	}

	@RequestMapping(value = "/calc.do1", method = RequestMethod.GET)
	public String aaa(HttpServletRequest request) {

		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));

		System.out.println("a+b=" + (a + b));

		return "input";
	}

	// 2)Sptring

/*	@RequestMapping(value = "/calc.do", method = RequestMethod.GET)
	public String bbb(@RequestParam(value = "a") int aaa, @RequestParam(value = "b") int bbb) {


		System.out.println("a+b=" + (aaa + bbb));

		return "input";
	}*/
	
	//3)스프링 스타일(객체 형태)- 최종형태
	
	@RequestMapping(value = "/calc.do", method = RequestMethod.GET)
	public String bbb(Data d) {


		System.out.println("a+b=" + (d.getA() + d.getB()));

		return "input";
	}
	
	@RequestMapping(value = "/item.purchase", method = RequestMethod.GET)
	public String itemPurchase(Bean b, HttpServletRequest request) {


		Calc.calc(b, request);
		

		return "output";
	}
	
	

}
