package com.zeng;

public interface List<E> {
	
	/**
	 * 清除所有元素
	 */
	void clear();
	
	/**
	 * 获取元素的数量
	 * @return 元素的数量
	 */
	int size();
	
	/**
	 * 是否为空
	 * @return 空或非空
	 */
	boolean isEmpty();
	
	/**
	 * 是否包含某个元素
	 * @param element 元素
	 * @return 包含或不包含
	 */
	boolean contains(E element);
	
	/**
	 * 在index位置插入一个元素
	 */
	void add(int index, E element);
	
	/**
	 * 添加元素到尾部
	 * @param element 元素
	 */
	void add(E element);
	
	/**
	 * 获取index位置的元素
	 * @param index 位置
	 * @return 元素
	 */
	E get(int index);
	
	/**
	 * 设置index位置的元素
	 * @param index 位置
	 * @param element 元素
	 * @return 设置之前的元素ֵ
	 */
	E set(int index, E element);
	
	/**
	 * 删除index位置的元素
	 * @param index 下标位置
	 * @return 返回被删除的元素
	 */
	E remove(int index);
	
	/**
	 * 查看元素的索引
	 * @param element
	 * @return 索引位置
	 */
	int indexOf(E element);
}
