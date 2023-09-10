package com.leetcode.test220.addTwoNumbersLList;

//445. Add Two Numbers II
class Solution {
  public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode ans = add(l1, l2);
    return reverse(ans);
  }

  ListNode add (ListNode l1, ListNode l2) {
    int car = 0;
    ListNode ansHead = null;
    ListNode head = null;
    while (l1 != null || l2 != null) {
      int r = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + car;
      car = r / 10;
      r = r % 10;
      ListNode node = new ListNode(r);
      if (ansHead == null) {
        ansHead = node;
        head = node;
      } else {
        head.next = node;
        head = node;
      }
      if(l1 != null) {
        l1 = l1.next;
      }
      if(l2 != null) {
        l2 = l2.next;
      }
    }
    if(car > 0) {
      ListNode node = new ListNode(car);
      head.next = node;
      head = node;
    }
    return ansHead;
  }

  ListNode reverse (ListNode head) {
    ListNode prev = null;
    ListNode next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
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
