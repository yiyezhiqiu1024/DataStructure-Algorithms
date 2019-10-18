package com.zeng.union;

/**
 * Quick Find
 * @author zeng
 *
 */
public class UnionFind_QF extends UnionFind {

	public UnionFind_QF(int capacity) {
		super(capacity);
	}

	@Override
	public int find(int v) {
		rangeCheck(v);
		// 父节点就是根节点
		return parents[v];
	}

	@Override
	public void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (p1 == p2) return;
		// 将v1所在集合的所有元素，都嫁接到v2的父节点上
		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == p1) {
				parents[i] = p2;
			}
		}

	}

}
