package com.leetcode.test111.flattenMultilevelLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

//#430
class Solution {
  public Node flatten (Node head) {
    if (head == null)
      return null;
    Deque<Node> stack = new ArrayDeque<>();
    stack.push(head);
    Node h = null;
    Node p = null;
    while (!stack.isEmpty()) {
      if (h == null)
        h = stack.pop();
      else {
        h.next = stack.pop();
        h.next.prev = h;
      }
      while (h != null) {
        while (h != null && h.child == null) {
          p = h;
          h = h.next;
        }
        if (h == null)
          continue;
        Node next = h.next;
        if (next != null) {
          next.prev = null;
          stack.push(next);
        }
        h.next = h.child;
        h.child = null;
        h.next.prev = h;
      }
      if (p.child != null) {
        p.next = p.child;
        p.child = null;
        p.next.prev = p;
      }
      h = p;
    }
    return head;
  }

  private static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  }

  public static void main (String[] args) {
    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node();
    n1.val = 1;
    n1.child = n2;
    n2.val = 2;
    n2.child = n3;
    n3.val = 3;

    Solution s = new Solution();
    s.flatten(n1);
    System.out.println(n1);
  }
}
