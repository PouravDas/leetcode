package com.leetcode.test279.splitListToParts;

class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    int size = 0;
    ListNode h = head;
    while(h != null) {
      size++;
      h = h.next;
    }
    int s = size / k;
    int rem = size % k;
    ListNode[] arr = new ListNode[k];
    int idx = 0;
    h = head;
    ListNode pre = null;
    for (int i = 0; i < rem; i++) {
      if(pre != null) pre.next = null;
      arr[idx++] = h;
      for (int j = 0; j < s + 1; j++) {
        pre = h;
        h = h.next;
      }
    }
    for (int i = rem; i < k; i++) {
      if(pre != null) pre.next = null;
      arr[idx++] = h;
      for (int j = 0; j < s; j++) {
        pre = h;
        h = h.next;
      }
    }
    return arr;
  }
  
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
