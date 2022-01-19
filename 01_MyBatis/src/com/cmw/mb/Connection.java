package com.cmw.mb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//유지보수

//그 외부 파일이 어떤 형식이 있으면 좋을 것 : xml

//xml : 각종 설정파일에서 사용
//json : 네트워크 상에서 데이터 주고 받을때 사용

//db 

//서버정보									sql
//jdbc   			DBManager.java    	DAO.java
//ConnectionPool	.xml				DAO.java
//myBatis			.xml				.xml

//MyBatis(3.x)
//iBatis(2.x)(이전버전)
//Db ORM(Object Relation Mapping) Framework 자바 객체랑 자동으로 매핑

//mybatis.jar

public class Connection {

	public static void main(String[] args) {
		try {

			String resource = "config.xml";
			
			//cinfig.xml 에서 읽어낼 수 있는 도구 inputStream
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			//공장빌더 ssfb
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//					.build(inputStream);
			//공장(이공장은  빌더가 설계도를 가지고 만드는 것) ssf
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
			//공장 문 연 것 ss
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			System.out.println("성공");
			
			String resource1 = "config.xml";
			InputStream inputStream1 = Resources.getResourceAsStream(resource1);
			SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream1);
			SqlSession ss = sqlSessionFactory1.openSession();
			
			System.out.println("성공2");
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
