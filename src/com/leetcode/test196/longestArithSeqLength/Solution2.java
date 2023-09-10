package com.leetcode.test196.longestArithSeqLength;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
  public int longestArithSeqLength (int[] nums) {
    int max = 0;
    Map<Integer, Integer>[] dp = new HashMap[nums.length];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = new HashMap<>();
      for (int j = 0; j < i; j++) {
        int diff = nums[i] - nums[j];
        dp[i].put(diff, 1 + dp[j].getOrDefault(diff, 1));
        max = Math.max(max, dp[i].get(diff));
      }
    }
    return max;
  }
}
