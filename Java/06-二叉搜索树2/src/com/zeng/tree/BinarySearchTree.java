package com.zeng.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.zeng.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 * @author SL Zeng
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> extends BinaryTree<E> {
	
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	
	/**
	 * 添加元素
	 * @param element 元素
	 */
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parent = null;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 相等
				return;
			}
		} 
		
		// 看看插入到父节点的哪个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else if (cmp < 0) {
			parent.left = newNode;
		}
		
		size++;
	}

	/**
	 * 删除元素 元素
	 * @param element
	 */
	public void remove(E element) {
		remove(node(element));
	}

	private void remove(Node<E> node) {
		if (node == null) return;
		
		size--;
		 
		if (node.hasTowChildren()) { // 度为2的节点
			// 找到后继节点
			Node<E> s = successor(node);
			// 用后继节点的值覆盖度为2的节点的值
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		
		// 删除node节点（node的度必然是1或者0）
		Node<E> replacement = node.left != null ? node.left : node.right;
		
		if (replacement != null) { // 度为1的节点
			// 更改parent
			replacement.parent = node.parent;
			// 更改parent的left、right的指向
			if (node.parent == null) { // node是度为1的节点并且是根节点
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else { // node == node.parent.right
				node.parent.right = replacement;
			}
		} else if (node.parent == null) { // node是叶子节点并且是根节点
			root = null;
		} else { // node是叶子节点，但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else { // node == node.parent.right
				node.parent.right = null;
			}
		}
	}

	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (0 == cmp) return node;
			if (cmp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}

	/**
	 * @param element 元素
	 * @return 是否包含元素
	 */
	public boolean contains(E element) {
		return false;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		toString(root, sb, "");
		return sb.toString();
	}

	private void toString(Node<E> node, StringBuilder sb, String prefix) {
		if (node == null) return;
		
		sb.append(prefix).append("「").append(node.element).append("」").append("\n");
		toString(node.left, sb, prefix + "『L』");
		toString(node.right, sb, prefix + "『R』");
	}

	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		} 
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
}
