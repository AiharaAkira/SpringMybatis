package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMain {

	public static void main(String[] args) {

try {
			
			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
			
			System.out.println("mb연결성공");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("삭제할 커피 이름:");
			String name = sc.next(); 
			int price = 0;
			
			Coffee c = new Coffee(name, price);
			
			if(ss.delete("cmwqqq.deleteCoffee",c)==1) {
				System.out.println("삭제성공");
				ss.commit();
			}else {
				System.out.println("삭제실패");
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("mb연결실패");
			
		}
		
	}

}
