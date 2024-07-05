package com.springcore.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/standalone/collection/aloneconfig.xml");
		Person p = (Person) context.getBean("per");
		System.out.println(p);
		System.out.println(p.getStudent());
		System.out.println(p.getCourse());
		System.out.println(p.getProperties());
	}

}
