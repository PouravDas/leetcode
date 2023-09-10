package com.leetcode.test183.topKFrequent;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public int[] topKFrequent (int[] nums, int k) {
    int[] ans = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.compute(i, (key, val) -> {
        return val == null ? 1 : val + 1;
      });
    }
    List<Integer> list = map.entrySet().stream()
        .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
        .map(Map.Entry::getKey).collect(Collectors.toList());
    for (int i = 0; i < k; i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
}
