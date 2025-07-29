package com.leetcode.test101.CopyListWithRandomPointer;

public class SolutionV2 {
  public Node copyRandomList(Node head) {
    Node copy = null;
    Node h = head;
    while (h != null) {
      Node n = new Node(h.val);
      Node next = h.next;
      h.next = n;
      n.next = next;
      h = next;
    }
    h = head;
    while (h != null) {
      if (h.random != null)
        h.next.random = h.random.next;
      h = h.next.next;
    }
    h = head;
    Node prev = null;
    while (h != null) {
      Node next = h.next;
      if (prev == null) {
        copy = next;
      } else {
        prev.next = next;
      }
      prev = next;
      h.next = next.next;
      h = next.next;
    }
    return copy;
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
