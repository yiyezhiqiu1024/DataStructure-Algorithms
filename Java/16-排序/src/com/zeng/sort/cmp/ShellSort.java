package com.zeng.sort.cmp;

import java.util.ArrayList;
import java.util.List;

import com.zeng.sort.Sort;

/**
 * 希尔排序
 * @author zeng
 *
 * @param <T>
 */
@SuppressWarnings("unused")
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
//		List<Integer> stepSequence = shellStepSequence(array.length);
		List<Integer> stepSequence = sedgewickStepSequence(array.length);

		for (int step: stepSequence) {
			sort(step);
		}
	}
	
	private void sort(int step) {
		for (int col = 0; col < step; col++) {
			for (int begin = col + step; begin < array.length; begin += step) {
				int cur = begin;
				while (cur > col && cmp(cur, cur - step) < 0) {
					swap(cur, cur - step);
					cur -= step;
				}
			}
		}
	}
	
	private List<Integer> shellStepSequence(int count) {
		List<Integer> stepSequence  = new ArrayList<>();
		int step = count;
		while ((step >>= 1) > 0) {
			stepSequence.add(step);
		}
		return stepSequence;
	}
	
	private List<Integer> sedgewickStepSequence(int count) {
		List<Integer> stepSequence = new ArrayList<>();
		int k = 0, step = 0;
		while (true) {
			if (k % 2 == 0) {
				int pow = (int) Math.pow(2, k >> 1);
				step = 1 + 9 * (pow * pow - pow);
			} else {
				int pow1 = (int) Math.pow(2, (k - 1) >> 1);
				int pow2 = (int) Math.pow(2, (k + 1) >> 1);
				step = 1 + 8 * pow1 * pow2 - 5 * pow2;
			}
			if (step >= count) break;
			stepSequence.add(0, step);
			k++;
		}
		
		return stepSequence;
	}

}
