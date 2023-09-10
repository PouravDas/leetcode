package com.leetcode.test27.makeArrayStrictlyIncreaing;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean canBeIncreasing (int[] nums) {

    Set<Integer> removed = new HashSet<Integer>();

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] >= nums[i + 1]) {
        if (i == 0 || removed.contains(i - 1)) {
          removed.add(i);
        } else if (removed.contains(i - 1) ? nums[i + 1] > nums[i - 2] : nums[i + 1] > nums[i - 1]) {
          removed.add(i);
        } else {
          removed.add(i + 1);
          if (i + 2 < nums.length && nums[i + 2] <= nums[i])
            return false;
          i++;
        } 
      }
      if (removed.size() > 1)
        return false;
    }
    return true;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    // [1,2,10,5,7]
    // 1,2,10,5,7
    // 2,3,1,2
    // [1,2,1]
    int[] nums = new int[] {1,2,1};
    boolean ans = s.canBeIncreasing(nums);
    System.out.println(ans);
  }
}
