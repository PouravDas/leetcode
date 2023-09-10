package com.leetcode.test22.medianFromStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.addNum(6);
		s.addNum(10);
		s.addNum(2);
		s.addNum(6);
		s.addNum(5);
		/*
		s.addNum(0);
		s.addNum(6);
		s.addNum(3);
		s.addNum(1);
		s.addNum(0);
		s.addNum(0);
		*/
	}

	
	PriorityQueue<Integer> small;
	PriorityQueue<Integer> large;
	
	public Solution() {
		small = new PriorityQueue<>(Collections.reverseOrder());
		large = new PriorityQueue<>();
    }

	public void addNum(int num) {
		small.add(num);
		
		if(large.size() > 0 && small.peek() > large.peek()) {
			large.add(small.poll());
		}
		
		if(small.size() - large.size() > 1)
			large.add(small.poll());
		else if (large.size() - small.size() > 1)
			small.add(large.poll());
		System.out.println(small);
		System.out.println(large);
		System.out.println(findMedian());
	}

	public double findMedian() {
		if(small.size() == large.size()) {
			return ((double)small.peek() + (double)large.peek()) / 2;
		}
		
		else if (small.size() > large.size())
			return small.peek();
		else
			return large.peek();
	}
}
