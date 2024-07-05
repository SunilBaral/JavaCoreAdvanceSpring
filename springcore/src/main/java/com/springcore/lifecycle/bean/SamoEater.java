package com.springcore.lifecycle.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SamoEater {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/lifecycle/bean/lifcycleconfig.xml");
		context.registerShutdownHook();
//		
//		 Samosa s = (Samosa) context.getBean("samosa");
//		 
//		 System.out.println(s);
//		 
//		 
//		  
//		 
//		  System.out.println("++++++++++++++++++++++++++");
//		  
//		 Pepsi p = (Pepsi) context.getBean("pep");
//		 
//		 System.out.println(p);
		Tea t=(Tea) context.getBean("tea");
		
		System.out.println(t);
		 

	}

}
