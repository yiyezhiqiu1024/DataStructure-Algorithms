package com.zeng.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.zeng.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo {
	
	protected int size;
	protected Node<E> root;
	
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
		root = null;
		size = 0;
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
	
	/**
	 * @return 计算一个树是否为完全二叉树
	 */
	public boolean isComplete() {
		if (root == null) return false;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;
			
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) { // node.left == null && node.right != null
				return false;
			} 

			if (node.right != null) { // node.left != null && node.right != null
				queue.offer(node.right);
			} else { // 后面遍历的节点都必须是叶子节点
				leaf = true;
			}
		}
		
		return leaf;
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
	
	/**
	 * @param node
	 * @return 前驱节点
	 */
	protected Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		
		// 前驱节点在左子树当中（left.right.right.right...）
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		
		// node.parent == null
		// node == node.parent.right
		return node.parent;
	}
	
	protected Node<E> successor(Node<E> node) {
		if (node == null) return null;
		// 后继节点在左子树当中（right.left.left.left...）
		Node<E> s = node.right;
		if (s != null) {
			while (s.left != null) {
				s = s.left;
			}
			return s;
		}
		
		// 从父节点、祖父节点中寻找后继节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		
		return node.parent;
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
		Node<E> myNode = (Node<E>) node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
	
	public static interface Visitor<E> {
		void visitor(E element);
	}
	
	@SuppressWarnings("unused")
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		} 
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTowChildren() {
			return left != null && right != null;
		}
	}

}
