package com.leetcode.test40.KthLargestElementInAnArray;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//#215
public class Solution {
  private int size;
  private Queue<Integer> queue;
  private Set<Integer> set;

  public int findKthLargest (int[] nums, int k) {
    size = k;
    queue = new PriorityQueue<>( (a, b) -> b - a);
    
    set = new HashSet<>();
    for (int n : nums) {
      add(n);
    }
    return get();
  }

  private void add (int n) {
    if (!set.contains(n)) {
      queue.add(n);
    }
  }

  private int get () {
    int ans = -1;
    while (size > 0) {
      ans = queue.poll();
      size--;
    }
    return ans;
  }
}
