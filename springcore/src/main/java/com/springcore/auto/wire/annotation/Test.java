package com.springcore.auto.wire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/auto/wire/annotation/autoanoconfig.xml");
		Emp emp = context.getBean("emp1",Emp.class);
		System.out.println(emp);
	}

}
