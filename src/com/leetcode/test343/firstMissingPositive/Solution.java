package com.leetcode.test343.firstMissingPositive;

public class Solution {
  public int firstMissingPositive_fucked(int[] nums) {
    int min = Integer.MAX_VALUE;
    int nonPosSiz = 0;
    for (int n : nums) {
      if (n > 0) min = Math.min(min, n);
      else nonPosSiz++;
    }
    if (nonPosSiz == nums.length) return 1;
    if (min > 1) return 1;
    int posStart = nonPosSiz;
    int cur = min;
    int last = nums.length - 1;
    System.out.println("posStart " + posStart);
    for (int i = 0; i < nums.length; i++) {

      if (cur < 1) {
        --nonPosSiz;
        int temp = nums[nonPosSiz];
        nums[nonPosSiz] = cur;
        cur = temp;
      } else {
        int position = posStart + cur - min;
        int temp = position < nums.length ? nums[position] : nums[last];
        if (position < nums.length)
          nums[position] = cur;
        else
          nums[last--] = cur;
        cur = temp;
      }
    }
    for (int i = posStart + 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] != 1) return nums[i - 1] + 1;
    }
    return nums[nums.length - 1] + 1;
  }

  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 1) nums[i] = nums.length + 10;
    }
    for (int i = 0; i < nums.length; i++) {
      if (Math.abs(nums[i]) <= nums.length) nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
    }

    for (int i = 1; i < nums.length + 1; i++) {
      if (nums[i - 1] > 0) return i;
    }
    return nums.length + 2;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999});
  }
}
