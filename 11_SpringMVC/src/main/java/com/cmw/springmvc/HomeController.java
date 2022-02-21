package com.cmw.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//11_SpringMvc
	
		//v=x,y
		//calc.do
		//모델 거쳐서 결과페이지에 +,- 결과 값 출력

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "input";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "output";
	}
	
}