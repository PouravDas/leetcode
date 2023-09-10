package com.leetcode.test103.LinkedListCycleII;

//#142
public class Solution {
  public ListNode detectCycle (ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    boolean cycleFound = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycleFound = true;
        break;
      }
    }
    if (!cycleFound)
      return null;

    while (head != fast) {
      head = head.next;
      fast = fast.next;
    }
    return head;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(-4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2;
    ListNode ans = s.detectCycle(node1);
    System.out.println(ans);
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
      val = x;
      next = null;
    }

    @Override public String toString () {
      return "ListNode{" + "val=" + val + '}';
    }
  }


}
