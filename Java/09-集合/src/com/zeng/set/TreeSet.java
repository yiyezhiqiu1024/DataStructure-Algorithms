package com.zeng.set;

import java.util.Comparator;

import com.zeng.tree.BinaryTree;
import com.zeng.tree.RBTree;

public class TreeSet<E> implements Set<E> {
	private RBTree<E> tree;
	
	public TreeSet() {
		this(null);
	}

	public TreeSet(Comparator<E> comparator) {
		tree =  new RBTree<>();
	}
	
	@Override
	public int size() {
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public void clean() {
		tree.clear();
	}

	@Override
	public boolean contains(E element) {
		return tree.contains(element);
	}

	@Override
	public void add(E element) {
		tree.add(element);
	}

	@Override
	public void remove(E element) {
		tree.remove(element);
	}

	@Override
	public void traversal(Vistor<E> visitor) {
		tree.inorder(new BinaryTree.Visitor<E>() {

			@Override
			public boolean visit(E element) {
				return visitor.visit(element);
			}
			
		});
		
	}

}
