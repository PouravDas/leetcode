package com.leetcode.test178.binaryTreeNextRightPointer;

import java.util.ArrayDeque;
import java.util.Queue;

//116. Populating Next Right Pointers in Each Node
class Solution {
  public Node connect(Node root) {
    if(root == null) return null;
    Queue<Node> queue = new ArrayDeque<> ();
    Node NULL = new Node();
    queue.offer(root);
    queue.offer(NULL);

    while (!queue.isEmpty()){
      Node curr = queue.poll();
      Node next = queue.peek();
      if(curr == NULL) {
        if(next == null) break;
        else queue.offer(NULL);
      } else {
        if(next != NULL)
          curr.next = next;
        else
          curr.next = null;
        if(curr.left != null) queue.offer(curr.left);
        if(curr.right != null) queue.offer(curr.right);
      }
    }

    return root;
  }

  class Node {
      public int val;
      public Node left;
      public Node right;
      public Node next;

      public Node() {}

      public Node(int _val) {
          val = _val;
      }

      public Node(int _val, Node _left, Node _right, Node _next) {
          val = _val;
          left = _left;
          right = _right;
          next = _next;
      }
  }
}
