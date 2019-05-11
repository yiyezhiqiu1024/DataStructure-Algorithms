package com.zeng;

import com.zeng.List.LinkedList;
import com.zeng.List.List;

/**
 * 队列类
 * @author SL Zeng
 */
public class Queue<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void enQueue(E element) {
		list.add(element);
	}
	
	public E deQueue() {
		return list.remove(0);
	}
	
	public E front() {
		return list.get(0);
	}
}
