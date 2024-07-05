package com.springcore.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/spel/spelconfig.xml");
		Demo d = context.getBean("demo",Demo.class);
		
		System.out.println(d);
		
		SpelExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("9+9");
		System.out.println(expression.getValue());
		
	}
}
