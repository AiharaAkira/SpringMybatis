package com.cmw.springdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

//	 Spring? : IoC로 DI해주는 framework
// 왜 쓸까? '유지보수'

//DI(Dependency Injection) - 의존성 주입
//객체 만들고, 속성 값 세팅하는 거(애플폰 만들고 모델명, 무게)

//IoC(Inversion of Controll) - 제어의 역전
//일반적: program -(제어)> file
//스프링: file -(제어)> program



public class SIMain {

	public static void main(String[] args) {

		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		
		xbdr.loadBeanDefinitions(new ClassPathResource("asd.xml"));
		
		//2.다형성
		
		Phone p = dlbf.getBean("phone", Phone.class);
		p.logo();
		
		
	}

}
