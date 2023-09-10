package com.leetcode.test215.longestSubsequenceWithDiff;

import java.util.HashMap;
import java.util.Map;

//1218. Longest Arithmetic Subsequence of Given Difference
class Solution {
  public int longestSubsequence (int[] arr, int difference) {
    Map<Integer, Integer> dp = new HashMap<>();
    int max = 0;
    for (int i : arr) {
      int val = 1 + dp.getOrDefault(i - difference, 0);
      dp.put(i, val);
      max = Math.max(max, val);
    }
    return max;
  }
}
