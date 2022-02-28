package com.mz.pj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.pj.sns.SNSDAO;

@Controller
public class HomeController {
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	
	@Autowired
	private SNSDAO sDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		if(firstReq) {
		sDAO.getAllMsgCount();
		firstReq = false;
		}
		
		req.setAttribute("loginPage", "member/login.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		return home(req);
	}
	
}
