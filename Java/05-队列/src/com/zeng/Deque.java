package com.zeng;

import com.zeng.List.LinkedList;
import com.zeng.List.List;

/**
 * 双端队列类
 * @author SL Zeng
 */
public class Deque<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		list.add(element);
	}
	
	/**
	 * 从队尾出队
	 */
	public E deQueueRear() {
		return list.remove(list.size() - 1);
	}
	
	/**
	 * 从队头入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		list.add(0, element);
	}
	
	/**
	 * 从队头出队
	 */
	public E deQueueFront() {
		return list.remove(0);
	}
	
	/**
	 * 获取队头元素
	 */
	public E front() {
		return list.get(0);
	}
	
	/**
	 * 获取队尾元素
	 */
	public E rear()	{
		return list.get(list.size() - 1);
	}
}
