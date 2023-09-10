package com.leetcode.test121.burnABinaryTree;

//https://www.interviewbit.com/problems/burn-a-tree/
public class Solution {
  int maxBurnDepth = -1;

  public int solve (TreeNode A, int B) {
    findMaxDepth(A, B);
    return maxBurnDepth;
  }

  private int[] findMaxDepth (TreeNode root, int target) {
    if (root == null)
      return new int[] {0, 0};
    if (root.val == target)
      return new int[] {1, 1};
    int[] left = findMaxDepth(root.left, target);
    int[] right = findMaxDepth(root.right, target);
    int depth = 0;
    int burning = 0;
    if (left[1] == 0 && right[1] == 0) {
      depth = 1 + Math.max(left[0], right[0]);
    } else {
      maxBurnDepth = Math.max(maxBurnDepth, 1 + left[0] + right[0]);
      if (left[1] == 1) {
        depth = left[0] + 1;
      } else {
        depth = right[0] + 1;
      }
      burning = 1;
    }
    return new int[] {depth, burning};
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int v) {
      val = v;
    }

    TreeNode (int v, TreeNode l, TreeNode r) {
      val = v;
      left = l;
      right = r;
    }

    @Override public String toString () {
      return "TreeNode{" + "val=" + val + '}';
    }
  }

  public static void main (String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
        new TreeNode(3, new TreeNode(5), new TreeNode(6)));
    Solution s = new Solution();
    int ans = s.solve(root, 5);
    System.out.println(ans);
  }
}
