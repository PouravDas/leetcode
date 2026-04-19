package com.leetcode.test353.minimumCost;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int minimumCost(int[] nums) {
    int s1 = Integer.MAX_VALUE;
    int s2 = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      int c = nums[i];
      if(c <= s1) {
        s2 = s1;
        s1 = c;
        continue;
      }
      if(c <= s2) {
        s2 = c;
      }
    }
    return nums[0] + s1 + s2;
  }
}