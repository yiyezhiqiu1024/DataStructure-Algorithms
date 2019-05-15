package com.zeng;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.zeng.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 * @author SL Zeng
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * @return 元素的数量
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return 0 == size;
	}
	
	/**
	 * 清空所有元素
	 */
	public void clear() {
		
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
		
	}

	/**
	 * @param element 元素
	 * @return 是否包含元素
	 */
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * 前序遍历
	 * @param visitor
	 */
	public void preorder(Visitor<E> visitor) {
		preorder(root, visitor);
	}

	private void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null) return;
		
		visitor.visitor(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}
	
	/**
	 * 中序遍历
	 * @param visitor
	 */
	public void inorder(Visitor<E> visitor) {
		inorder(root, visitor);
	}
	
	private void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null) return;
		inorder(node.left, visitor);
		visitor.visitor(node.element);
		inorder(node.right, visitor);
	}
	
	/**
	 * 后序遍历
	 * @param visitor
	 */
	public void postorder(Visitor<E> visitor) {
		postorder(root, visitor);
	}

	private void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null) return;
		
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		visitor.visitor(node.element);
	}
	
	/**
	 * 层序遍历
	 * @param visitor
	 */
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
		 	Node<E> node = queue.poll();
			visitor.visitor(node.element);
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public boolean isComplete() {
		
		return false;
	}
	
	/**
	 * 计算二叉树的高度（迭代）
	 */
	public int height() {
		if (root == null) return 0;
		// 数的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			if (0 == levelSize) {
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}
	
	/**
	 * 计算二叉树的高度（递归）
	 */
	public int height2() {
		return height(root);
	}
	
	/**
	 * 计算二叉树的高度（递归）
	 * @param node
	 * @return 二叉树的高度
	 */
	public int height(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
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

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<E>)node).element;
	}
	
	public static interface Visitor<E> {
		void visitor(E element);
	}

	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		@SuppressWarnings("unused")
		Node<E> parent;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
	}
}
