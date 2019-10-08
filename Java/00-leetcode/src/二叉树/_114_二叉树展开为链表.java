package 二叉树;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @author zeng
 *
 */
public class _114_二叉树展开为链表 {
	
	/**
	 * 思路1 - 前序遍历 - 递归实现
	 */
	public void flatten1(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) {
			// 保留之前的right
			TreeNode oldRight = root.right;
			// 将left嫁接到right
			root.right = root.left;
			// 清空left
			root.left = null;
			// 将旧的right嫁接到root的最右下角
			TreeNode rightMost = root;
			while (rightMost.right != null) {
				rightMost = rightMost.right;
			}
			rightMost.right = oldRight;			
		} 
		flatten1(root.right);
	}
	
	/**
	 * 思路1 - 前序遍历 - 非递归实现
	 */
	public void flatten2(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				// 保留之前的right
				TreeNode oldRight = root.right;
				// 将left嫁接到right
				root.right = root.left;
				// 清空left
				root.left = null;
				// 将旧的right嫁接到root的最右下角
				TreeNode rightMost = root;
				while (rightMost.right != null) {
					rightMost = rightMost.right;
				}
				rightMost.right = oldRight;
			}
			root = root.right;
		}		
	}
	
	/**
	 * 思路2 - 后序遍历
	 */
	private TreeNode prev;
	public void flatten3(TreeNode root) { 
		if (root == null) return;
		
		flatten3(root.right);
		flatten3(root.left);
		if (prev != null) {
			root.right = prev;
			root.left = null;
		}
		prev = root;
	}
}
