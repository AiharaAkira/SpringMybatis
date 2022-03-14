package com.cmw.ajax;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuildingController extends HttpServlet {
	
	@Autowired
	private BuildingDAO bDAO;
	
	@RequestMapping(value = "/shop.getxml", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Building getXML() {
		
		bDAO.getAllshop(); //빌딩 (가게들을 가지고 있는)이 리턴되는거
		
		return bDAO.getAllshop();
	}
	
	
	@RequestMapping(value = "/shop.getjson", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Building getJSON() {
		
		bDAO.getAllshop(); //빌딩 (가게들을 가지고 있는)이 리턴되는거
		
		return bDAO.getAllshop();
	}
	
	@RequestMapping(value = "/shop.search", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Building shopSearch(HttpServletRequest request) {
		
		bDAO.searchSHOP(request); //빌딩 (가게들을 가지고 있는)이 리턴되는거
		
		return bDAO.searchSHOP(request);
	}

}
