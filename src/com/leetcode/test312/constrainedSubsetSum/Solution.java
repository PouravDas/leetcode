package com.leetcode.test312.constrainedSubsetSum;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public int constrainedSubsetSum (int[] nums, int k) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] dp = new int[nums.length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      if (i == 0) {
        dp[i] = nums[i];
        max = Math.max(max, dp[i]);
        queue.offerLast(i);
        continue;
      }
      dp[i] = nums[i] + Math.max(0, dp[queue.peekFirst()]);
      while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
        queue.pollLast();
      }
      queue.offerLast(i);
      max = Math.max(max, dp[i]);
    }
    int right = k;
    int left = 0;
    while (right < nums.length) {
      dp[right] = nums[right] + Math.max(0, dp[queue.peekFirst()]);
      while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[right]) {
        queue.pollLast();
      }
      queue.offerLast(right);
      if(queue.peekFirst() == left) {
        queue.pollFirst();
      }
      max = Math.max(max, dp[right]);
      left++;
      right++;
    }
    return max;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.constrainedSubsetSum(new int[] {10, 2, -10, 5, 20}, 2);
  }
}
