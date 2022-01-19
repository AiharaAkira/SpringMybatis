package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SelectMain {

	public static void main(String[] args) {
try {
			
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			//mybatis로 셀렉트 하면
			//jsp에서 했던 execute 실행해서 rs에 담아서 빈, 객체, arrayList에 추가 등등
			//그걸 자동으로 다 해줌
			//규칙을 따라야함
			//자바빈 멤버변수명 = db필드명
			
			//mapper.xml
			//자바 객체로 만들어서 주는데 뭘로 만들어서 줄까?
			
			//namespace.태그에 부여한 id
			
			
			
			List<Coffee> coffees =  ss.selectList("cmwqqq.getAllCoffee");
			
			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("---------------");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb조회실패");
			
		}

	

	}

}
