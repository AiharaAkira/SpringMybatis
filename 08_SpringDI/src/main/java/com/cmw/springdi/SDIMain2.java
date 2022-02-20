package com.cmw.springdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain2 {

	public static void main(String[] args) {

		//beans.xml에 등록된거 그냥 다 생성(안불러도 생성함)
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		//aac가 없어질때 등록된 객체들 메모리 정리하기
		aac.registerShutdownHook();
		
		Human h = aac.getBean("catMaster", Human.class);
		h.info();
		
		//dlbf가 객체를 불러올때 딱 생성해주기 때문에 더 좋은 방식이지만 
		//Spring의 어떤 기능들에서는 aac방식을 반드시 써야만 하는 경우가 꽤있음
		//그래서 2가지 방법을 소개
		
		System.out.println("---------텀블러---------");
		
		Tumbler t = aac.getBean("t", Tumbler.class);
		t.info();
		
		Tumbler2 tum2 = aac.getBean("tum2", Tumbler2.class);
		tum2.info();
		
	}

}
