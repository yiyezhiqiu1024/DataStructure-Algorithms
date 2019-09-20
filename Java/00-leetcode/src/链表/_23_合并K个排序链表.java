package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _23_合并K个排序链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路5 - 分治策略，O(nlogk)
	 */
    public ListNode mergeKLists5(ListNode[] lists) {
    	if (lists == null || 0 == lists.length) return null;
    	
    	int step = 1;
    	while (step < lists.length) {
    		int nextStep = step << 1;
    		for (int i = 0; i + step < lists.length; i += nextStep) {
        		lists[i] = mergeTwoLists(lists[i], lists[i + step]);
        	}
        	step = nextStep;
    	}
    	
    	return lists[0];
    }
	
	/**
	 * 思路4 - 优先级队列（小顶堆），O(nlogk)，空间复杂度：O(k)
	 */
	public ListNode mergeKLists4(ListNode[] lists) {
		if (lists == null || 0 == lists.length) return null;
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		// 将所有链表的头节点添加到小顶堆（优先级队列）中
		PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode l1, ListNode l2) -> {
			return l1.val - l2.val;
		}); // klogk
		
		for (ListNode list : lists) {
			if (list == null) continue;
			queue.offer(list);
		}
		
		// 不断删除堆顶元素，并且吧堆顶元素的next添加到堆中
		while (!queue.isEmpty()) {
			ListNode list = queue.poll();
			cur = cur.next = list;
			if (list.next != null) {
				queue.offer(list.next);
			}
		} // nlogk
		
		return head.next;
	}
	
	/**
	 * 思路3 - 逐一两两合并，O(kn)
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
		if (lists == null || 0 == lists.length) return null;
		
		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0], lists[i]);
		}
		
		return lists[0];
	}
	
	private ListNode head = new ListNode(0);
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur = cur.next = l1;
				l1 = l1.next;
			} else {
				cur = cur.next = l2;
				l2 = l2.next;
			}
		}
		
		if (l1 == null) {
			cur.next = l2;
		} else if (l2 == null) {
			cur.next = l1;
		}
		
		return head.next;
	}
	
	/**
	 * 思路2 - 逐一比较，O(kn)
	 */
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || 0 == lists.length) return null;
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		while (true) {
			// 最小链表所在的索引
			int minIndex = -1;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) continue;
				
				if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
					minIndex = i;
				} 
			} // O(k)
			// 所有链表节点已经串起来了
			if (minIndex == -1) break;
			
			cur = cur.next = lists[minIndex];
			lists[minIndex] = lists[minIndex].next;
		} // O(kn)
		
		return head.next;
	}
	
	/**
	 * 思路1 - 最笨的解法
	 * 将所有节点添加到一个数组中
	 * 对数组中的节点从小到大进行排序
	 * 从数组中从小到大一次取出节点，串成链表
	 */
	public ListNode mergeKLists1(ListNode[] lists) {
		if (lists == null || 0 == lists.length) return null;
		
		List<ListNode> newLists = new ArrayList<>();
		// 将所有的节点添加到新的数组
		for (ListNode list: lists) {
			while (list != null ) {
				newLists.add(list);
				list = list.next;
			}
		} // O(n)
		
		// 对数组进行排序（基于比较的排序，时间复杂度目前最好是O(nlogn)，n是所有节点的数量）
		newLists.sort((ListNode l1, ListNode l2) -> {
			return l1.val - l2.val;
		});
		
		// 创建一个虚拟头节点
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		for (ListNode list : newLists) {
			cur = cur.next = list;
		} // O(n)
		
		return head.next;
	}

}
