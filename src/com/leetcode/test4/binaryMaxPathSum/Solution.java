package com.leetcode.test4.binaryMaxPathSum;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		calculateSum(root);
		return max;
	}

	private int calculateSum(TreeNode root) {
		if (root == null)
			return 0;

		int l = calculateSum(root.left);
		int r = calculateSum(root.right);
		int locMax = Math.max(root.val, Math.max(l + root.val, r + root.val));

		max = Math.max(max, Math.max(l + r + root.val, locMax));

		return locMax;
	}
}
