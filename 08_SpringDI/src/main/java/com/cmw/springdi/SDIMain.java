package com.cmw.springdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain {

	public static void main(String[] args) {

		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);

		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));

		// 강아지

		// 이름

		// 나이

		// 정보출력

		// beans.xml에 만들어 놓은 id가 d인 객체를 불러오기
		// 최초로 부를때 생성
		Dog d = dlbf.getBean("d", Dog.class);
		d.info();

		// 실제 다른 강아지를 원하면 xml에 하나 더 만들어 줘야함
		Dog d2 = dlbf.getBean("d2", Dog.class);
		d2.info();

		Dog d3 = dlbf.getBean("d3", Dog.class);
		d3.info();

		Dog d4 = dlbf.getBean("d4", Dog.class);
		d4.info();

		System.out.println("------------------------------");

		// 이름이 민우 나이가 27 키가 188 체중이 80인 사람 생성 후 그사람 정보 출력
		// 이름이 아키라 나이가 17 키가 188 체중이 80인 사람 생성 후 그사람 정보 출력

		Human h = dlbf.getBean("h", Human.class);
		h.info();
		Human h2 = dlbf.getBean("h2", Human.class);
		h2.info();

		System.out.println("------------------------------");
		//커피
		//아메리카노
		//원두
		//물
		Coffee c = dlbf.getBean("c", Coffee.class);
		c.printInfo();
		
		System.out.println("----------------");
		//고양이
		
		Cat c1 = dlbf.getBean("cat", Cat.class);
		c1.info();
	}

}
