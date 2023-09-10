package com.leetcode.test112.flattenBinaryTreetoLinkedList;

//#114
class Solution {
  public void flatten (TreeNode root) {
    flat(root);
  }

  private ListHelper flat (TreeNode root) {
    if (root == null) {
      return null;
    }
    ListHelper left = flat(root.left);
    ListHelper right = flat(root.right);
    root.left = null;
    if (left == null && right == null) {
      return new ListHelper(root);
    } else if (left == null) {
      root.right = right.head;
      right.head = root;
      return right;
    } else if (right == null) {
      root.right = left.head;
      left.head = root;
      return left;
    } else {
      root.right = left.head;
      left.head = root;
      left.tail.right = right.head;
      left.tail = right.tail;
      return left;
    }
  }

  private static class ListHelper {
    TreeNode head;
    TreeNode tail;

    public ListHelper (TreeNode head) {
      this.head = this.tail = head;
    }
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
  }
}
