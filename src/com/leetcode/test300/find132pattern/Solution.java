package com.leetcode.test300.find132pattern;

import java.util.Map;
import java.util.TreeMap;

//456. 132 Pattern
class Solution {
  public boolean find132pattern (int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap();
    for (int n : nums) {
      map.compute(n, (k, v) -> v == null ? 1 : v + 1);
    }
    int min = Integer.MAX_VALUE;
    remove(map, nums[0]);
    for (int i = 1; i < nums.length - 1; i++) {
      min = Math.min(min, nums[i - 1]);
      remove(map, nums[i]);
      int one = min;
      int three = nums[i];
      if (map.floorKey(nums[i] - 1) == null)
        continue;
      int two = map.floorKey(nums[i] - 1);
      if (one < three && two < three && one < two)
        return true;
    }
    return false;
  }

  void remove (Map<Integer, Integer> map, int r) {
    if (map.containsKey(r)) {
      if (map.get(r) == 1)
        map.remove(r);
      else
        map.put(r, map.get(r) - 1);
    }
  }
}
