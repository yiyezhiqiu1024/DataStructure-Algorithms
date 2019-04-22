package com.zeng;

public class Main {

	public static void main(String[] args) {
//		testArrayList();
		testLinkedList();
	}
	
	public static void testLinkedList() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(0, 9);
		list.add(list.size(), 11);
		list.add(null);
		
		list.set(1, 99);
		System.out.println(list.toString());
		System.out.println(list.get(0));
		
		list.remove(1);
		System.out.println(list.toString());
		 
		System.out.println(list.contains(null));
	}
	
	public static void testArrayList() {
		ArrayList<Person> PersonList = new ArrayList<>();
		
		Person tom = new Person("Tom", "001", 18);
		Person lucy = new Person("Lucy", "002", 17);
		Person jack = new Person("Jack", "003", 19);
		PersonList.add(tom);
		PersonList.add(lucy);
		PersonList.add(jack);
//		System.out.println(printPersonList);
//		Person lily = new Person("Lily", "004", 17);
//		PersonList.set(0, lily); 
//		System.out.println(PersonList.get(0));
//		System.out.println(PersonList.contains(new Person("Lily", "004", 17)));
//		
//		System.out.println(PersonList.indexOf(jack));
		
		Person lily = new Person("Lily", "004", 17);
		PersonList.add(0, lily);
		System.out.println(PersonList.toString());
		
		PersonList.remove(PersonList.size() - 1);
		System.out.println(PersonList.toString());
	}

}
