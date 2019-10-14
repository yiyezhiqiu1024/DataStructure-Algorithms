package com.zeng.sort.cmp;

import com.zeng.sort.Sort;

/**
 * 冒泡排序 - 优化②
 * @author zeng
 *
 * @param <T>
 */
public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(begin, begin-1) < 0) {					
					swap(begin, begin - 1);					
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}

	}

}
