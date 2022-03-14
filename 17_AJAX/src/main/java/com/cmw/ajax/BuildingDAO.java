package com.cmw.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.stereotype.Service;

@Service
public class BuildingDAO {

	@Autowired
	private SqlSession ss;

	public Building getAllshop() {
			
		return new Building(ss.getMapper(BuildingMapper.class).getAllShop());
		
	}

	public Building searchSHOP(HttpServletRequest request) {
		Map<String, String> shops = new HashMap<String, String>();
		shops.put("start", request.getParameter("start"));
		shops.put("end", request.getParameter("end"));
		
		System.out.println("서치 성공");
		
		return new Building(ss.getMapper(BuildingMapper.class).searchShop(shops));
	}

}
