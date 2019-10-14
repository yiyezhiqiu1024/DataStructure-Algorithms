package com.zeng.sort.cmp;

import com.zeng.sort.Sort;

/**
 * 快速排序
 * @author zeng
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		sort(0, array.length);
	}
	
	private void sort(int begin, int end) {
		// 至少要要有2个元素
		if (end - begin < 2) return;
		
		int middle = pivotIndex(begin, end);
		sort(begin, middle);
		sort(middle + 1, end);
	}

	private int pivotIndex(int begin, int end) {
		// 随机交换begin位置的元素
		swap(begin, begin + (int)(Math.random() * (end - begin)));
		T pivot = array[begin];
		end--; // end指向最后一个元素
		while (begin < end) {
			while (begin < end) {
				if (cmp(pivot, array[end]) < 0) {
					end--;
				} else {
					array[begin++] = array[end];
					break;
				}
			}
			
			while (begin < end) {
				if (cmp(pivot, array[begin]) > 0) {
					begin++;
				} else {
					array[end--] = array[begin];
					break;
				}
			}
		}
		array[begin] = pivot;
		return begin;
	}

}
