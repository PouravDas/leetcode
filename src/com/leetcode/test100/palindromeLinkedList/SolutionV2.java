package com.leetcode.test100.palindromeLinkedList;

public class SolutionV2 {
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    //reverse
    ListNode temp;
    ListNode prev = null;
    while (slow != null) {
      temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }
    while (head != null && prev != null) {
      if (head.val != prev.val) return false;
      head = head.next;
      prev = prev.next;
    }
    return true;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
  }
}