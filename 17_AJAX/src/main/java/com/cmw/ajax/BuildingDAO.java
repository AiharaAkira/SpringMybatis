package com.cmw.ajax;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingDAO {

	@Autowired
	private SqlSession ss;

	public void getAllshop() {
			
		return new Building(ss.getMapper(BuildingMapper.class).getAllShop());
		
	}

}
