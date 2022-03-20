package com.cmw.ajax;

import java.util.List;

public interface MenuMapper {

	List<Menu> getAllMenu();

	List<Menu> getMenuJSONByName(Menu m);

}
