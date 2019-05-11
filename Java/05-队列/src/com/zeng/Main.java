package com.zeng;

public class Main {
	
	static void testQueue() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}

	public static void main(String[] args) {
		testQueue();

	}

}
