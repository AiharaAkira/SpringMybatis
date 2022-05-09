package com.mz.pj.gallery;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.util.URLEncoder;
import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.pj.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {

	@Autowired
	private SqlSession ss;
	
	public void getFile(HttpServletRequest req) {
		try {
			req.setAttribute("files", ss.getMapper(GalleryMapper.class).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload(GalleryFile gf, HttpServletRequest req) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		String token = null;
		try {
			mr = new MultipartRequest(req, path, 1500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			token = mr.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			if (successToken != null && token.equals(successToken)) {
				String fileName = mr.getFilesystemName("g_file");
				new File(path + "/" + fileName).delete();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			gf.setG_owner(m.getM_id());
			gf.setG_title(mr.getParameter("g_title"));
			String g_file = mr.getFilesystemName("g_file");
			g_file = URLEncoder.encode(g_file, "utf-8");
			gf.setG_file(g_file.replace("+", " "));

			if (ss.getMapper(GalleryMapper.class).upload(gf) == 1) {
				req.setAttribute("result", "업로드성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("g_file");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "업로드실패");
		}
		
	}
	
//	
//	public void deleteFile(GalleryFile gf, HttpServletRequest req) {
//		try {
//			if (ss.getMapper(GalleryMapper.class).delete(gf) == 1) {
//				req.setAttribute("result", "삭제성공");
//				String path = req.getSession().getServletContext().getRealPath("resources/img");
//				new File(path + "/" + URLDecoder.decode(gf.getG_file(), "utf-8")).delete();
//			} else {
//				req.setAttribute("result", "삭제실패");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("result", "삭제실패");
//		}
//	}

}
