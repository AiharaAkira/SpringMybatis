package com.mz.pj.dataroom;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.pj.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataRoomDAO {

	@Autowired
	private SqlSession ss;
	
	
	
	public void getFile(HttpServletRequest req) {
		try {
			req.setAttribute("files", ss.getMapper(DataRoomMapper.class).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void upload(DataRoomFile df, HttpServletRequest req) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		MultipartRequest mr = null;
		String token = null;
		try {
			mr = new MultipartRequest(req, path, 1500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			token = mr.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			
			if (successToken != null && token.equals(successToken)) {
				String fileName = mr.getFilesystemName("d_file");
				new File(path + "/" + fileName).delete();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			df.setD_owner(m.getM_id());
			df.setD_title(mr.getParameter("d_title"));
			String d_file = mr.getFilesystemName("d_file");
			d_file = URLEncoder.encode(d_file, "utf-8");		// 파일명 한글 관련 처리
			df.setD_file(d_file.replace("+", " "));
			df.setD_category(mr.getParameter("d_category"));

			if (ss.getMapper(DataRoomMapper.class).upload(df) == 1) {
				req.setAttribute("result", "업로드성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("d_file");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "업로드실패");
		}
	}
	
	
	public void deleteFile(DataRoomFile df, HttpServletRequest req) {
		
		try {
			if (ss.getMapper(DataRoomMapper.class).delete(df) == 1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				new File(path + "/" + URLDecoder.decode(df.getD_file(), "utf-8")).delete();
			} else {
				req.setAttribute("result", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
		
	}
}
