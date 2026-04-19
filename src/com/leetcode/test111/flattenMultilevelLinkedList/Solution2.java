package com.leetcode.test111.flattenMultilevelLinkedList;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution2 {
  public Node flatten(Node head) {
    if (head == null) return null;
    Stack<Node> stack = new Stack<>();
    stack.push(head);
    Node prev = null;
    while (!stack.isEmpty()) {
      Node n = stack.pop();
      while (n != null) {
        if (prev != null) {
          prev.next = n;
          n.prev = prev;
        }
        if (n.child != null) {
          if (n.next != null) {
            stack.push(n.next);
          }
          prev = n;
          n = n.child;
          prev.child = null;
        } else {
          prev = n;
          n = n.next;
        }
      }
    }
    return head;
  }

  private static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  ;
}
