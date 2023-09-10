package com.leetcode.test104.ReorderList;

class Solution {
  public void reorderList (ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode last = reverse(slow);
    ListNode h = head;
    while (h != null) {
      ListNode hNext = h.next;
      ListNode lNext = null;
      if (last != null)
        lNext = last.next;
      h.next = last;
      if (last != null)
        last.next = hNext;
      h = hNext;
      last = lNext;
    }
    if (last != null) {
      h.next = last;
    }
  }

  private ListNode reverse (ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }

  private static class ListNode {
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
