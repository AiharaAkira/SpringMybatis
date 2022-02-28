package com.mz.pj.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void login(Member m, HttpServletRequest req) {

		Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);

		if (dbMember != null) {
			if (m.getM_pw().equals(dbMember.getM_pw())) {
				req.getSession().setAttribute("loginMember", dbMember);
				req.getSession().setMaxInactiveInterval(60 * 10);
			} else {
				req.setAttribute("result", "로그인 실패(PW오류)");
			}
		} else {
			req.setAttribute("result", "로그인 실패(미가입ID)");
		}
	}
	
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	
	
	public void join(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			return;
		}
		try {
			String jm_id = mr.getParameter("m_id");
			String jm_pw = mr.getParameter("m_pw");
			String jm_name = mr.getParameter("m_name");
			String jm_addr1 = mr.getParameter("m_addr1");
			String jm_addr2 = mr.getParameter("m_addr2");
			String jm_addr3 = mr.getParameter("m_addr3");
			String jm_addr = jm_addr1 + "!" + jm_addr2 + "!" + jm_addr3;
			String jm_photo = mr.getFilesystemName("m_photo");
			jm_photo = URLEncoder.encode(jm_photo, "utf-8");
			jm_photo = jm_photo.replace("+", " ");

			m.setM_id(jm_id);
			m.setM_pw(jm_pw);
			m.setM_name(jm_name);
			m.setM_addr(jm_addr);
			m.setM_photo(jm_photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("m_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "가입실패");
		}
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	
	
	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String jm_addr = m.getM_addr();
		String[] jm_addr2 = jm_addr.split("!");
		req.setAttribute("addr", jm_addr2);

	}
	
	
	
	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

//			int msgCount = ss.getMapper(SNSMapper.class).getMsgCountByOwner(m);
//			int allMsgCount = sDAO.getAllMsgCount();

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("result", "탈퇴성공");

//				sDAO.setAllMsgCount(allMsgCount - msgCount);

				String path = req.getSession().getServletContext().getRealPath("resources/file");
				String jm_photo = m.getM_photo();
				jm_photo = URLDecoder.decode(jm_photo, "utf-8");
				new File(path + "/" + jm_photo).delete();

				logout(req);
				loginCheck(req);
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}
	}
	
	
	
	public void update(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		MultipartRequest mr = null;
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = loginMember.getM_photo();
		String newFile = null;
		
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("jm_photo");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			return;
		}
	
	
		try {
			String jm_id = mr.getParameter("jm_id");
			String jm_pw = mr.getParameter("jm_pw");
			String jm_name = mr.getParameter("jm_name");
			String jm_addr1 = mr.getParameter("jm_addr1");
			String jm_addr2 = mr.getParameter("jm_addr2");
			String jm_addr3 = mr.getParameter("jm_addr3");
			String jm_addr = jm_addr1 + "!" + jm_addr2 + "!" + jm_addr3;
			String jm_photo = newFile;

			m.setM_id(jm_id);
			m.setM_pw(jm_pw);
			m.setM_name(jm_name);
			m.setM_addr(jm_addr);
			m.setM_photo(jm_photo);

			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("result", "수정성공");
				req.getSession().setAttribute("loginMember", m);
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
	
			} else {
				req.setAttribute("result", "수정실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
				}
				new File(path + "/" + newFile).delete();
			}
		}
	}

	
	
	public int getMemberNum(Member m, HttpServletRequest req) {
		System.out.println(ss.getMapper(MemberMapper.class).getMemberNum(m));
		return ss.getMapper(MemberMapper.class).getMemberNum(m);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
