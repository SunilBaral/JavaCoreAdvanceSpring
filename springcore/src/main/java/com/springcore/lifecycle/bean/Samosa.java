package com.springcore.lifecycle.bean;

public class Samosa {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("price set");
		this.price = price;
	}

	public Samosa(int price) {
		super();
		this.price = price;
	}
	
	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	
	public void init() {
		System.out.println("init started");
	}
	
	public void destroy() {
		System.out.println("destroy started");
	}
	
}
