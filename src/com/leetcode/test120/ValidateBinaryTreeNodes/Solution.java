package com.leetcode.test120.ValidateBinaryTreeNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//#1361. Validate Binary Tree Nodes
class Solution {
  boolean ans = true;
  int size = 0;
  public boolean validateBinaryTreeNodes (int n, int[] leftChild, int[] rightChild) {
    boolean[] inArr = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (leftChild[i] > -1) {
        inArr[leftChild[i]] = true;
      }
      if (rightChild[i] > -1) {
        inArr[rightChild[i]] = true;
      }
    }
    int notInArrCount = 0;
    int root = -1;
    for (int i = 0; i < n; i++) {
      if (!inArr[i]) {
        root = i;
        notInArrCount++;
      }
    }
    if (notInArrCount != 1) {
      ans = false;
    } else {
      Set<Integer> set = new HashSet<>();
      traverse(root, leftChild, rightChild, set);
    }
    return ans && size == n;
  }

  private void traverse (int root, int[] leftChild, int[] rightChild, Set<Integer> set) {
    if (root == -1)
      return;
    size++;
    if (set.contains(root)) {
      ans = false;
      return;
    } else {
      set.add(root);
      traverse(leftChild[root], leftChild, rightChild, set);
      traverse(rightChild[root], leftChild, rightChild, set);
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.validateBinaryTreeNodes(3,new int[]{1,-1,-1}, new int[]{-1,-1,1});
  }
}
