package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author SL Zeng
 *
 */
public class _206_反转链表 {
  
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // 使用递归方式
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    
    
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // 使用迭代方式
        ListNode newHead = null;
    	while (head.next != null) {
    		ListNode tmp = head.next;
    		head.next = newHead;
    		newHead = head;
    		head = tmp;
    		
    	}
    	return newHead;
    }
}
