package com.leetcode.test119.lowestCommonAncestorBinaryTree;

public class SolutionBetter {
  public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    if (root == p || root == q) {
      return root;
    } else {
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left == p && right == q || left == q && right == p)
        return root;
      else
        return left != null ? left : right;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
      val = x;
    }
  }
}
