package com.leetcode.test169.isTreeSymmetric;

//101. Symmetric Tree
class Solution {
  public boolean isSymmetric (TreeNode root) {
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric (TreeNode left, TreeNode right) {
    if (left != null && right != null) {
      if(left.val != right.val) return false;
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    } else {
      if (left == null && right == null)
        return true;
      else
        return false;
    }
  }


  static class TreeNode {
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
