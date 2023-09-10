package com.leetcode.test14.nodeRemove;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {

		int n = 1534236469;
		try {
			int x = Integer.parseInt("");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Integer.parseInt("");
		StringBuilder sb = new StringBuilder("" + n);
		
		System.out.println(n);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer. toBinaryString(n));
		System.out.println();

		for (int i = 31; i >= 0; i--) {
			int a = n & (1 << i);
			if (a != 0)
				System.out.print(1);
			
			else
				System.out.print(0);
		}

	}

	Queue<ListNode> queue = new LinkedList<ListNode>();
	int size;

	public ListNode removeNthFromEnd(ListNode head, int n) {
		size = n + 1;
		ListNode h = head;
		while (h != null) {
			addToQ(h);
			h = h.next;
		}

		ListNode qh = queue.poll();
		qh.next = qh.next.next;

		return head;
	}

	private void addToQ(ListNode n) {
		if (queue.size() >= size) {
			queue.poll();
		}
		queue.add(n);
	}
}
