package com.zeng;

@SuppressWarnings("unchecked")
public class ArrayList<E> {
	/**
	 * 元素的数量
	 */
	private int size;
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public ArrayList(int capaticy) {
		
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
		
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		// 清除内存
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		
		size = 0;
		System.gc();
	}

	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 在index位置插入一个元素
	 */
	public void add(int index, E element) {
		
		rangeCheckForAdd(index);
		
		ensureCapacity(size + 1);
		
		for (int i = size; i > index; i --) {
			elements[i] = elements[i - 1];
		}
		
		elements[index] = element;
		size++;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) {
		
		rangeCheck(index);
		
		E old = elements[index];
		elements[index] = element;
		return old;
	}


	/**
	 * 删除index位置的元素
	 * @param index 下标位置
	 * @return 返回被删除的元素
	 */
	public E remove(int index) {
		
		rangeCheck(index);
		
		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		
		// 清空最后一个元素
		elements[--size] = null;
		return old;
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		
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
		string.append("size = ").append(size).append(", [");
		
		for (int i = 0; i < size; i++) {
			
			if (i != 0) string.append(", ");
			
			string.append(elements[i]);
		}
		
		string.append("]");
		
		return string.toString();
	}

	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size" + size);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) outOfBounds(index);
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) outOfBounds(index);
	}
	
	private void ensureCapacity(int capacity) {

		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
			
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
	}
	
}
