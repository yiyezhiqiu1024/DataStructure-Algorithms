package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author SLZeng
 *
 */
public class _237_删除链表中的节点 {
	
	public void deleteNode(ListNode node) {
		// 解题思路：原地删除链表节点，使用该节点下一个值代替当前节点的值，然后删除下一个节点，即替换。
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
