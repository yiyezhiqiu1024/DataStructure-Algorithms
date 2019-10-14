package com.zeng.sort.cmp;

import com.zeng.sort.Sort;

/**
 * 冒泡排序
 * @author zeng
 *
 * @param <T>
 */
public class BubbleSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			for (int begin = 1; begin <= end; begin++) {
				// if (array[begin] < array[begin - 1]) {
				if (cmp(begin, begin - 1) < 0) {
					swap(begin, begin - 1);
				}
			}
		}
	}

}
