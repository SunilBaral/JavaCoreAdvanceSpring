package com.springcore.ci;

public class Person {
	private String name;
	private int personId;
	private Cert cert;
	public Person(String name, int personId,Cert cert) {
		this.name = name;
		this.personId = personId;
		this.cert=cert;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" : "+this.personId+" : "+this.cert;
	}
	
	
}
