package com.leetcode.test309.recoverTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

//wrong
class Solution {
  public void recoverTree (TreeNode root) {
    dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode dfs (TreeNode root, int minValue, int maxValue) {
    if (root == null)
      return null;
    if (minValue <= root.val && root.val <= maxValue) {
      TreeNode left = dfs(root.left, minValue, root.val);
      TreeNode right = dfs(root.right, root.val, maxValue);
      if (left == null && right == null) {
        return null;
      } else if (left != null && right != null) {
        swap(left, right);
        return null;
      } else if (left != null) {
        if (left.val > root.val) {
          swap(left, root);
          return null;
        } else
          return left;
      } else {
        if (right.val < root.val) {
          swap(right, root);
          return null;
        }
        return right;
      }
    } else {
      return root;
    }
  }

  private void swap (TreeNode left, TreeNode right) {
    int temp = left.val;
    left.val = right.val;
    right.val = temp;
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
