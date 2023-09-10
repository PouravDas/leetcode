package com.leetcode.test180.KthSmallestBST;

import java.util.ArrayList;
import java.util.List;

//230. Kth Smallest Element in a BST
class Solution {
  public int kthSmallest (TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list, k);
    return list.get(k - 1);
  }

  private void inOrder (TreeNode root, List<Integer> list, int k) {
    if (list.size() == k)
      return;
    if (root == null)
      return;
    inOrder(root.left, list, k);
    list.add(root.val);
    inOrder(root.right, list, k);
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
