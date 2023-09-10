package com.leetcode.test124.DeleteNodeInBST;

//#450. Delete Node in a BST
class Solution {
  public TreeNode deleteNode (TreeNode root, int key) {

    if (root == null) {
      return null;
    } else if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        root.val = findLeftMost(root.right).val;
        root.right = deleteNode(root.right, root.val);
      }
    }
    return root;
  }

  private TreeNode findLeftMost (TreeNode root) {
    if (root.left == null)
      return root;
    return findLeftMost(root.left);
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
