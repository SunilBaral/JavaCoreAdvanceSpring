package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereotypeconfig.xml");
		Student s = context.getBean("student",Student.class);
		System.out.println(s);
		System.out.println(s.getCourse());
	}
}
