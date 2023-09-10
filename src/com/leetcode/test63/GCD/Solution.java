package com.leetcode.test63.GCD;

class Solution {
  public int findGCD (int[] nums) {
    int max = nums[0];
    int min = nums[0];
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    return findGCD(min, max);
  }

  public int findGCD (int a, int b) {
    return b == 0 ? a : findGCD(b, a%b);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.findGCD(new int[] {2, 5, 6, 9, 10});

    System.out.println(s.findGCD(25,27));
    System.out.println(ans);
  }


}
