package com.leetcode.test195.wiggleSort;

import java.util.Arrays;

//324. Wiggle Sort II
class Solution {
  public void wiggleSort (int[] nums) {
    int[] copy = Arrays.copyOf(nums, nums.length);
    Arrays.sort(copy);
    int l = (nums.length + 1) / 2, r = nums.length - 1;
    int idx = 0;
    while (idx < nums.length) {
      nums[idx++] = copy[l--];
      if (idx != nums.length)
        nums[idx++] = copy[r--];
    }
  }
}
