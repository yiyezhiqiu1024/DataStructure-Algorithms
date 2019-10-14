package com.zeng;

import java.util.Arrays;


import com.zeng.sort.Sort;
import com.zeng.sort.cmp.BubbleSort1;
import com.zeng.sort.cmp.BubbleSort2;
import com.zeng.sort.cmp.BubbleSort3;
import com.zeng.sort.cmp.SelectionSort;
import com.zeng.sort.cmp.ShellSort;
import com.zeng.sort.cmp.HeapSort;
import com.zeng.sort.cmp.InsertionSort1;
import com.zeng.sort.cmp.InsertionSort2;
import com.zeng.sort.cmp.InsertionSort3;
import com.zeng.sort.cmp.MergeSort;
import com.zeng.sort.cmp.QuickSort;
import com.zeng.sort.CountingSort;
import com.zeng.sort.RadixSort;
import com.zeng.tools.Asserts;
import com.zeng.tools.Integers;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Main {
	public static void main(String[] args) {
		test1();
//		test2();
		
	}
	
	static void test1() {
		Integer[] array = Integers.ramdom(30000, 1, 20000);
		testSorts(array,
//				new BubbleSort1(),
//				new BubbleSort2(),
//				new BubbleSort3(),
//				new SelectionSort(),
//				new HeapSort(),
//				new InsertionSort1(),
//				new InsertionSort2(),
//				new InsertionSort3(),
				new MergeSort(),
				new QuickSort(),
				new ShellSort(),
				new CountingSort(),
				new RadixSort()
				);							
	}
	

	private static void test2() {
		int[] array = {2, 4, 8, 8, 8, 12, 14};
		Asserts.test(BinarySearch.search(array, 5) == 2);
		Asserts.test(BinarySearch.search(array, 1) == 0);
		Asserts.test(BinarySearch.search(array, 15) == 7);
		Asserts.test(BinarySearch.search(array, 8) == 5);
		
	}

	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort: sorts) {
			sort.sort(Integers.copy(array));
		}
		
		Arrays.sort(sorts);
		
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
		
	}

	/*
	static void bubbleSort1(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = tmp;
				}
			}
		}
	}
	
	static void bubbleSort2(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			boolean stored = true;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = tmp;
					stored = false;
				}				
			}
			
			if (stored) break;
		}
	}
	
	static void bubbleSort3(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = tmp;
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}
	
	static void selectionSort(Integer[] array) {		
		for (int end = array.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int begin = 1; begin < array.length; begin++) {
				if (array[maxIndex] > array[begin]) {
					maxIndex = begin;
				}			
			}
			int tmp = array[maxIndex];
			array[maxIndex] = array[end];
			array[end] = tmp;
		}
		
	}
	*/

}
