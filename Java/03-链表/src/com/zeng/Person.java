package com.zeng;

public class Person {
	
	private String name;
	private String id;
	private int age;
	
	public Person(String name, String id, int i) {
		this.name = name;
		this.id = id;
		this.age = i;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.name == p.name && this.age == p.age && this.id == p.id;
		}
		
		return false;
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Person - finalize");
	}

}
