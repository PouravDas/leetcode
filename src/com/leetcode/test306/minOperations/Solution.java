package com.leetcode.test306.minOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2009. Minimum Number of Operations to Make Array Continuous
//hard
class Solution {
  public int minOperations (int[] nums) {
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<>(nums.length);
    for (int n : nums) {
      if (list.isEmpty() || list.get(list.size() - 1) != n)
        list.add(n);
    }

    int ans = Integer.MAX_VALUE;

    int l = 0;
    int r = 0;
    while (l != list.size()) {
      while (r < list.size() && list.get(r) <= list.get(l) + nums.length - 1)
        r++;
      ans = Math.min(ans, nums.length - (r - l));
      l++;
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minOperations(new int[] {1, 2, 3, 5, 6});
  }
}
