package com.leetcode.test325.singleNumber;

//136. Single Number
public class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int n : nums)
      ans ^= n;
    return ans;
  }
}