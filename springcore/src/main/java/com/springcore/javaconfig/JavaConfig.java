package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;

public class JavaConfig {
	@Bean
	public Samosa getSamosa() {
		return new Samosa();
	}
	
	
	@Bean
	public Student getStudent() {

		// creating a new student object
		Student student = new Student(getSamosa());
		return student;

	}
}
