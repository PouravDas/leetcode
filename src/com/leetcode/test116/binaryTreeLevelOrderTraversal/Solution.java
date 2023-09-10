package com.leetcode.test116.binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

//#102. Binary Tree Level Order Traversal
class Solution {
  public List<List<Integer>> levelOrder (TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    levelOrder(root, 0, list);
    return list;
  }

  private void levelOrder (TreeNode root, int i, List<List<Integer>> list) {
    if (root == null)
      return;

    if (list.size() < (i + 1)) {
      list.add(new ArrayList<>());
    }
    list.get(i).add(root.val);
    levelOrder(root.left, i + 1, list);
    levelOrder(root.right, i + 1, list);
  }

  public static class TreeNode {
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
