package com.springcore.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Tea {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Tea() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tea [price=" + price + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("starting method");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("ending method");
	}
}
