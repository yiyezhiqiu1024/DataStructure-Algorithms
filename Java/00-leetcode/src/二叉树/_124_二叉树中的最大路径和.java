package 二叉树;

/**
 * https://pan.baidu.com/s/1HU7D6dZzP5HhaF833peHTw
 * @author zeng
 *
 */
public class _124_二叉树中的最大路径和 {
	
	private int sum = Integer.MIN_VALUE;
	
	/**
	 * 计算节点 node 能提供给父节点的最大路径值
	 */
	private int value(TreeNode node) {
		if (node == null) return 0;		
		int lv = Math.max(value(node.left), 0);
		int rv = Math.max(value(node.right), 0);
		sum = Math.max(sum, node.val + lv + rv);
		return node.val + Math.max(lv, rv);
	}
	
	public int maxPathSum(TreeNode node) {
		value(node);
		return sum;
	}
}
