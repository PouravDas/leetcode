package com.leetcode.test182.oddEvenLinkedList;

class Solution {
  public ListNode oddEvenList2(ListNode head) {

    ListNode evenHead = null;
    ListNode evenCurr = null;
    ListNode oddHead = null;
    ListNode oddCurr = null;

    while (head != null) {
      if(oddHead == null) {
        oddHead = head;
        oddCurr = head;
      } else {
        oddCurr.next = head;
        oddCurr = oddCurr.next;
      }
      ListNode next = head.next;
      if(next == null) {
        break;
      }
      if(evenHead == null) {
        evenHead = next;
        evenCurr = next;
      } else {
        evenCurr.next = next;
        evenCurr = evenCurr.next;
      }
      head = next.next;
    }
    oddCurr.next = evenHead;
    return oddHead;
  }

  public ListNode oddEvenList(ListNode head) {
    ListNode evenHead = null;
    ListNode evenCurr = null;
    ListNode oddHead = null;
    ListNode oddCurr = null;

    int i = 1;

    while (head != null) {
      ListNode next = head.next;
      head.next = null;
      if((i & 1) == 1) {
        if(oddCurr == null) {
          oddCurr = oddHead = head;
        } else {
        oddCurr.next = head;
        oddCurr = head;
        }
      } else {
        if (evenCurr == null){
          evenCurr = evenHead = head;
        } else {
          evenCurr.next = head;
          evenCurr = head;
        }
      }
      head = next;
      i++;
    }
    if(oddCurr != null)
      oddCurr.next = evenHead;
    return oddHead;
  }
  
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override public String toString () {
        return "ListNode{" + "val=" + val + '}';
      }
    }

  public static void main (String[] args) {
    Solution s = new Solution();
    ListNode head = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
    s.oddEvenList(head);
  }
}
