package com.leetcode.test250.minimumSize;

import java.util.Arrays;

//1760. Minimum Limit of Balls in a Bag
public class Solution {
  public int minimumSize (int[] nums, int maxOperations) {
    int left = 1;
    int right = 1000_000_000;
    while (left < right) {
      int mid = (left + right) / 2;
      int count = 0;
      for (int n : nums) {
        count += (n-1) / mid;
        if(count > maxOperations) break;
      }
      if(count > maxOperations) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
