package com.zeng.union;

/**
 * Quick Union - 基于rank的优化 - 路径压缩（Path Compression）
 * @author zeng
 *
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {

	public UnionFind_QU_R_PC(int capacity) {
		super(capacity);
	}
	
	@Override
    public int find(int v) {
		rangeCheck(v);
		// 使路径上所有的节点都指向根节点
		if (parents[v] != v) {
			parents[v] = find(parents[v]);
		}
		return parents[v];
	}

}
