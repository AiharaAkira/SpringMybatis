package com.cmw.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private M m;
	// 11_SpringMvc

	// v=x,y
	// calc.do
	// 모델 거쳐서 결과페이지에 +,- 결과 값 출력

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "input";
	}

	@RequestMapping(value = "/calc.do", method = RequestMethod.GET)
	public String home(Bean b, HttpServletRequest request) {
		m.calc(b, request);

		return "output";
	}

}
