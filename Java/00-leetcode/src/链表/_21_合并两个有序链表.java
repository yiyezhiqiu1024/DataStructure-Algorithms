package 链表;

import java.util.LinkedList;

/*
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @author SL Zeng
 */
public class _21_合并两个有序链表 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode result = mergeTwoLists(l1, l2);
		System.out.println(result.val);	
		System.out.println(result.next.val);	
		System.out.println(result.next.next.val);	
		System.out.println(result.next.next.next.val);	
		System.out.println(result.next.next.next.next.val);	
		System.out.println(result.next.next.next.next.next.val);	
	}
	
	// 只要是用到递归，首先要搞清楚一个问题：这个递归函数的功能是什么？
	// 递归基：边界
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
	}
	
	// 迭代2（虚拟头节点）
	private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		// 虚拟头点（dummy head）
		ListNode head = new ListNode(0);
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
	
	// 迭代1
	private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode head;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		
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
		} else if (l2 == null){
			cur.next = l1;
		}
		
		return head;
	}

}
