package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author SL Zeng
 *
 */
public class _226_翻转二叉树 {
	
	/**
	 * 递归方式一实现
	 */
	public TreeNode invertTree1(TreeNode root) {
		if (root == null) return root;
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTree1(root.left);
		invertTree1(root.right);
				
		return root;
	}
	
	/**
	 * 递归方式二实现
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) return root;
		invertTree2(root.left);
		invertTree2(root.right);
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		return root;
	}
	
	/**
	 * 递归方式三实现
	 */
	public TreeNode invertTree3(TreeNode root) {
		if (root == null) return root;
		
		invertTree3(root.left);
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTree3(root.left);
		
		return root;
	}
	
	public TreeNode invertTree4(TreeNode root) {
		if (root == null) return root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		
		return root;
	}
	
}
