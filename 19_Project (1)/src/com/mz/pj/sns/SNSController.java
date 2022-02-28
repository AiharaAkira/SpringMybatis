package com.mz.pj.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.pj.SiteOption;
import com.mz.pj.TokenMaker;
import com.mz.pj.member.MemberDAO;

@Controller
public class SNSController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		TokenMaker.make(req);
		SiteOption.clearSearch(req);
		sDAO.getMsg(1, req);
		
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "sns.page.change", method = RequestMethod.GET)
	public String snsPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		mDAO.loginCheck(req);
		sDAO.getMsg(p, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "sns.search", method = RequestMethod.GET)
	public String snsSearch(SNSSelector sSel, HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		sDAO.searchMsg(sSel, req);
		sDAO.getMsg(1, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "sns.write", method = RequestMethod.GET)
	public String snsWrite(SNSMsg sm, HttpServletRequest req) {
		TokenMaker.make(req);	//  302
		// 처음 쓰면 parameter token = 396
		if(mDAO.loginCheck(req)) {
			sDAO.writeMsg(sm, req);
		}
		
		sDAO.getMsg(1, req);
		
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr, HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		if (mDAO.loginCheck(req)) {
			sDAO.writeReply(sr, req);
		}
		sDAO.getMsg(p, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "sns.delete", method = RequestMethod.GET)
	public String snsDelete(SNSMsg sm, HttpServletRequest req) {
		TokenMaker.make(req);
		SiteOption.clearSearch(req);
		if (mDAO.loginCheck(req)) {
			sDAO.deleteMsg(sm, req);
		}
		sDAO.getMsg(1, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	@RequestMapping(value = "sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr, HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		if (mDAO.loginCheck(req)) {
			sDAO.deleteReply(sr, req);
		}
		sDAO.getMsg(p, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	@RequestMapping(value = "sns.update", method = RequestMethod.GET)
	public String snsUpdate(SNSMsg sm, HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		if (mDAO.loginCheck(req)) {
			sDAO.updateMsg(sm, req);
		}
		sDAO.getMsg(p, req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		return "index";
	}
	
	
	
}
