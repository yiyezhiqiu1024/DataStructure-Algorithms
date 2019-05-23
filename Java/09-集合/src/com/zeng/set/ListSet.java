package com.zeng.set;

import com.zeng.list.LinkedList;
import com.zeng.list.List;

public class ListSet<E> implements Set<E> {
	
	private List<E> list = new LinkedList<>();

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clean() {
		list.clear();
	}

	@Override
	public boolean contains(E element) {
		return list.contains(element);
	}

	@Override
	public void add(E element) {
		int index = list.indexOf(element);
		if (index != List.ELEMENT_NOT_FOUND) { // 存在就覆盖
			list.set(index, element);
		} else { // 不存在就添加
			list.add(element);
		}
	}

	@Override
	public void remove(E element) {
		int index = list.indexOf(element);
		if (index != List.ELEMENT_NOT_FOUND) {
			list.remove(index);
		}
	}

	@Override
	public void traversal(Vistor<E> visitor) {
		if (visitor == null) return;
		
		for (int i = 0; i < list.size(); i++) {
			if (visitor.visit(list.get(i))) return;
		}
	}

}
