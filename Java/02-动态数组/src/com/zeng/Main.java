package com.zeng;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Tom", 18));
		list.add(new Person("Jack", 28));
		list.add(new Person("Lucy", 16));
		
		System.out.println(list.toString());
		list.clear();
	}
	
	static void test() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("Tom", 18));
		list.add(new Person("Jack", 28));
		list.add(new Person("Lucy", 16));
	
		System.out.println(list.toString());
		
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(10);
		ints.add(20);
		ints.add(30);
		System.out.println(ints.toString());
	}

}
