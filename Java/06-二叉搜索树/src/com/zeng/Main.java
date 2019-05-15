package com.zeng;

import java.util.Comparator;

import com.zeng.BinarySearchTree.Visitor;
import com.zeng.printer.BinaryTreeInfo;
import com.zeng.printer.BinaryTrees;

public class Main {
	
	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
	}
	
	static void test2() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}
		
		BinaryTrees.println(bst1);
		
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}
		BinaryTrees.println(bst2);
	}
	
	static void test3() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 30; i++) {
			bst.add((int)(Math.random() * 1000));
		}
		
		BinaryTrees.println(bst);
	}
	
	static void test4() {
		BinaryTrees.println(new BinaryTreeInfo() {

			@Override
			public Object root() {
				return "A";
			}

			@Override
			public Object left(Object node) {
				if (node.equals("A")) return "B";
				if (node.equals("C")) return "D";
				return null;
			}

			@Override
			public Object right(Object node) {
				if (node.equals("A")) return "C";
				if (node.equals("C")) return "E";
				return null;
			}

			@Override
			public Object string(Object node) {
				return node.toString() + "_";
			}
			
		});
		
	}
	
	static void test5() {
		BinarySearchTree<Person> bst = new BinarySearchTree<Person>();
		bst.add(new Person(10, "jack"));
		bst.add(new Person(12, "jim"));		
		bst.add(new Person(6, "rose"));
		
		bst.add(new Person(10, "michael"));
		
		BinaryTrees.println(bst);
	}
	
	static void test6() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		System.out.println(bst);
		
		bst.preorder(new Visitor<Integer>() {

			@Override
			public void visitor(Integer element) {
				System.out.print(element + " ");
			}
		});
		System.out.println("前序遍历");
		
		bst.inorder(new Visitor<Integer>() {

			@Override
			public void visitor(Integer element) {
				System.out.print(element + " ");
			}
		});

		System.out.println("中序遍历");
		bst.postorder(new Visitor<Integer>() {

			@Override
			public void visitor(Integer element) {
				System.out.print(element + " ");
			}
		});

		System.out.println("后序遍历");
		
		bst.levelOrder(new Visitor<Integer>() {

			@Override
			public void visitor(Integer element) {
				System.out.print(element + " ");
			}
		});
		System.out.println("层序遍历");
	}
	

	public static void main(String[] args) {

//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();
	}

}
