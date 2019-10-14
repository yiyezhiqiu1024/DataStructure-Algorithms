package com.zeng.sort;

import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	

	public static void main(String[] agrs) {
		BucketSort.sort();
	}
	
	static void sort() {

		double[] array = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.76};
		
		List<Double>[] buckets = new List[array.length];
		for (int i = 0; i < array.length; i++) {
			// 元素在桶中的索引：元素值 * 元素数量
			int bucketIndex = (int) (array[i] * array.length);
			List<Double> bucket = buckets[bucketIndex];
			if (bucket == null) {
				bucket = new LinkedList<>();
				buckets[bucketIndex] = bucket;
			}
			bucket.add(array[i]);
		}
		
		// 将所有非空桶的元素合并成有序序列
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) continue;
			buckets[i].sort(null);
			for (Double d : buckets[i]) {
				array[index++] = d;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	
}
