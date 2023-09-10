package com.leetcode.test16.mergeSortKlist;

import java.util.PriorityQueue;

public class Solution {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(100);
		q.add(10);
		q.add(90);
		q.add(4);
		q.add(200);
		q.add(2);
		
		while(!q.isEmpty())
		System.out.println(q.poll());
	}
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (ListNode list : lists) {
			while (list != null) {
				q.add(list.val);
				list = list.next;
			}
		}
		ListNode r = null;
		ListNode c = null;
		while(!q.isEmpty()) {
			int v = q.poll();
			if (r == null) {
				c = new ListNode(v);
				r = c;
			} else {
				c.next = new ListNode(v);
				c = c.next;
			}
		}
		return r;
	}
}
