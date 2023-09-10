package com.leetcode.test206.integerBreak;

import java.util.HashMap;
import java.util.Map;

//343. Integer Break
class Solution {
  public int integerBreak (int n) {
    Map<String, Integer> dp = new HashMap<>();
    return helper(0, n, dp);
  }

  private int helper (int cur, int n, Map<String, Integer> dp) {
    String key = "" + cur + ":" + n;
    if (dp.containsKey(key)) {
      return dp.get(key);
    }
    if (n == 0) {
      dp.put(key, cur);
      return cur;
    } else {
      int max = 0;
      if (cur == 0)
        for (int i = 1; i < n; i++) {
          max = Math.max(max, helper(i * 1, n - i, dp));
        }
      else
        for (int i = 1; i <= n; i++) {
          max = Math.max(max, helper(i * cur, n - i, dp));
        }
      dp.put(key, max);
      return max;
    }
  }
}
