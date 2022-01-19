package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain2 {

	public static void main(String[] args) {
		// 입력 받은 값이상의 커피들 가격을 xxx으로

		try {

			String resource = "config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("mb연결성공");

			Scanner sc = new Scanner(System.in);

			System.out.println("얼마 이상짜리?:");
			int price1 = sc.nextInt();
			System.out.println("얼마로 수정?");
			int price2 = sc.nextInt();

			Price p = new Price(price1, price2);

			if (ss.update("cmwqqq.updateCoffee_OverPrice",p) >= 1 ) {
				System.out.println("수정성공!");
				ss.commit();
				sc.close();
			} else {
				System.out.println("수정실패!");

			}

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("mb연결실패");

		}

	}

}
