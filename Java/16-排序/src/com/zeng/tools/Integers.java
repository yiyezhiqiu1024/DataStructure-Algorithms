package com.zeng.tools;

import java.util.Arrays;

public class Integers {
	
	public static Integer[] ramdom(int count, int min, int max) {		
		if (count <= 0 || min > max) return null;
		Integer[] array = new Integer[count];
		int delta = max - min + 1;
		for (int i = 0; i < count; i++) {
			array[i] = min + (int)(Math.random() * delta);
		}
		return array;
	}
	
	public static Integer[] copy(Integer[] array) {
		return Arrays.copyOf(array, array.length);
	}
	
	public static Integer[] ascOrder(int min, int max) {
		if (min > max) return null;
		Integer[] array = new Integer[max - min + 1];
		for (int i = 0; i < max; i++) {
			array[i] = min++;
		}
		return array;
	}
	
	public static void println(Integer[] array) {
		if (array == null || 0 == array.length) return;
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) string.append("_");
			string.append(array[i]);
		}
		System.out.println(string);
	}

}
