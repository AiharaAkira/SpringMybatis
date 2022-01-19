package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain2 {

	public static void main(String[] args) {
		// 이름으로 검색
		try {

			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("mb연결성공");

			Scanner sc = new Scanner(System.in);

			System.out.println("검색할 커피이름:");
			
			String name = sc.next();

			Coffee c2 = new Coffee(name, 0);

			List<Coffee> coffees = ss.selectList("cmwqqq.getAllCoffee_name",c2);

			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("---------------");
			}

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("mb연결실패");

		}

	}

}
