package com.leetcode.test123.maximumBinaryTree;

//#654. Maximum Binary Tree
class Solution {
  public TreeNode constructMaximumBinaryTree (int[] nums) {
    return create(nums, 0, nums.length - 1);
  }

  private TreeNode create (int[] nums, int start, int end) {
    if (start > end)
      return null;

    int maxId = start;
    int max = nums[start];
    for (int i = start; i <= end; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxId = i;
      }
    }
    TreeNode root = new TreeNode(nums[maxId]);
    root.left = create(nums, start, maxId - 1);
    root.right = create(nums, maxId + 1, end);
    return root;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int val) {
      this.val = val;
    }
  }
}
