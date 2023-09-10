package com.leetcode.test115.largestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#368
class Solution {
  public List<Integer> largestDivisibleSubset (int[] nums) {
    List<Integer> list = new ArrayList<>();
    if (nums.length == 1) {
      list.add(nums[0]);
      return list;
    }
    Arrays.sort(nums);
    int[] l = new int[nums.length];
    int[] prev = new int[nums.length];
    int max = 0;
    int maxIdx = -1;
    for (int i = 0; i < nums.length; i++) {
      l[i] = 1;
      boolean found = false;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          if (l[i] < (l[j] + 1)) {
            l[i] = l[j] + 1;
            prev[i] = j;
            if (l[i] > max) {
              max = l[i];
              maxIdx = i;
            }
            found = true;
          }
        }
      }
      if (!found) {
        prev[i] = -1;
      }
    }
    if (maxIdx != -1) {
      while (maxIdx != -1) {
        list.add(nums[maxIdx]);
        maxIdx = prev[maxIdx];
      }
    } else {
      list.add(nums[0]);
    }
    return list;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.largestDivisibleSubset(new int[] {1, 4, 16, 7, 8});
  }
}
