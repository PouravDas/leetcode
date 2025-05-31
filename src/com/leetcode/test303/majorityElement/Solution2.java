package com.leetcode.test303.majorityElement;

//169. Majority Element
public class Solution2 {
  public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int frequency = 0;
    for (int n : nums) {
      if (n == candidate) frequency++;
      else frequency--;
      if (frequency == 0) {
        candidate = n;
        frequency++;
      }
    }
    return candidate;
  }
}
