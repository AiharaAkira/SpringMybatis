package com.cmw.ajax;

import java.util.List;
import java.util.Map;

public interface BuildingMapper {

	List<Shop> getAllShop();

	List<Shop> searchShop(Map<String, String> shops);

}
