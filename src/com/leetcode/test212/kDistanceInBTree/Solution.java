package com.leetcode.test212.kDistanceInBTree;

import java.util.ArrayList;
import java.util.List;

//863. All Nodes Distance K in Binary Tree
class Solution {

  List<Integer> list = new ArrayList<>();
  int depth = 0;

  public List<Integer> distanceK (TreeNode root, TreeNode target, int k) {
    depth = k;
    findTarget(root, target);
    return list;
  }

  private int findTarget (TreeNode root, TreeNode target) {
    if (root.val == target.val) {
      addToList(root, depth);
      return 1;
    }
    int leftDepth = Integer.MIN_VALUE, rightDepth = leftDepth;
    if (root.left != null) {
      int d = findTarget(root.left, target);
      if (d == Integer.MIN_VALUE)
        leftDepth = d;
      else {
        if (d == depth) {
          list.add(root.val);
        } else if (d < depth) {
          addToList(root.right, depth - d - 1);
        }
        leftDepth = d + 1;
      }
    }

    if (root.right != null) {
      int d = findTarget(root.right, target);
      if (d == Integer.MIN_VALUE)
        rightDepth = d;
      else {
        if (d == depth) {
          list.add(root.val);
        } else if (d < depth) {
          addToList(root.left, depth - d - 1);
        }
        return d + 1;
      }
    }

    return Math.max(leftDepth, rightDepth);
  }

  private void addToList (TreeNode root, int depth) {
    if (root == null)
      return;
    if (depth == 0) {
      list.add(root.val);
    } else {
      addToList(root.left, depth - 1);
      addToList(root.right, depth - 1);
    }
  }

  static public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
      val = x;
    }

    @Override public String toString () {
      return "TreeNode{" + "val=" + val + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    TreeNode n0 = new TreeNode(0);
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    n0.left = n1;
    n1.left = n3;
    n1.right = n2;

    List list = s.distanceK(n0, n2, 1);
    System.out.println(list);
  }
}
