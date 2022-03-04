package com.cmw.smb1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private MDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/menu.show", method = RequestMethod.GET)
	public String getAllMenu(HttpServletRequest request) {
		//모델
		//select
		mDAO.getAllMenu(request);
		
		return "select";
	}
	
	@RequestMapping(value = "/menu.reg.go", method = RequestMethod.GET)
	public String regMenuGo(HttpServletRequest request) {
		//모델
		
		return "insert";
	}
	
	@RequestMapping(value = "/menu.reg.do", method = RequestMethod.GET)
	public String regMenuDo(Menu m,HttpServletRequest request) {
		//모델
		mDAO.regMenu(m,request);
		return "home";
	}
	
}
