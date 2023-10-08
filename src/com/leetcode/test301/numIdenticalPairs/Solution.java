package com.leetcode.test301.numIdenticalPairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int n : nums) {
      map.compute(n, (k,v) -> v == null ? 1 : v + 1);
    }
    int ans = 0;
    for(Map.Entry<Integer, Integer> e : map.entrySet()) {
      if(e.getValue() > 1) {
        ans += (e.getValue() - 1) * (e.getValue()) / 2;
      }
    }
    return ans;
  }
}

