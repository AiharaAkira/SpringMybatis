package com.cm.springmvc3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "input";
	}
	
	@RequestMapping(value = "/record.show", method = RequestMethod.POST)
	public String record(StudentDTO sDTO, HttpServletRequest request) {
		
		DAO.cal(sDTO, request);
		return "output";
	}
	
	
	
}
