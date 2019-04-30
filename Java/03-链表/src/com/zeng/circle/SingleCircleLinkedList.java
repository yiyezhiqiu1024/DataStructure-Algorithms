package com.zeng.circle;

import com.zeng.AbstractList;

/**
 * 单向循环链表
 * @author SL Zeng
 *
 */
/**
 * @author zeng
 *
 * @param <E>
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {

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

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(element).append("_").append(next.element);
			return sb.toString();
		}
	}
	
	private Node<E> first;

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
			Node<E> lastNode = (0 == size) ? addNode : node(size - 1); // 拿到最后一个节点
			lastNode.next = addNode;
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
		rangeCheck(index);
		
		Node<E> removeNode = first;
		if (0 == index) { // 删除首个node
			
			if (size == 1 ) { // 只有1个node
				first = null;
			} else {
				Node<E> lastNode = node(size - 1);
				first = first.next;
				lastNode.next = first;
			}
			
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

	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
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
