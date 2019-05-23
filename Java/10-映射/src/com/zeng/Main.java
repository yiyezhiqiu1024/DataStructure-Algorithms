package com.zeng;

import com.zeng.file.FileInfo;
import com.zeng.file.Files;
import com.zeng.map.Map;
import com.zeng.map.Map.Visitor;
import com.zeng.map.TreeMap;
import com.zeng.set.Set;
import com.zeng.set.Set.Vistor;
import com.zeng.set.TreeSet;

public class Main {
	
	static void test1() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("c", 2);
		map.put("a", 5);
		map.put("b", 6);
		map.put("a", 8);
		
		map.traversal(new Visitor<String, Integer>() {

			@Override
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
			
		});
		
	}
	
	static void test2() {
		FileInfo fileInfo = Files.read("/10-映射", 
				new String[]{"java"});
		
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			Integer count = map.get(words[i]);
			count = (count == null) ? 1 : (count + 1);
			map.put(words[i], count);
		}
		
		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void test3() {
		Set<String> set = new TreeSet<>();
		set.add("c");
		set.add("b");
		set.add("c");
		set.add("c");
		set.add("a");
		
		set.traversal(new Vistor<String>() {
			public boolean visit(String element) {
				System.out.println(element);
				return false;
			}
		});
	}

	public static void main(String[] args) {
//		test1();
//		test2();
		test3();

	}

}
