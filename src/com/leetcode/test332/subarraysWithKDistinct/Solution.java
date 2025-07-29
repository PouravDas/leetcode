package com.leetcode.test332.subarraysWithKDistinct;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int subarraysWithKDistinct(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int l = 0, r = 0;
    while (r < nums.length) {
      while (r < nums.length && map.size() <= k) {
        addToMap(map, nums[r]);
        r++;
      }
      count += countAll(nums, k, l, r - 1);
      if (r == nums.length) break;
      while (l < nums.length && map.size() > k) {
        removeFromMap(map, nums[l]);
        l++;
      }
    }
    return count;
  }

  private void removeFromMap(Map<Integer, Integer> map, int num) {
    if (map.get(num) == 1) map.remove(num);
    else map.compute(num, (k, v) -> v - 1);
  }

  private int countAll(int[] nums, int k, int l, int r) {
    int count = 0;
    int size = r - l + 1;
    if (size == k) return 1;
    for (int length = k; length <= size; length++) {
      int start = l;
      int end = l;
      Map<Integer, Integer> map = new HashMap<>();
      while (end - start + 1 <= length)
        addToMap(map, nums[end++]);
      while (end <= r) {
        if (map.size() == k) count++;
        addToMap(map, nums[end++]);
        removeFromMap(map, nums[start++]);
      }
      if (map.size() == k) count++;
    }
    return count;
  }

  private void addToMap(Map<Integer, Integer> map, int num) {
    map.compute(num, (k, v) -> v == null ? 1 : v + 1);
  }

  private boolean canAdd(Map<Integer, Integer> map, int num, int k) {
    if (map.size() > k) return false;
    if (map.size() < k) return true;
    else return map.containsKey(num);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //int i = s.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    int i = s.subarraysWithKDistinct(new int[]{2,1,1,1,2}, 1);
    System.out.println(i);
  }
}
