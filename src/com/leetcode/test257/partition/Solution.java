package com.leetcode.test257.partition;

//86. Partition List
class Solution {
  public ListNode partition (ListNode head, int x) {
    ListNode lHead = null;
    ListNode rHead = null;
    ListNode headL = null;
    ListNode headR = null;

    while (head != null) {
      ListNode next = head.next;
      if (head.val < x) {
        if (lHead != null) {
          lHead.next = head;
        }
        lHead = head;
        lHead.next = null;
        if (headL == null)
          headL = head;
      } else {
        if (rHead != null) {
          rHead.next = head;
        }
        rHead = head;
        rHead.next = null;
        if (headR == null)
          headR = head;
      }
      head = next;
    }

    if (headL == null)
      return headR;
    if (headR == null)
      return headL;

    lHead.next = headR;
    return headL;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode (int val) {
      this.val = val;
    }

    ListNode (int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
