package com.leetcode.test324.minBitFlips;

// 2220. Minimum Bit Flips to Convert Number
public class Solution {
  public int minBitFlips(int start, int goal) {
    int temp = start ^ goal;
    int count = 0;
    while(temp != 0) {
      if((temp & 1) == 1) count++;
      temp = temp >> 1;
    }
    return count;
  }
}