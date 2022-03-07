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

		// 전체조회
		MyMapper mm = ss.getMapper(MyMapper.class);
		List<Menu> menus = mm.showAllMenu();
		request.setAttribute("menus", menus);
	}

	public void regMenu(Menu m, HttpServletRequest request) {

		// 등록
		MyMapper mm = ss.getMapper(MyMapper.class);
		if (mm.regMenu(m) == 1) {
			System.out.println("등록성공");
		} else {
			System.out.println("등록실패");

		}

	}

	public void delMenu(Menu m, HttpServletRequest request) {
		MyMapper mm = ss.getMapper(MyMapper.class);

		if (mm.delMenu(m) == 1) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");

		}
	}

	public void updateMenu(Menu m, HttpServletRequest request) {
		MyMapper mm = ss.getMapper(MyMapper.class);

		
		if (m.getM_name() != null && m.getM_name() != "") {

			// 가격 메뉴명 변경
			if (mm.updateMenu2(m) == 1) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");

			}
		} else {

			// 가격 변경
			if (mm.updateMenu(m) == 1) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");

			}
		}

	}

	public void getMenu(Menu m, HttpServletRequest request) {
		// 조회
		MyMapper mm = ss.getMapper(MyMapper.class);
		Menu menu = mm.detailMenu(m);
		request.setAttribute("menu123", menu);

		// 스프링이 자바Bean 이름과 같은 상태로 어트리뷰트 값 만들어줌. 넘겨받은 값을 세팅한 상태로,
		// 그래서 그 bean 이름으로 쓰면 넘겨받은 값 제외하고는 나오지를 않음.

		// 결론은 우선순위가 Menu > menu 이름의 어트리뷰트가 우선
		// 덮어쓰기 안됨 ex)dao에서 값을 빼온 객체를 설정했다 하더라도 그 값이 덮어 씌워 들어가지를 않음.

	}

//	public void updateMenu2(Menu m, HttpServletRequest request) {
//		MyMapper mm = ss.getMapper(MyMapper.class);
//		
//		if(mm.updateMenu2(m) == 1) {
//			System.out.println("수정성공");
//		}else {
//			System.out.println("수정실패");
//			
//		}
//	}

}
