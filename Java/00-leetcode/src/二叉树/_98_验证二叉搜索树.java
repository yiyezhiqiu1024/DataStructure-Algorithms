package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _98_验证二叉搜索树 {
	
	public static void main(String[] args) { 
		TreeNode root = new TreeNode(7);
		TreeNode left1 = new TreeNode(4);
		root.left = left1;
		TreeNode right1 = new TreeNode(9);
		root.right = right1;
		
		TreeNode left2 = new TreeNode(2);
		left1.left = left2;
		TreeNode right2 = new TreeNode(5);
		left1.right = right2;
		
		TreeNode left3 = new TreeNode(1);
		left2.left = left3;
		TreeNode right3 = new TreeNode(3);
		left2.right = right3;
		
		TreeNode left4 = new TreeNode(8);
		right1.left = left4;
		TreeNode right4 = new TreeNode(11);
		right1.right = right4;
		
		TreeNode left5 = new TreeNode(10);
		right4.left = left5;
		TreeNode right5 = new TreeNode(12);
		right4.right = right5;
		
		System.out.println(isValidBST(root));
	}
	
	/**
	 * 思路2 - 遍历的同时指定范围（层序遍历）
	 */
	private static Queue<TreeNode> nodes = new LinkedList<>();
	private static Queue<Integer> mins = new LinkedList<>();
	private static Queue<Integer> maxes = new LinkedList<>();
	
	private static void offer(TreeNode node, Integer min, Integer max) {
		if (node == null) return;
		nodes.offer(node);
		mins.offer(min);
		maxes.offer(max);
	}
	
	public static boolean isValidBST(TreeNode root) { 
		if (root == null) return true;
		offer(root, null, null);
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			Integer min = mins.poll();
			if (min != null && node.val <= min) return false;
			Integer max = maxes.poll();
			if (max != null && node.val >= max) return false;
			offer(node.left, min, node.val);
			offer(node.right, node.val, max);
		}
		return true;
	}
	
	/**
	 * 思路2 - 遍历的同时指定范围（前序遍历）
	 */
	public static boolean isValidBST3(TreeNode root) { 
		return isValidBST(root, null, null);
	}
	
	public static boolean isValidBST(TreeNode node, Integer min, Integer max) {
		if (node == null) return true;
		if (min != null && node.val <= min) return false;
		if (max != null && node.val >= max) return false;
		if (!isValidBST(node.left, min, node.val)) return false;
		if (!isValidBST(node.right, node.val, max)) return false;
		return true;
	}
	
	/**
	 * 思路1 - 中序遍历 - 递归
	 */
	private static Integer last = null;
	public static boolean isValidBST2(TreeNode root) {
		if (root == null) return true; 
		if (!isValidBST2(root.left)) return false;
		
		if (last == null && root.val <= last) return false;
		last = root.val;
		
		if (!isValidBST2(root.right)) return false; 
		return true;
	}
	
	/**
	 * 思路1 - 中序遍历 - 迭代
	 */
	public static boolean isValidBST1(TreeNode root) {
		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		Integer last = null;
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) break;
			root = stack.pop();
			
			if (last != null && root.val <= last) return false;
			last = root.val;
			
			root = root.right;
		}
		
		return true;
	}
	
	
	

}
