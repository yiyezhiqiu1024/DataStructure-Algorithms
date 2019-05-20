package com.zeng.printer;

public interface BinaryTreeInfo {

	/**
	 * 谁是根节点
	 */
	Object root();
	
	/**
	 * @param node 节点
	 * @return 获取节点的左子节点
	 */
	Object left(Object node);
	
	/**
	 * @param node 节点
	 * @return 获取节点的右子节点
	 */
	Object right(Object node);
	
	/**
	 * @param node 节点
	 * @return 打印节点
	 */
	Object string(Object node);
	
}
