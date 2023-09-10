package com.leetcode.test98.SubarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

// # 992
// LTE
class Solution {
  public int subarraysWithKDistinct (int[] nums, int k) {
    int start = 0;
    int end = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    while (end < nums.length) {
      map.compute(nums[end], (key, v) -> v == null ? 1 : v + 1);
      end++;
      if (map.keySet().size() == k) {
        int startCopy = start;
        Map<Integer, Integer> mapCopy = new HashMap<>(map);
        while (mapCopy.keySet().size() == k) {
          count++;
          mapCopy.compute(nums[startCopy], (key, v) -> v != null && v > 1 ? v - 1 : null);
          startCopy++;
        }
      }
      if (map.keySet().size() > k) {
        while (start <= end && map.keySet().size() > k) {
          map.compute(nums[start], (key, v) -> v != null && v > 1 ? v - 1 : null);
          start++;
        }
        int startCopy = start;
        Map<Integer, Integer> mapCopy = new HashMap<>(map);
        while (mapCopy.keySet().size() == k) {
          count++;
          mapCopy.compute(nums[startCopy], (key, v) -> v != null && v > 1 ? v - 1 : null);
          startCopy++;
        }

      }
    }
    return count;
  }

  public static void main (String[] args) {
    Solution2 s = new Solution2();
    //int ans = s.subarraysWithKDistinct(new int[] {1, 2, 1, 2, 3}, 2);
    //int ans = s.subarraysWithKDistinct(new int[] {1, 2, 1, 3, 4}, 3);
    int ans = s.subarraysWithKDistinct(new int[] {1, 2}, 1);
    System.out.println(ans);
  }
}
