package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Student {
	@Value("sunil")
	private String name;
	@Value("bbsr")
	private String adress;
	@Value("#{cur}")
	private List<String> course;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}

	public List<String> getCourse() {
		return course;
	}

	public void setCourse(List<String> course) {
		this.course = course;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", adress=" + adress + "]";
	}
	
}
