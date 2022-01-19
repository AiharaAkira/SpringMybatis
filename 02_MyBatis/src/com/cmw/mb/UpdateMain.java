package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain {
	public static void main(String[] args) {

try {
			
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			//커피 가격 수정
			//입력한 그 커피만 가격 수정
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("가격 수정할 커피:");
			String name = sc.next();
			System.out.println("얼마로 수정?");
			int price = sc.nextInt();
			
			Coffee c = new Coffee(name, price);
			
			
			
			if(ss.update("cmwqqq.updatePrice", c)==1) {
				System.out.println("수정성공!");
				ss.commit();
			}else {
				System.out.println("수정실패!");
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb연결실패");
			
		}
		
	}
}
