package com.leetcode.test98.SubarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

  public int subarraysWithKDistinct (int[] nums, int k) {
    Map<Integer, Integer> largeMap = new HashMap<>();
    Map<Integer, Integer> smallMap = new HashMap<>();
    int start = 0;
    int lPointer = 0;
    int sPointer = 0;
    int count = 0;
    while (true) {
      while (lPointer < nums.length && largeMap.keySet().size() <= k) {
        largeMap.compute(nums[lPointer++], (key, v) -> v == null ? 1 : v + 1);
      }
      if (lPointer == nums.length) {
        if (largeMap.keySet().size() == k + 1) {
          largeMap.compute(nums[--lPointer], (key, v) -> v == 1 ? null : v - 1);
        } else if (largeMap.keySet().size() < k) {
          return count;
        }
      } else {
        largeMap.compute(nums[--lPointer], (key, v) -> v == 1 ? null : v - 1);
      }
      sPointer = Math.max(sPointer,start);
      while (sPointer < nums.length && smallMap.keySet().size() <= k - 1) {
        smallMap.compute(nums[sPointer++], (key, v) -> v == null ? 1 : v + 1);
      }
      smallMap.compute(nums[--sPointer], (key, v) -> v == 1 ? null : v - 1);

      count += lPointer - sPointer;

      largeMap.compute(nums[start], (key, v) -> v == 1 ? null : v - 1);
      smallMap.compute(nums[start], (key, v) -> v == null || v == 1 ? null : v - 1);
      start++;
    }
  }
}
