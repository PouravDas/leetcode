package com.leetcode.test101.CopyListWithRandomPointer;

import java.util.HashMap;

// # 138
public class Solution {
  public Node copyRandomList (Node head) {
    Node h = head;
    int pos = 1;
    HashMap<Node, Node> nodeToNewNode = new HashMap<>();
    Node copyHead = null;
    Node copyRef = null;
    while (h != null) {
      Node newNode = new Node(h.val);
      if (copyHead == null) {
        copyHead = newNode;
        copyRef = copyHead;
      } else {
        copyRef.next = newNode;
        copyRef = newNode;
      }
      nodeToNewNode.put(h, newNode);
      h = h.next;
      pos++;
    }
    h = head;
    copyRef = copyHead;
    pos = 1;
    while (h != null) {
      if (h.random != null) {
        copyRef.random = nodeToNewNode.get(h.random);
      }
      h = h.next;
      copyRef = copyRef.next;
      pos++;
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
