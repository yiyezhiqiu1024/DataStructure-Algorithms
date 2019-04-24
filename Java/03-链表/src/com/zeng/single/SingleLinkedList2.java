package com.zeng.single;

import com.zeng.AbstractList;

/**
 * 单向链表（含虚拟头结点）
 * @author SL Zeng
 *
 * @param <E> 泛型对象
 */
public class SingleLinkedList2<E> extends AbstractList<E> {  

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
		 * 下一个节点
		 */
		Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private Node<E> first;
	
	public SingleLinkedList2() {
		first = new Node<>(null, null);
	}
	
	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		Node<E> prev = (0 == index) ? first : node(index - 1);	// 获取前一个Node
		Node<E> addNode = new Node<>(element, prev.next); 		// 初始化添加Node
		prev.next = addNode;
		
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
		
		Node<E> prev = (0 == index) ? first : node(index - 1);
		Node<E> removeNode = prev.next;
		prev.next = removeNode.next;
		
		size--;
		return removeNode.element;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first.next;
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
		
		Node<E> node = first.next;
		for (int i = 0; i < index; i++) {
			node = node.next;	
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(", [");
		Node<E> node = first.next;
		for (int i = 0; i < size; i++) {
			if (i != 0) string.append(", ");
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
	
}
