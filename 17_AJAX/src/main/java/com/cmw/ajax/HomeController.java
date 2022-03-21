package com.cmw.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String home1() {
		
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index2";
	}
	
	@RequestMapping(value = "/menu.get.json", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Menus menuJson() {
		Menus mm = mDAO.getAllMenu();
		return mm;
	}
	
	@RequestMapping(value = "/menu.get.xml", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuXml() {
		
		Menus mm = mDAO.getAllMenu();
		return mm;
	}
	
	@RequestMapping(value = "/menu.get.json.name", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Menus menuJsonByName(Menu m) {
		
		Menus mm = mDAO.getMenuJSONByName(m);
		return mm;
	}
	
	@RequestMapping(value = "/menu.get.xml.name", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuXmlByName(Menu m) {
		
		Menus mm = mDAO.getMenuXmlByName(m);
		return mm;
	}
	
}
