package com.leetcode.test57.singleNumber2;

import java.util.ArrayList;
import java.util.List;

// question #260
class Solution {
  public int[] singleNumber (int[] nums) {

    int xor = 0;
    for (int n : nums) {
      xor ^= n;
    }

    int firstBitChanged = 0;
    while ((xor & (1 << firstBitChanged)) == 0) {
      firstBitChanged++;
    }
    int a = 0, b = 0;

    for (int n : nums) {
      if ((n & (1 << firstBitChanged)) == 0) {
        a ^= n;
      } else {
        b ^= n;
      }
    }

    return new int[] {a, b};
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.singleNumber(new int[]{1,2,1,3,2,5});
  }
}
