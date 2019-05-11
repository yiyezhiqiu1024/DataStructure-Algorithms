package com.zeng;

import com.zeng.circle.CircleDeque;
import com.zeng.circle.CircleQueue;

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
	
	static void testDeque() {
		Deque<Integer> deque = new Deque<>();
		deque.enQueueRear(33);
		deque.enQueueRear(44);
		deque.enQueueFront(22);
		deque.enQueueFront(11);
		
		System.out.println(deque.front()); // 11
		System.out.println(deque.rear());  // 44
		
		while (!deque.isEmpty()) {
			System.out.println(deque.deQueueRear());
		}
	}
	
	static void testCircleQueue() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		
		System.out.println(queue); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		
		System.out.println(queue); // [null, null, null, null, null, 5, 6, 7, 8, 9]
		
		// 15, 16, 17, 18, 19, 5, 6, 7, 8, 9
		for (int i = 15; i < 20; i++) {
			queue.enQueue(i);
		}
		
		System.out.println(queue); // [15, 16, 17, 18, 19, 5, 6, 7, 8, 9]
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		
		System.out.println(queue);
	}
	
	static void testCircleDeque() {
		CircleDeque<Integer> queue = new CircleDeque<>();
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i);
//			queue.enQueueRear(i + 100);
		}
//		System.out.println(queue);
		
		
		for (int i = 0; i < 3; i++) {
//			queue.deQueueFront();
			queue.deQueueRear();
		}
//		System.out.println(queue);
		
		queue.enQueueFront(11);
		queue.enQueueFront(22);
//		System.out.println(queue);
		
		while(!queue.isEmpty()) {
//			System.out.println(queue.deQueueFront());
			System.out.println(queue.deQueueRear());
		}
	}

	public static void main(String[] args) {
//		testQueue();
//		testDeque();
//		testCircleQueue();
		testCircleDeque();
	}

}
