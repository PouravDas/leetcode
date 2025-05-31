package com.leetcode.test110.HouseRobber3;

public class Solution3 {
  public int rob(TreeNode root) {
    int[] dp = travel(root);
    return Math.max(dp[0], dp[1]);
  }

  private int[] travel(TreeNode root) {
    int[] dp = new int[2];
    if (root == null) return dp;
    int[] leftDP = travel(root.left);
    int[] rightDP = travel(root.right);
    //using root
    dp[0] = root.val + leftDP[1] + rightDP[1];
    //not using root
    dp[1] = Math.max(leftDP[0], leftDP[1]) + Math.max(rightDP[0], rightDP[1]);
    return dp;
  }


  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
