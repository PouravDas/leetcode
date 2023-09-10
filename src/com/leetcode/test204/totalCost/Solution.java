package com.leetcode.test204.totalCost;

import java.util.PriorityQueue;

//2462. Total Cost to Hire K Workers
class Solution {
  public long totalCost (int[] costs, int k, int candidates) {
    PriorityQueue<Integer> left = new PriorityQueue<>(), right = new PriorityQueue<>();
    long ans = 0;
    int start = 0;
    int end = costs.length - 1;

    for (int i = 0; i < candidates; i++) {
      if (start <= end) {
        left.offer(costs[start++]);
      }
      if (start <= end) {
        right.offer(costs[end--]);
      }
    }

    for (int i = 0; i < k; i++) {
      if (!left.isEmpty() && !right.isEmpty()) {
        if (left.peek() <= right.peek()) {
          ans += left.poll();
          if (start <= end) {
            left.offer(costs[start++]);
          }
        } else {
          ans += right.poll();
          if (start <= end) {
            right.offer(costs[end--]);
          }
        }
      } else if (!left.isEmpty()) {
        ans += left.poll();
        if (start <= end) {
          left.offer(costs[start++]);
        }
      } else {
        ans += right.poll();
        if (start <= end) {
          right.offer(costs[end--]);
        }
      }
    }
    return ans;
  }
}
