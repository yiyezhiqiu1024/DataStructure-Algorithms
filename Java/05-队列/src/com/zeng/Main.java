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

	public static void main(String[] args) {
//		testQueue();
		testDeque();
	}

}
