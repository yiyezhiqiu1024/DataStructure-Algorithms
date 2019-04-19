package com.zeng;

import com.zeng.TimeTool.Task;

public class Main {

	public static void main(String[] args) {
		
		// 通过 TimeTool 比较 两种方法的执行效率
		
		// 非递归方法
		TimeTool.check("fib2", new Task() {

			@Override
			public void execute() {
				System.out.println(fib2(64));
			}
		});
		
		// 递归方法
		TimeTool.check("fib1", new Task() {

			@Override
			public void execute() {
				System.out.println(fib1(35));
			}
			
		});
		
		
	}
	
	/**
	 * 斐波那契数列（递归结构）
	 * @param n 数字
	 * @return
	 */
	public static int fib1(int n) {
		if (n <= 1) return n;
		return fib1(n -2) + fib1(n - 1);
	}
	
	/**
	 * 斐波那契数列（非递归结构）
	 * @param n 数字
	 * @return
	 */
	public static int fib2(int n) {
		
		if (n <= 1) return n;
		
		int first = 0;
		int second = 1;
		
		for (int i = 1; i < n; i++) {
			second += first;
			first = second - first;
		}
		
		return second;
	}

}
