package com.leetcode.test331.findMaxLength;

import java.util.HashMap;
import java.util.Map;

//525. Contiguous Array
// is related to prefix sum (subarraySum)
class Solution {
  public int findMaxLength(int[] nums) {
    int sum = 0;
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      sum += n == 0 ? -1 : n;
      if (map.containsKey(sum)) {
        max = Math.max(max, i - map.get(sum));
      } else map.put(sum, i);
    }
    return max;
  }
}
