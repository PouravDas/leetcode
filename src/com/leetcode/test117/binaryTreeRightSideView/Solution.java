package com.leetcode.test117.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

//#199. Binary Tree Right Side View
public class Solution {
  public List<Integer> rightSideView (TreeNode root) {
    List<Integer> rightView = new ArrayList<>();
    rightSideView(root, 1, rightView);
    return rightView;
  }

  private void rightSideView (TreeNode root, int size, List<Integer> rightView) {
    if (root == null) {
      return;
    }
    if (rightView.size() < size) {
      rightView.add(root.val);
    }
    rightSideView(root.right, size + 1, rightView);
    rightSideView(root.left, size + 1, rightView);
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
