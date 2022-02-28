package com.mz.pj.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.pj.TokenMaker;
import com.mz.pj.member.MemberDAO;

@Controller
public class GalleryController {

	@Autowired
	private GalleryDAO gDAO;
	
	@Autowired
	private MemberDAO mDAO;

	@RequestMapping(value = "gallery.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		TokenMaker.make(req);
		gDAO.getFile(req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "gallery/gallery.jsp");
		return "index";
	}
	
	@RequestMapping(value = "gallery.upload", method = RequestMethod.POST)
	public String dataroomUpload(GalleryFile gf, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			gDAO.upload(gf, req);
		}
		TokenMaker.make(req);
		gDAO.getFile(req);
		req.setAttribute("contentPage", "gallery/gallery.jsp");
		return "index";
	}
	
	@RequestMapping(value = "gallery.delete", method = RequestMethod.GET)
	public String dataroomDelete(GalleryFile gf, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
//			gDAO.deleteFile(gf, req);
		}
		TokenMaker.make(req);
		gDAO.getFile(req);
		req.setAttribute("contentPage", "gallery/gallery.jsp");
		return "index";
	}
	

}
