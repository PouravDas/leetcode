package com.leetcode.test289.contest.first;

import java.util.List;

//
class Solution {
  public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
    int ans = 0;
    for (int i = 0; i < nums.size(); i++) {
      int idx = i;
      int bits = 0;
      while (idx > 0) {
        if((idx & 1) > 0) {
          bits++;
        }
        idx = idx >> 1;
      }
      if(bits == k) ans += nums.get(i);
    }
    return ans;
  }
}
