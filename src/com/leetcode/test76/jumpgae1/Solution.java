package com.leetcode.test76.jumpgae1;

class Solution {
  public boolean canJump (int[] nums) {

    if (nums.length == 1)
      return true;

    if (nums.length > 0 && nums[0] == 0)
      return false;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        int idx = i;
        int needs = 0;
        boolean valid = false;
        while (idx > 0) {
          idx--;
          needs++;
          if (nums[idx] > needs) {
            valid = true;
            break;
          }
        }

        if (!valid)
          return false;
      }
    }
    return true;
  }
}
