package com.leetcode.test232.allPossibleFBT;

import java.util.ArrayList;
import java.util.List;

//894. All Possible Full Binary Trees
class Solution {

  public List<TreeNode> allPossibleFBT (int n) {
    if ((n & 1) == 0)
      return new ArrayList<>();
    return findFBT(n);
  }

  private List<TreeNode> findFBT (int n) {
    List<TreeNode> list = new ArrayList<>();
    if (n == 1) {
      list.add(new TreeNode());
      return list;
    }
    for (int i = 1; i < n; i += 2) {
      List<TreeNode> left = findFBT(i);
      List<TreeNode> right = findFBT(n - i - 1);
      for (TreeNode l :left){
        for (TreeNode r:right) {
          TreeNode root = new TreeNode();
          root.left = l;
          root.right = r;
          list.add(root);
        }
      }
    }
    return list;
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

  public static void main (String[] args) {
    Solution s = new Solution();
    s.allPossibleFBT(5);
  }
}
