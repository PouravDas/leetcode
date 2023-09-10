package com.leetcode.test277.minimumReplacement;

//2366. Minimum Replacements to Sort the Array
//hard
class Solution {
  public long minimumReplacement (int[] nums) {
    long ans = 0;
    if (nums.length == 1)
      return 0;
    int prev = nums[nums.length - 1];
    for (int i = nums.length - 2; i > -1; i--) {
      int cur = nums[i];
      if (cur <= prev) {
        prev = cur;
        continue;
      }
      int next = i == 0 ? 0 : nums[i - 1];
      int ops = 0;
      if (cur % prev == 0) {
        ops = cur / prev - 1;
      } else {
        int noOfPrev = cur / prev;
        int val = prev;
        int rem = cur % prev;
        ops = cur / prev;
        while (rem < next && rem < val) {
          if (rem + noOfPrev <= next && rem + noOfPrev <= val - 1) {
            rem += noOfPrev;
            val--;
          } else {
            rem = val - 1;
            break;
          }
        }
        prev = rem;
      }
      ans += ops;
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.minimumReplacement(new int[] {19, 7, 2, 24, 11, 16, 1, 11, 23});
  }
}
