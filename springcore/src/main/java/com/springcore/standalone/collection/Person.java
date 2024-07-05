package com.springcore.standalone.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private List<String> student;
	private Map<String, Integer> course;
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Map<String, Integer> getCourse() {
		return course;
	}

	public void setCourse(Map<String, Integer> course) {
		this.course = course;
	}

	public List<String> getStudent() {
		return student;
	}

	public void setStudent(List<String> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Person [student=" + student + ", course=" + course + "]";
	}

}
