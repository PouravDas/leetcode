package com.leetcode.test221.levelOrderBottom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> levelOrderBottom (TreeNode root) {
    List<List<Integer>> listAns = new ArrayList<>();
    if (root == null)
      return listAns;
    ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
      }
      stack.push(list);
    }
    while (!stack.isEmpty())
      listAns.add(stack.pop());
    return listAns;
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
