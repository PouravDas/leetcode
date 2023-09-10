package com.leetcode.test119.lowestCommonAncestorBinaryTree;

import java.util.ArrayList;
import java.util.List;

//#236. Lowest Common Ancestor of a Binary Tree
// using two array list  ----->  Memory Limit Exceeded
class Solution {
  List<TreeNode> listP;
  List<TreeNode> listQ;

  public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
    findAncestors(root, p, q, new ArrayList<>());
    int idx = 0;
    while (idx < listP.size() && idx < listQ.size() && listP.get(idx) == listQ.get(idx)) {
      idx++;
    }
    return listP.get(idx - 1);
  }

  private void findAncestors (TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list) {
    if (root == null)
      return;
    list.add(root);
    if (root == p)
      listP = list;
    if (root == q)
      listQ = list;
    if (listP != null && listQ != null)
      return;
    findAncestors(root.left, p, q, new ArrayList<>(list));
    findAncestors(root.right, p, q, new ArrayList<>(list));
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) {
      val = x;
    }
  }
}
