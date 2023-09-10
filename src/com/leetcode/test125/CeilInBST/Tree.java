package com.leetcode.test125.CeilInBST;

//#find ceil in BST
// https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
class Tree {
  // Function to return the ceil of given number in BST.
  int findCeil (Node root, int key) {
    if (root == null)
      return -1;
    // Code here
    int ans = Integer.MAX_VALUE;
    while (root != null) {
      if (root.data == key) {
        ans = root.data;
        break;
      } else if (root.data > key) {
        ans = root.data;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return ans;
  }

  private static class Node {
    int data;
    Node left, right;
  }
}
