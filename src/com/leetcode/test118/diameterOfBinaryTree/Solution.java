package com.leetcode.test118.diameterOfBinaryTree;

//#543. Diameter of Binary Tree
class Solution {
  int max = 0;

  public int diameterOfBinaryTree (TreeNode root) {
    findMaxDepth(root);
    return max;
  }

  private int findMaxDepth (TreeNode root) {
    if (root == null)
      return 0;
    int left = findMaxDepth(root.left);
    int right = findMaxDepth(root.right);
    max = Math.max(max, left + right);
    return 1 + Math.max(left, right);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode (int val) {
      this.val = val;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
