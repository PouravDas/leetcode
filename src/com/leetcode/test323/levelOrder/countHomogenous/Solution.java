package com.leetcode.test323.levelOrder.countHomogenous;

import com.leetcode.test4.binaryMaxPathSum.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      result.add(level);
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String upperCase = "odm_bn_ntp_BusinessPartner_BusinessPartner_companyKeywords".toUpperCase();
    System.out.println(upperCase);
  }
}
