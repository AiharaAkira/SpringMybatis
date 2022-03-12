package com.cmw.ajax;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuildingController extends HttpServlet {
	
	@Autowired
	private BuildingDAO bDAO;
	
	@RequestMapping(value = "/shop.getjson", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public String getJSON() {
		
		bDAO.getAllshop();
		
		return "index";
	}

}
