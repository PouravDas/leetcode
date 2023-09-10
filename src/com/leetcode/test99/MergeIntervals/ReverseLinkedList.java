package com.leetcode.test99.MergeIntervals;

public class ReverseLinkedList {

  public static Node reverse (Node head) {
    return reverse(head, null);
  }

  private static Node reverse (Node curr, Node prev) {
    if (curr.next == null) {
      curr.next = prev;
      return curr;
    }
    Node temp = curr.next;
    curr.next = prev;
    prev = curr;
    return reverse(temp, prev);
  }

  private static class Node {
    int val;
    Node next;

    Node (int val) {
      this.val = val;
    }

    Node (int v, Node n) {
      val = v;
      next = n;
    }
  }

  public static void printLnkList (Node h) {
    System.out.println();
    System.out.print("Lnk List = ");
    while (h != null) {
      System.out.print(h.val + " -> ");
      h = h.next;
    }
    System.out.println();
  }

  public static void main (String[] args) {
    Node head = new Node(1, new Node(2, new Node(3)));
    printLnkList(head);
    head = reverse(head);
    printLnkList(head);
  }
}
