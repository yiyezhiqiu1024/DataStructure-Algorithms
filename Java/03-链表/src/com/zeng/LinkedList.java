package com.zeng;

public class LinkedList<E> extends AbstractList<E> {  
	
	private Node<E> first;
	
	private static class Node<E> {
		/**
		 * 元素
		 */
		E element;
		
		/**
		 * 下一个节点
		 */
		Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if (0 == index) {
			Node<E> addNode = new Node<>(element, first);
			first = addNode;
		} else {
			Node<E> prev = node(index - 1); // 获取前一个Node
			Node<E> addNode = new Node<>(element, prev.next); // 初始化添加Node
			prev.next = addNode;
		}
		
		size++; 
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public E remove(int index) {
		Node<E> removeNode = first;
		if (0 == index) {
			first = first.next;
		} else {
			Node<E> prev = node(index - 1);
			removeNode = prev.next;
			prev.next = removeNode.next;
		}
		size--;
		return removeNode.element;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node  = node.next;
			} 
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node  = node.next;
			}
		}
		
		return ELEMENT_NOT_FOUND;
	}

	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;	
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) string.append(", ");
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
	
}
