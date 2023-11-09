package com.leetcode.test314.largestValues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//515. Find Largest Value in Each Tree Row
//medium
class Solution {
  public List<Integer> largestValues(TreeNode root) {
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    List<Integer> ans = new ArrayList<>();
    if(root == null) return ans;
    queue.offer(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode e = queue.poll();
        max = Math.max(max,e.val);
        if(e.left != null) queue.offer(e.left);
        if(e.right != null) queue.offer(e.right);
      }
      ans.add(max);
    }
    return ans;
  }

  public class TreeNode {
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
