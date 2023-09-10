package com.leetcode.test171.hammingWeight;

// 191. Number of 1 Bits (easy)
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int ans =0;
    for (int i = 31; i >= 0 ; i--) {
      if((n & (1 << i)) != 0) ans++;
    }
    return ans;
  }
}
