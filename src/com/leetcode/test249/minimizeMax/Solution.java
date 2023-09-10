package com.leetcode.test249.minimizeMax;

import java.util.Arrays;

class Solution {

  public int minimizeMax (int[] nums, int p) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];
    int ans = Integer.MAX_VALUE;
    while (left <= right) {
      int mid = right + left;
      mid /= 2;

      if (isPossible(nums, p, mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  private boolean isPossible (int[] nums, int p, int mid) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] <= mid) {
        p--;
        i++;
      }
      if (p == 0)
        break;
    }
    return p == 0;
  }
}
