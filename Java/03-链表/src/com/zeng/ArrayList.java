package com.zeng;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {
	
	/**
	 * 默认容量
	 */
	private static final int DEFAULT_CAPACITY = 2;
	
	/**
	 * 所有元素
	 */
	private E[] elements;
	
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		
		elements[index] = element;
		size++;
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E oldElement = elements[index];
		for (int i = index; i < size; i++) {
			elements[i] = elements[i + 1];
		}
		
		elements[--size] = null;
		return oldElement;
	}

	@Override
	public int indexOf(Object element) {
		
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(" [");
		for (int i = 0; i < size; i++) {
			if (i != 0) string.append(", ");
			string.append(elements[i]);
		}
		
		string.append("]");
		
		return string.toString();
	}
	
	/**
	 * 扩容方法
	 * @param capacity 当前容量
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity > capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i ++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
		
		System.out.println(capacity + "扩容" + newCapacity);
	}

}
