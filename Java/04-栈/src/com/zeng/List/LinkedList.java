package com.zeng.List;

import com.zeng.List.AbstractList;

/**
 * 单向链表
 * @author SL Zeng
 *
 * @param <E> 泛型对象
 */
public class LinkedList<E> extends AbstractList<E> {  
	
	/**
	 * 内部节点对象类
	 * @author SL Zeng
	 *
	 * @param <E> 泛型对象
	 */
	private static class Node<E> {
		/**
		 * 元素
		 */
		E element;
		
		/**
		 * 上一个节点
		 */
		Node<E> prev;
		
		/**
		 * 下一个节点
		 */
		Node<E> next;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev =  prev;
			this.element = element;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");
			
			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null"); 
			}
			
			return sb.toString();
		}
	}
	
	private Node<E> first;
	private Node<E> last;

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if (index == size) { // 往最后面添加元素
			
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, null);
			if (oldLast == null) { // 这是链表添加的第一个元素	
				first = last;
			} else {
				oldLast.next = last;
			}
			
		} else {
			
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> addNode = new Node<>(prev, element, next); // 初始化添加Node
			next.prev = addNode;
			
			if (prev == null) { // index == 0
				first = addNode;
			} else {
				prev.next = addNode;
			}
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
		rangeCheck(index);
		
		Node<E> removeNode = node(index);
		Node<E> prev = removeNode.prev;
		Node<E> next = removeNode.next;
		
		if (prev == null) { // index == 0
			first = next;
		} else {
			prev.next = next;
		}
		
		if (next == null) { // index == size - 1
			last = prev;
		} else {
			next.prev = prev;
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
		
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;	
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;	
			}
			return node;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("size = ").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) sb.append(", ");
			
			sb.append(node);
			
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
