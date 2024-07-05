package com.springcore.auto.wire.annotation;

public class Adress {
	private String name;
	private String place;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Adress(String name, String place) {
		super();
		this.name = name;
		this.place = place;
	}
	
	public Adress() {
		super();
	}
	@Override
	public String toString() {
		return "Adress [name=" + name + ", place=" + place + "]";
	}
	
}
