package com.leetcode.test170.reverseBits;

// 190. Reverse Bits (easy)
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int ans = 0;
    for (int i = 31, j =0; i > -1; i--,j++) {
      if((n & (1 << i)) != 0) {
        ans = ans | (1 << j);
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    System.out.println();
    s.reverseBits(-3);
  }
}
