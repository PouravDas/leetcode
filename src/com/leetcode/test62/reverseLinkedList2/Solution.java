package com.leetcode.test62.reverseLinkedList2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseBetween (ListNode head, int left, int right) {

    ListNode start = null;
    ListNode curr = head;
    for (int i = 1; i < left; i++) {
      start = curr;
      curr = curr.next;
    }

    ListNode prev = null;
    ListNode tail = null;
    ListNode next = null;

    for (int i = 0; i <= right - left; i++) {
      if (i == 0) {
        tail = curr;
      }

      next = curr.next;

      curr.next = prev;
      prev = curr;
      curr = next;
    }

    tail.next = curr;
    if (start != null)
      start.next = prev;
    else
      return prev;

    return head;
  }

  public static class ListNode {
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

    @Override public String toString () {
      return "ListNode{" + "val=" + val + '}';
    }
  }

  public static void main (String[] args) {

    Solution s = new Solution();
    ListNode head =
        //new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ListNode(1, new ListNode(2));
    ListNode ans = s.reverseBetween(head, 1, 2);


  }
}
