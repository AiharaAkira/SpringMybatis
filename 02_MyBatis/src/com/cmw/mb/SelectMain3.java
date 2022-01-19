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

public class SelectMain3 {

	public static void main(String[] args) {

try {
			//입력한 가격 이하의 커피 검색
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("최소가격 검색:");
			int price1 = sc.nextInt();
			
			Map<String, Integer> price = new HashMap<String, Integer>();
			price.put("price1", price1);
			
			List<Coffee> coffees = ss.selectList("cmwqqq.LowerPriceSelect",price);
			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("----------------");
			}
			sc.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb연결실패");
			
		}
		
	}

}
