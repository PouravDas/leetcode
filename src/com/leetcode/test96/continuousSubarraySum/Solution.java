package com.leetcode.test96.continuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

// # 560
class Solution {
  public boolean checkSubarraySum (int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int runningSum = 0;
    for (int i = 0; i < nums.length; i++) {
      runningSum += nums[i];
      if (map.get(runningSum % k) != null) {
        if (i - map.get(runningSum % k) > 1)
          return true;
      } else {
        map.put(runningSum % k, i);
      }
    }
    return false;
  }
}
