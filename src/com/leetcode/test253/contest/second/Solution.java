package com.leetcode.test253.contest.second;

class Solution {
  public ListNode doubleIt(ListNode head) {
    String num = "";
    while (head != null) {
      num = num + head.val;
      head = head.next;
    }
    String n = "";
    int car = 0;
    for (int i = num.length() - 1; i > -1; i--) {
      int d = num.charAt(i) - '0';
      d = d * 2 + car;
      n = (d % 10) + n;
      car = d / 10;
    }
    if(car > 0) {
      n = car + n;
    }
    ListNode h = null;
    ListNode curr = null;

    for(char c : n.toCharArray()) {
      ListNode node = new ListNode(c - '0');
      if(curr == null) {
        curr = node;
        h = curr;
      } else {
        curr.next = node;
      }
      curr = node;
    }
    return h;
  }
  
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
