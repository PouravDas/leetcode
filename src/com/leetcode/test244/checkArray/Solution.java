package com.leetcode.test244.checkArray;

//2772. Apply Operations to Make All Array Elements Equal to Zero
class Solution {
  public boolean checkArray (int[] nums, int k) {
    int left = 0, right = k - 1;
    while (right < nums.length) {
      int first = nums[left];
      if (first > 0)
        for (int i = left; i <= right; i++) {
          nums[i] -= first;
          if (nums[i] < 0)
            return false;
        }
      left++;
      right++;
    }
    for (int i = left; i < nums.length; i++) {
      if (nums[i] != 0)
        return false;
    }
    return true;
  }
}
