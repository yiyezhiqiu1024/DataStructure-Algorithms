package com.zeng.circle;

/**
 * 循环双端队列
 * @author SL Zeng
 */
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public CircleDeque() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return 0 == size;
	}
	
	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		ensureCapacity(size + 1);
		
		elements[index(size)] = element;
		size++;
	}
	
	/**
	 * 从队尾出队
	 * @return
	 */
	public E deQueueRear() {
		int rearIndex = index(size - 1);
		E rearElement = elements[rearIndex];
		elements[rearIndex] = null;
		size--;
		return rearElement;
	}
	
	/**
	 * 从队头入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		ensureCapacity(size + 1);
		
		front = index(-1);
		elements[front] = element;
		size++;
	}
	
	/**
	 * 从队头出队
	 * @return
	 */
	public E deQueueFront() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	/**
	 * 获取队头元素
	 */
	public E front() {
		return elements[front];
	}
	
	/**
	 * 获取队尾元素
	 */
	public E rear() {
		return elements[index(size - 1)];
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}

	private int index(int index) {
		index += front;
		if (index < 0) {
			return index + elements.length;
		}
		return index - (index >= elements.length ? elements.length : 0);
	}

	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < oldCapacity; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		front = 0;
	}

}
