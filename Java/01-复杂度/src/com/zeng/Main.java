package com.zeng;

import com.zeng.Times.Task;

public class Main {

	public static void main(String[] args) {
		
		// 通过 TimeTool 比较 两种方法的执行效率
		
		Times.test("线性代数解法", new Task() {

			@Override
			public void execute() {
				System.out.println(fib3(64));
			}
		});
		
		Times.test("非递归解法", new Task() {

			@Override
			public void execute() {
				System.out.println(fib2(64));
			}
		});
		
		Times.test("递归解法", new Task() {

			@Override
			public void execute() {
				System.out.println(fib1(35));
			}
			
		});
		
		
	}
	
	/**
	 * 斐波那契数列（递归解法）
	 * @param n 数字
	 * @return
	 */
	public static int fib1(int n) {
		
		if (n <= 1) return n;
		
		return fib1(n -2) + fib1(n - 1);
	}
	
	/**
	 * 斐波那契数列（非递归解法）
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
	
	/**
	 * 斐波那契数列（线性代数解法）
	 * @param n
	 * @return
	 */
	public static int fib3(int n) {
		double c = Math.sqrt(5);
		return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
	}

}
