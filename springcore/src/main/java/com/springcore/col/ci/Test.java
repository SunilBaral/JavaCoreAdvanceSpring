package com.springcore.col.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/col/ci/cicolconfig.xml");
		Student object = (Student) context.getBean("student");
		System.out.println(object);
	}

}
