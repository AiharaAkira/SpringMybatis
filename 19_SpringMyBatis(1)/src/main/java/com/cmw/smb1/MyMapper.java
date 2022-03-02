package com.cmw.smb1;

import java.util.List;

public interface MyMapper {

	//select(결과가 여러개) > List
	
	List<Menu> showAllMenu();

	int regMenu(Menu m);

}
