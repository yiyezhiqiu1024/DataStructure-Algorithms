package com.zeng;

public class Person {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.name == p.name && this.age == p.age;
	}
	
	@Override
	protected void finalize() throws Throwable {
//		super.finalize();
		
		System.out.println("Person - finalize");
	}

}
