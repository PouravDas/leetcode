package com.leetcode.test4.binaryMaxPathSum;

public class Solution_2 {
	int sum_ = 0;

	public int sumNumbers(TreeNode root) {

		findSum(root, 0);
		return sum_ / 2;
	}

	private void findSum(TreeNode root, int sum) {
		if (root == null) {
			sum_ += sum;
			return;
		}

		sum = sum * 10 + root.val;
		findSum(root.left, sum);
		findSum(root.right, sum);
	}
	
	public static void main(String[] args) {
		Solution_2 s = new Solution_2();
		int ans = s.sumNumbers(new TreeNode(1,new TreeNode(2), new TreeNode(3)));
		System.out.println(ans);
	}
}
