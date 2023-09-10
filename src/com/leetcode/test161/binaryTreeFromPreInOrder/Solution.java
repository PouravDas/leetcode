package com.leetcode.test161.binaryTreeFromPreInOrder;

//105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
  public TreeNode buildTree (int[] preorder, int[] inorder) {
    return findParent(preorder, inorder);
  }

  private TreeNode findParent (int[] preorder, int[] inorder) {
    if (preorder == null)
      return null;
    TreeNode parent = new TreeNode(preorder[0]);

    int idx = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == preorder[0]) {
        idx = i;
        break;
      }
    }
    if (idx == -1)
      return parent;

    TreeNode left = findParent(copyArray(preorder, 1, idx), copyArray(inorder, 0, idx - 1));
    TreeNode right = findParent(copyArray(preorder, idx + 1, preorder.length - 1),
        copyArray(inorder, idx + 1, inorder.length - 1));
    parent.left = left;
    parent.right = right;
    return parent;
  }

  private int[] copyArray (int[] arr, int i, int j) {
    if(i > j) return null;
    int[] ans = new int[j - i + 1];
    int idx = 0;
    for (int k = i; k <= j ; k++) {
      ans[idx++] = arr[k];
    }
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
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
  }
}
