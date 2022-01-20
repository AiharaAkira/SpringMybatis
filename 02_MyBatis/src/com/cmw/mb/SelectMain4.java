package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain4 {

	public static void main(String[] args) {

		//~이상~이하 검색
		//1000~5000원인 커피들
		
try {
			
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("최소가격:");
			int price1 = sc.nextInt();
			System.out.println("최대가격:");
			int price2 = sc.nextInt();
			
			Map<String, Integer> price = new HashMap<String, Integer>();
			price.put("price1", price1);
			price.put("price2", price2);
			
			List<Coffee> coffees = ss.selectList("cmwqqq.selectPrice",price);
			
			for (Coffee coffee : coffees) {
				System.out.println(coffee.getC_name());
				System.out.println(coffee.getC_price());
				System.out.println("------------");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb연결실패");
			
		}
		
		
	}

}
