package com.zeng.sort;

public class CountingSort extends Sort<Integer> {
	
	@Override
	protected void sort() {
		sort2();
	}
	
	/**
	 * 最简单的实现 - 改进实现
	 */
	private void sort2() {
		int max = array[0]; // 最大值
		int min = array[0]; // 最小值
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) max = array[i];
			if (array[i] < min) min = array[i];
		}
		
		// 开辟空间，存储次数
		int[] counts = new int[max - min + 1];
		// 统计元素出现的次数
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;  
		}
		// 每个次数累加上其前面所有次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		int[] newArray = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			newArray[--counts[array[i] - min]] = array[i];
		}
		// 将有序数组赋值到array
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}
	
	/**
	 * 最简单的实现
	 */
	protected void sort1() {
		int max = array[0]; // 最大值
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) max = array[i];
		}
		
		// 开辟内存空间，存储每个整数出现的次数
		int[] counts = new int[max + 1];
		// 统计每个整数出现的次数
		for (int i = 0; i < array.length; i++) {
			counts[array[i]]++;
		}
		
		// 根据整数的出现次数，对整数进行排序
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			while (counts[i]-- > 0) {
				array[index++] = i;
			}
		}
	}
	
	public static void main(String[] args) {

		Person[] persons = new Person[] {
				new Person("A", 10),
				new Person("B", -13),
				new Person("C", 17),
				new Person("D", 12),
				new Person("E", -13),
				new Person("F", 20)							
		};
		
		// 找出最大值
		int max = persons[0].age;
		// 找出最小值
		int min = persons[0].age;
		for (Person person : persons) {
			if (person.age > max) max = person.age;
			if (person.age < min) min = person.age;
		}
		// 开辟内存空间，存储次数
		int[] counts = new int[max - min + 1];
		// 统计每次出现的次数
		for (int i = 0; i < persons.length; i++) {
			counts[persons[i].age - min]++;
		}
		// 累加次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		Person[] newPersons = new Person[persons.length];
		for (int i = persons.length - 1; i >= 0; i--) {
			newPersons[--counts[persons[i].age - min]] = persons[i];
		}
		
		// 将有序数组赋值到array
		for (int i = 0; i < newPersons.length; i++) {
			persons[i] = newPersons[i];
		}
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		
	}
	
	private static class Person {
		String name;
		int age;
		
		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}
		
		
	}

}
