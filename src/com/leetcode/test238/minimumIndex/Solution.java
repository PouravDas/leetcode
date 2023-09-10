package com.leetcode.test238.minimumIndex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2780. Minimum Index of a Valid Split
class Solution {
  public int minimumIndex (List<Integer> nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums)
      map.compute(n, (k, v) -> v == null ? 1 : v + 1);
    Map<Integer, Integer> currMap = new HashMap<>();
    for (int i = 0; i < nums.size(); i++) {
      int n = nums.get(i);
      currMap.compute(n, (k, v) -> v == null ? 1 : v + 1);
      if (currMap.get(n) * 2 > i + 1 && ((map.get(n) - currMap.get(n)) * 2 > nums.size() - i - 1))
        return i;
    }
    return -1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minimumIndex(List.of(1,2,2,2));
  }
}
