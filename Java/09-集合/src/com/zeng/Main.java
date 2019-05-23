package com.zeng;

import com.zeng.file.FileInfo;
import com.zeng.file.Files;
import com.zeng.set.ListSet;
import com.zeng.set.Set;
import com.zeng.set.Set.Vistor;
import com.zeng.set.TreeSet;
import com.zeng.util.Times;
import com.zeng.util.Times.Task;

public class Main {
	
	static void test1() {
		Set<Integer> listSet = new ListSet<>();
		listSet.add(12);
		listSet.add(10);
		listSet.add(11);
		listSet.add(11);	
		listSet.add(12);
		listSet.add(10);
		
		listSet.traversal(new Vistor<Integer>() {
			
			@Override
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return false;
			}
		});
		System.out.println();
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(12);
		treeSet.add(10);
		treeSet.add(7);
		treeSet.add(11);
		treeSet.add(10);
		treeSet.add(11);
		treeSet.add(9);
		
		treeSet.traversal(new Vistor<Integer>() {
			
			@Override
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return false;
			}
		});
	}
	
	static void testSet(Set<String> set, String[] words) {
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		
		for (int i = 0; i < words.length; i++) {
			set.contains(words[i]);
		}
		
		for (int i = 0; i < words.length; i++) {
			set.remove(words[i]);
		}
	}
	
	static void test2() {
		FileInfo info = Files.read("09-集合", new String[]{"java"});
		
		System.out.println("文件数量：" + info.getFiles());
		System.out.println("代码行数：" + info.getLines());
		String[] words = info.words();
		System.out.println("单词数量：" + words.length);
		
//		Times.test("ListSet", new Task() {
//			@Override
//			public void execute() {
//				testSet(new ListSet<>(), words);
//			}
//		});	
		
		Times.test("TreeSet", new Task() {
			@Override
			public void execute() {
				testSet(new TreeSet<>(), words);
			}
		});	
		
	}

	public static void main(String[] args) {
//		test1();
		test2();
	}

}
