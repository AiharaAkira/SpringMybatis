package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {

	public static void main(String[] args) {
try {
			
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("====커피등록===");
			System.out.println("====커피명:===");
			String name = sc.next();
			System.out.println("====가격:===");
			int price = sc.nextInt();
			
			Coffee c = new Coffee(name, price);
			
			if(ss.insert("cmwqqq.regCoffee", c)==1) {
				System.out.println("커피등록성공!");
				ss.commit();
			}else {
				System.out.println("커피등록실패!");
				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb연결실패");
			
		}

	}

}
