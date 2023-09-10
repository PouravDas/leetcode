package com.leetcode.test110.HouseRobber3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//#337
class Solution {
  public int rob (TreeNode root) {

    Map<String, Integer> dp = new HashMap<>();
    return Math.max(rob(root, true, dp), rob(root, false, dp));
  }

  private int rob (TreeNode root, boolean rootAdded, Map<String, Integer> dp) {
    if (root == null) {
      return 0;
    }
    int ans;
    String key = "" + root.hashCode() + rootAdded;
    if (dp.get(key) != null) {
      ans = dp.get(key);
    } else if (rootAdded) {
      int left = rob(root.left, false, dp);
      int right = rob(root.right, false, dp);
      ans = root.val + left + right;
    } else {
      int left = Math.max(rob(root.left, false, dp), rob(root.left, true, dp));
      int right = Math.max(rob(root.right, false, dp), rob(root.right, true, dp));
      return left + right;
    }
    dp.put(key, ans);
    return ans;
  }

  private static class TreeNode {
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

    @Override public boolean equals (Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      TreeNode treeNode = (TreeNode) o;
      return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects
          .equals(right, treeNode.right);
    }

    @Override public int hashCode () {
      return Objects.hash(val, left, right);
    }
  }
}
