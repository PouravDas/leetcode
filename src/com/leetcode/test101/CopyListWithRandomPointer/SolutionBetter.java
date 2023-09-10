package com.leetcode.test101.CopyListWithRandomPointer;

// # 138
public class SolutionBetter {
  public Node copyRandomList (Node head) {
    if(head ==null)
      return null;
    Node h = head;
    Node copyHead = null;

    while (h != null) {
      System.out.println("loop 1 v = " +h.val);
      Node node = new Node(h.val);
      node.next = h.next;
      h.next = node;
      h = h.next.next;
    }
    h = head;
    while (h != null && head.next != null) {
      System.out.println("loop 2 v = " +h.val);
      if(h.random != null)
        h.next.random = h.random.next;
      h = h.next.next;
    }
    copyHead = head.next;
    while (head != null && head.next != null) {
      System.out.println("loop 3 v = " +head.val);
      Node temp = head.next;
      head.next = head.next.next;
      head = temp;
    }
    return copyHead;
  }

  private static class Node {
    int val;
    Node next;
    Node random;

    public Node (int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
