package 动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * @author zeng
 *
 */
public class _198_打家劫舍 {
	/**
	 * 思路1 - 递归
	 * 从前往后偷
	 * 时间复杂度是：O(2^n) 主要原因是：太多重复的计算
	 * 空间复杂度是：O(n) * 
	 */
	public int rob1(int[] nums) {
		if (nums == null || 0 == nums.length) return 0;
		return rob1(nums, 0);
	}
	
	private int rob1(int[] nums, int from) {
		if (from == nums.length - 1) return nums[from];
		if (from == nums.length - 2) return Math.max(nums[from], nums[from + 1]);
		int cur = nums[from] + rob1(nums, from + 2);
		int next = rob1(nums, from + 1);
		return Math.max(cur, next);
	}
	
	/**
	 * 思路2 - 递归 
	 * 从后往前偷
	 * 从前往后偷
	 * 时间复杂度是：O(2^n) 主要原因是：太多重复的计算
	 * 空间复杂度是：O(n)
	 */
	public int rob2(int[] nums) {
		if (nums == null || 0 == nums.length) return 0;
		return rob2(nums, nums.length - 1);
	}

	private int rob2(int[] nums, int from) {
		if (from == 0) return nums[0];
		if (from == 1) return Math.max(nums[1], nums[0]);
		int cur = nums[from] + rob2(nums, from - 2);
		int next = rob2(nums, from - 1);		
		return Math.max(cur, next);
	}
	
	/**
	 * 思路3 - 非递归 
	 * 利用数组存放前n个房屋的最高偷窃金额
	 * 空间复杂度、时间复杂度都是：O(n)
	 */
	public int rob3(int[] nums) {
		if (nums == null || 0 == nums.length) return 0;
		if (nums.length == 1) return nums[0];
		int[] array = new int[nums.length];
		array[0] = nums[0];
		array[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < array.length; i++) {
			array[i] = Math.max(nums[i] + array[i - 2], array[i - 1]);			
		}
		return array[nums.length - 1];
	}
	
	/**
	 * 思路4 - 非递归 - 空间复杂度优化
	 * 细心观察可以发现：每次计算只需要用到2个数组元素，所以改成使用2个整型变量即可
	 * 空间复杂度是：O(1)
	 * 时间复杂度是：O(n)
	 */
	public int rob4(int[] nums) {
		if (nums == null || 0 == nums.length) return 0;
		if (nums.length == 1) return nums[0];
		int prev = nums[0];
		int cur = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int tmp = cur;
			cur = Math.max(nums[i] + prev, cur);
			prev = tmp;
		}
		return cur;
	}
	
	/**
	 * 思路4 - 非递归 - 空间复杂度优化 - 代码优化
	 * 细心观察可以发现：每次计算只需要用到2个数组元素，所以改成使用2个整型变量即可
	 * 空间复杂度是：O(1)
	 * 时间复杂度是：O(n)
	 */
	public int rob5(int[] nums) {
		if (nums == null || 0 == nums.length) return 0;
		if (nums.length == 1) return nums[0];
		int prev = 0, cur = 0;
		for (int num : nums) {
			int tmp = cur;
			cur = Math.max(num + prev, cur);
			prev = tmp;
		}
		return cur;
	}
	
}
