package com.leetcode.test95.subarraySum;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraySum (int[] nums, int k) {
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    for (int n : nums) {
      sum += n;
      if (map.get(sum - k) != null)
        ans += map.get(sum - k);
      map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
    }
    return ans;
  }
}
