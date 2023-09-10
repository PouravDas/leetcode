package com.leetcode.test175.SortLinkedList;

class Solution {
  public ListNode sortList(ListNode head) {
    if(head == null) return null;
    return mergerSort( head);
  }

  private ListNode mergerSort (ListNode head) {
    if(head.next == null) {
      return head;
    }
    ListNode h = head;
    head = head.next;
    h.next = null;

    head = mergerSort(head);
    if(h.val <= head.val){
      h.next = head;
      head = h;
    } else {
      ListNode node = head;
      ListNode pre = head;
      while (node != null && h.val > node.val) {
        pre = node;
        node = node.next;
      }
      pre.next = h;
      h.next = node;
    }
    return head;
  }

  public class ListNode {
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
