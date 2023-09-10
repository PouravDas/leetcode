package com.leetcode.test253.contest.third;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
  public int minAbsoluteDifference (List<Integer> nums, int x) {
    TreeMap<Integer, Integer> map = new TreeMap();
    for (int n : nums) {
      addToMap(map, n);
    }
    for (int i = 0; i < x; i++) {
      removeMap(map, nums.get(i));
    }
    int currEnd = x;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.size() - x; i++) {
      int ceil = map.ceilingKey(nums.get(i)) == null ? Integer.MIN_VALUE : map.ceilingKey(nums.get(i));
      int floor = map.floorKey(nums.get(i)) == null ? Integer.MIN_VALUE : map.floorKey(nums.get(i));
      min = Math.min(min, Math.min(Math.abs(ceil - nums.get(i)), Math.abs(floor - nums.get(i))));
      removeMap(map, nums.get(currEnd++));
    }
    return min;
  }

  void addToMap (Map<Integer, Integer> map, int n) {
    map.compute(n, (k, v) -> v == null ? 1 : v + 1);
  }

  void removeMap (Map<Integer, Integer> map, int n) {
    map.compute(n, (k, v) -> v == null ? null : v == 1 ? null : v - 1);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minAbsoluteDifference(List.of(97,8,189,194),2);
  }
}
