package com.leetcode.test162.binaryTreeFromInPostOrder;

//106. Construct Binary Tree from Inorder and Postorder Traversal
public class Solution {
  public TreeNode buildTree (int[] inorder, int[] postorder) {
    return findParent(inorder, postorder);
  }

  private TreeNode findParent (int[] inorder, int[] postorder) {
    if(postorder == null) return null;
    TreeNode parent = new TreeNode(postorder[postorder.length - 1]);
    int idx = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == parent.val) {
        idx = i;
        break;
      }
    }
    TreeNode left = findParent(copyArray(inorder, 0, idx - 1), copyArray(postorder, 0, idx - 1));
    TreeNode right = findParent(copyArray(inorder, idx + 1, inorder.length - 1),
        copyArray(postorder, idx, postorder.length - 2));
    parent.left = left;
    parent.right = right;
    return parent;
  }

  private int[] copyArray (int[] arr, int i, int j) {
    if (i > j) return null;
    int[] ans = new int[j - i + 1];
    int idx = 0;
    for (int k = i; k <= j; k++) {
      ans[idx++] = arr[k];
    }
    return ans;
  }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
