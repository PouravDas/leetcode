package com.leetcode.test178.binaryTreeNextRightPointer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {
  Node NULL = new Node();
  public Node connect(Node root) {
    if(root == null) return null;
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    queue.offer(NULL);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (true) {
        Node n = queue.poll();
        if(n == NULL) {
          if(queue.peek() != NULL)
          queue.offer(NULL);
          break;
        }
        n.next = queue.peek() != NULL? queue.peek() : null;
        if(n.left != null)
          queue.offer(n.left);
        if(n.right != null)
          queue.offer(n.right);
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
