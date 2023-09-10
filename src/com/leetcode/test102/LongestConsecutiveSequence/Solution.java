package com.leetcode.test102.LongestConsecutiveSequence;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//#128
class Solution {
  public int longestConsecutive (int[] nums) {
    if(nums.length == 0){
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, 1);
    }
    for (int n : nums) {
      if (map.containsKey(n)) {
        int currCount = map.get(n);
        int next = n + 1;
        while (map.containsKey(next)) {
          currCount += map.remove(next);
          next++;
        }
        map.put(n, currCount);
      }
    }
    return map.values().stream().max(Comparator.naturalOrder()).get();
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2});
  }
}
