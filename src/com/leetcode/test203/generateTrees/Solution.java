package com.leetcode.test203.generateTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//95. Unique Binary Search Trees II
class Solution {
  public List<TreeNode> generateTrees (int n) {
    return generateTrees(1,n);
  }

  public List<TreeNode> generateTrees (int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if(start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      TreeNode root = new TreeNode(i);
      List<TreeNode> left = generateTrees(start, i - 1);
      List<TreeNode> right = generateTrees(i + 1, end);
      for (TreeNode l : left) {
        root.left = l;
        for (TreeNode r : right) {
          root.right = r;
          result.add(copyOf(root));
        }
      }
    }
    return result;
  }

  private TreeNode copyOf (TreeNode parent) {
    if (parent == null)
      return null;
    else {
      TreeNode node = new TreeNode();
      copyOf(node, parent);
      return node;
    }
  }

  private void copyOf (TreeNode copy, TreeNode org) {
    if (org == null)
      copy = null;
    else {
      copy.val = org.val;
      if (Objects.nonNull(org.left)) {
        copy.left = new TreeNode();
        copyOf(copy.left, org.left);
      }
      if (Objects.nonNull(org.right)) {
        copy.right = new TreeNode();
        copyOf(copy.right, org.right);
      }
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

  public static void main (String[] args) {
    Solution s = new Solution();
    s.generateTrees(3);
  }
}
