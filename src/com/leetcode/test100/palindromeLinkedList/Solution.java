package com.leetcode.test100.palindromeLinkedList;

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
// # 234
class Solution {
  public boolean isPalindrome (ListNode head) {
    ListNode reverseHead = null;
    ListNode headRef = head;
    ListNode fastRef = head.next;

    if(head == null)
      return true;
    if(head.next == null)
      return true;
    if (fastRef.next != null && fastRef.next.next != null) {
      while (fastRef != null && fastRef.next != null) {
        headRef = headRef.next;
        fastRef = fastRef.next.next;
      }
    }
    reverseHead = reverse(headRef.next, null);
    while (reverseHead != null) {
      if (head.val != reverseHead.val)
        return false;
      head = head.next;
      reverseHead = reverseHead.next;
    }
    return true;
  }

  private ListNode reverse (ListNode curr, ListNode prev) {
    if (curr.next == null) {
      curr.next = prev;
      return curr;
    }
    ListNode temp = curr.next;
    curr.next = prev;
    prev = curr;
    return reverse(temp, prev);
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
  }

  public static void main (String[] args) {
    ListNode head =
        //new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
    Solution s = new Solution();
    boolean ans = s.isPalindrome(head);
    System.out.println(ans);
  }
}
