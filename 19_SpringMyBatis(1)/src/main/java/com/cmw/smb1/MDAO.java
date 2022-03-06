package com.cmw.smb1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllMenu(HttpServletRequest request) {

		
		//전체조회
		MyMapper mm = ss.getMapper(MyMapper.class);
		List<Menu> menus = mm.showAllMenu();
		request.setAttribute("menus", menus);
	}

	public void regMenu(Menu m, HttpServletRequest request) {
		
		//등록
		MyMapper mm = ss.getMapper(MyMapper.class);
		if(mm.regMenu(m)==1) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
			
		}
		
		
	}
	
	public void delMenu(Menu m, HttpServletRequest request) {
		MyMapper mm = ss.getMapper(MyMapper.class);
		
		if(mm.delMenu(m) == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
			
		}
	}
	
	public void updateMenu(Menu m, HttpServletRequest request) {
		MyMapper mm = ss.getMapper(MyMapper.class);
		
		if(mm.updateMenu(m) == 1) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
			
		}
	}

	public void getMenu(Menu m, HttpServletRequest request) {
		//조회
				MyMapper mm = ss.getMapper(MyMapper.class);
				Menu menu = mm.detailMenu(m);
				request.setAttribute("menu123", menu);
	}

	
	
}
