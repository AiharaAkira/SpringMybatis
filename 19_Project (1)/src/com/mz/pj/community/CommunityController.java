package com.mz.pj.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.pj.member.MemberDAO;

@Controller
public class CommunityController {

	@Autowired
	private CommunityDAO cDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	
	
	@RequestMapping(value = "community.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		cDAO.getMember(req);
		
		if(mDAO.loginCheck(req)) {
			cDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	@RequestMapping(value = "community.send", method = RequestMethod.GET)
	public String communitySend(CommunityMsg cm, HttpServletRequest req) {
		cDAO.getMember(req);
		if (mDAO.loginCheck(req)) {
			cDAO.sendMsg(cm, req);
			cDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	@RequestMapping(value = "community.delete", method = RequestMethod.GET)
	public String communityDelete(CommunityMsg cm, HttpServletRequest req) {
		cDAO.getMember(req);
		if (mDAO.loginCheck(req)) {
			cDAO.deleteMsg(cm, req);
			cDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	
}
