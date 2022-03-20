package com.cmw.ajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {

	
	@Autowired
	private SqlSession ss;
	
	public Menus getAllMenu() {
		
		List<Menu> menus = ss.getMapper(MenuMapper.class).getAllMenu();
		Menus m = new Menus(menus);
		
		return m;
	}

	public Menus getMenuJSONByName(Menu mmm) {
		
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenuJSONByName(mmm);
		Menus m = new Menus(menus);
		
		return m;
	}

}
