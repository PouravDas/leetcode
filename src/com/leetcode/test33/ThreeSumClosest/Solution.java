package com.leetcode.test33.ThreeSumClosest;

import java.util.Arrays;

public class Solution {

  public int threeSumClosest (int[] nums, int target) {

    Arrays.sort(nums);
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          return sum;
        }

        if (Math.abs(sum - target) < Math.abs(ans - target))
          ans = sum;

        if (sum > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return ans;
  }
}
