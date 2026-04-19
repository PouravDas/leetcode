package com.leetcode.test355.minimumDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int minimumDistance(int[] nums) {
    int ans = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      int finalI = i;
      map.compute(n, (k, v) -> {
        if (v == null) {
          v = new ArrayList<>();
        }
        v.add(finalI);
        return v;
      });
      List<Integer> list = map.get(n);
      if (list.size() > 2) {
        int candidate = list.getLast() - list.get(list.size() - 3);
        ans = Math.min(candidate, ans);
      }
    }
    return Integer.MAX_VALUE == ans ? -1 : ans + ans;
  }
}